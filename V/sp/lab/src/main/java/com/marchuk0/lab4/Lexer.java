package com.marchuk0.lab4;

import com.marchuk0.lab4.dfa.DFA;

import java.io.*;
import java.util.Map;

public class Lexer {
    private final DFA dfa;
    private int[][] transitionTable;
    private Map<Integer, Integer> actionsMap; 
    private File file;
    StringBuilder yytext;
    int yylength;
    BufferedReader reader;

    public Lexer(DFA dfa, String filepath) {
        this.dfa = dfa;
        this.transitionTable = dfa.getTransitionTable();
        this.actionsMap = dfa.getActionMap();
        this.file = new File(filepath);
    }

    public void parse() throws Exception {
        int id;
        
        if (!file.exists()) {
            throw new IOException("File does not exists.");
        }
        reader = new BufferedReader(new FileReader(file));
        while ((id = yylex()) >= 0) {
            System.out.println(String.format("%s%s%s%s", "Match word: ", yytext, "\tID: ", id));
        }
        finish();
    }


    private int yylex() {
        int state = 85;
        int nextChar = 0;
        yytext = new StringBuilder();
        yylength = 0;
        int lastAccept = -1;
        int lastLength = 0;

        while (true) {
            if (nextChar == 0)
                if (0 == yylength)
                    return -1;
                else
                    state = -1;
            else {
                state = transitionTable[state][nextChar];
                yytext = yytext.append((char) nextChar);
                yylength++;
                if (actionsMap.containsKey(state)) {
                    lastAccept = state;
                    lastLength = yylength;
                }
            }
            if (state == -1) {
                while (yylength > lastLength + (lastAccept == -1 ? 1 : 0)) {
                    yytext.deleteCharAt(yytext.length() - 1);
                    yylength--;
                    return acceptDefault();
                }
            }
        }
//        return 0;
    }

    private int acceptDefault() {
        if (yytext.length() != yylength) {
            return 0;
        } else {
            return -1;
        }
    }

    private void finish() throws Exception {
        dfa.clean();
        reader.close();
    }

}
