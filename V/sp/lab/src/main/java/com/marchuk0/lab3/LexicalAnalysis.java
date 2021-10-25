package com.marchuk0.lab3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalysis {
    private static final String STRING_LITERAL = "\"(?:\\\\\"|[^\"])*?\"";
    private static final String COMMENT = "//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/";
    private static final String KEYWORD = "\\bif|\\bint|\\blong|\\bfloat|\\bdouble|\\bchar|\\bfor|\\belse|\\bprivate" +
        "|\\bpublic|\\bstatic|\\bvoid|\\bvolatile|\\bimport|\\bpackage|\\bthis|\\binstanceof|\\bnew|\\bclass|\\btry" +
        "|\\bcatch";
    private static final String CHAR = "'(\\\\['\"tvrnafb\\\\]|[^'\\\\])'";
    private static final String CHAR_ERROR = "[ ]*'..'";
    private static final String IDENTIFIER = "\\b(?!" + KEYWORD + "|" + STRING_LITERAL + ")[_A-Za-z][0-9A-Za-z_]*";
    private static final String OPERATOR = "<(?!=)|" +
        "\\.|" +
        ">(?!=)|" +
        "<=|" +
        ">=|" +
        "!=|" +
        "(?<![<>!=+-/%&^|])=|" +
        "==|" +
        "!(?!=)|" +
        "\\+(?!\\+)|" +
        "-(?!-)|" +
        "\\*|" +
        "/|" +
        "%|" +
        "\\+\\+|" +
        "--|" +
        "&&|" +
        "(?!&)&|" +
        "~|" +
        "<<|" +
        ">>(?!>)|" +
        ">>>|" +
        "\\[|" +
        "]";
    private static final String DECIMAL_LITERAL = "\\b([0-9]*[.]?[0-9]+([eE][-+]?[0-9]+)?)";
    private static final String BIN_LITERAL = "\\b(0b|0B)[0-1]*";
    private static final String OCT_LITERAL = "\\b0[0-7]*";
    private static final String HEX_LITERAL = "\\b(0x|0X)[0-9A-Fa-f]*";
    private static final String BOOL_LITERAL = "(?<!\\w)(false|true)(?!\\w)";
    private static final String DELIMITER = "[(){};,]";

    public static void main(String[] args) throws IOException {
        Path path = Path.of(Objects.requireNonNull(LexicalAnalysis.class.getClassLoader().getResource("lab3_file.txt")).getPath());
        String text = Files.readString(path);
        analyze(text);
    }

    private static void analyze(String text) {
        text = text.replaceAll(COMMENT, "$1 ");
        System.out.println(text);

        List<PatternWithName> patterns = new ArrayList<>();
        patterns.add(new PatternWithName(Pattern.compile(STRING_LITERAL), "string literal"));
        patterns.add(new PatternWithName(Pattern.compile(CHAR), "char"));
        patterns.add(new PatternWithName(Pattern.compile(CHAR_ERROR), "char error"));
        patterns.add(new PatternWithName(Pattern.compile(KEYWORD), "keyword"));
        patterns.add(new PatternWithName(Pattern.compile(IDENTIFIER), "identifier"));
        patterns.add(new PatternWithName(Pattern.compile(OPERATOR), "operator"));
        patterns.add(new PatternWithName(Pattern.compile(DECIMAL_LITERAL), "decimal literal"));
        patterns.add(new PatternWithName(Pattern.compile(BIN_LITERAL), "binary literal"));
        patterns.add(new PatternWithName(Pattern.compile(OCT_LITERAL), "oct literal"));
        patterns.add(new PatternWithName(Pattern.compile(HEX_LITERAL), "hex literal"));
        patterns.add(new PatternWithName(Pattern.compile(BOOL_LITERAL), "bool keyword"));
        patterns.add(new PatternWithName(Pattern.compile(DELIMITER), "delimiter"));

        List<Token> tokens = new ArrayList<>();
        boolean[] matched = new boolean[text.length()];
        for (PatternWithName pattern : patterns) {
            Matcher m = pattern.pattern.matcher(text);
            while (m.find()) {
                if (match(matched, m.start(), m.end() - 1)) {
                    tokens.add(new Token(m.start(), m.group(0), pattern.name));
                }
            }
        }
        tokens.sort(Comparator.comparingInt(o -> o.start));
        for (Token token : tokens) {
            System.out.println(token.value + " - " + token.type);
        }
    }

    private static boolean match(boolean[] matched, int l, int r) {
        assert l <= r;
        for (int i = l; i <= r; i++) {
            if (matched[i]) {
                return false;
            }
            matched[i] = true;
        }
        return true;
    }

    record PatternWithName(Pattern pattern, String name) {
    }

    record Token(Integer start, String value, String type) {
    }

}