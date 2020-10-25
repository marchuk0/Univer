package com.marchuk0.lab1;

import com.marchuk0.lab1.antlr4.SpreadSheetLexer;
import com.marchuk0.lab1.antlr4.SpreadSheetParser;
import com.marchuk0.lab1.antlr4.implementations.SpreadSheetSuperVisitor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpreadSheetHelper {
    private final static String ROW_LETTER = "R";
    private final static String COLUMN_LETTER = "C";
    private final static String START_CHAR = "=";
    private final static String ZERO_COLUMN_NAME = "";

    public static final ObservableList<HashMap<String, Cell>> table = FXCollections.observableArrayList();


    public static String intToColumnNumber(int i) {
        if (i <= 0) {
            return ZERO_COLUMN_NAME;
        }
        return COLUMN_LETTER + i;
    }

    public static String intToRowNumber(int i) {
        return ROW_LETTER + i;
    }


    public static int NumberToInt(String number) {
        return Integer.parseInt(number.substring(1));
    }

    public static String evalExpression(String expression) {
        if (expression.startsWith(START_CHAR)) {
            expression = replaceVariables(expression);
            System.out.println(expression);
            return evalFormula(expression);
        } else {
            return expression;
        }
    }

    public static String replaceVariables(String expression) {
        Pattern pattern = Pattern.compile("(R)([0-9]+)(C)([0-9]+)");
        Matcher matcher = pattern.matcher(expression);

        String integerString = matcher.replaceAll(matchResult -> {
            String cellString = matchResult.group();
            String[] rowAndColumn = cellString.replace(ROW_LETTER, "").split(COLUMN_LETTER);
            return table.get(Integer.parseInt(rowAndColumn[0])).get(COLUMN_LETTER + rowAndColumn[1]).getCalculatedValue();
        });
        return integerString;
    }


    private static String evalFormula(String formula) {
        CharStream stream = CharStreams.fromString(formula);
        SpreadSheetLexer lexer = new SpreadSheetLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SpreadSheetParser parser = new SpreadSheetParser(tokens);
        parser.addErrorListener(new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                throw new RuntimeException();
            }

            @Override
            public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
            }

            @Override
            public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
            }

            @Override
            public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
            }
        });
        ParseTree tree = parser.formula();
        Integer value = new SpreadSheetSuperVisitor().visit(tree);
        return value.toString();
    }

}
