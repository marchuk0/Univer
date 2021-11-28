package com.marchuk0.lab4.io;

import com.marchuk0.lab4.dfa.DFA;
import com.marchuk0.lab4.dfa.DFAUtil;

import java.util.Map;

public class CodeFileUtil {
    private final DFA dfa;

    public CodeFileUtil(DFA dfa) {
        this.dfa = dfa;
    }

    public String generate() {
        String head = """
            #include <iostream>
            #include <string>
            #include <unordered_map>
            #include "yy.tab.h"
            using namespace std;
            string yytext;
            unsigned int yylength;
            FILE* yyin = stdin;
            FILE* yyout = stdout;
            """.stripIndent();
        return head + '\n' +
            transitionTable() + '\n' +
            acceptFunctions() + '\n' +
            actionMap() + '\n' +
            yylex() + '\n';
    }

    private String acceptFunctions() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, String> entry : dfa.acceptAction.entrySet()) {
            builder.append(String.format("""
                int accept%s() {
                    %s
                    return 0;
                }
                """, entry.getKey(), entry.getValue()).stripIndent());
            builder.append('\n');
        }
        builder.append("""
            int acceptDefault() {
                cout << yytext << ":unknown" << endl;
                return 0;
            }
            """.stripIndent());
        return builder.toString();
    }

    String actionMap() {
        var builder = new StringBuilder("unordered_map<int, int(*)()> actionMap = {");
        for (Map.Entry<Integer, String> entry : dfa.acceptAction.entrySet()) {
            builder.append(String.format("\n\t{%s,accept%s},", entry.getKey(), entry.getKey()));
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("\n};");
        return builder.toString();
    }

    private String yylex() {
        
        return String.format("""
            int yylex() {
                int state = %s;
                int nextChar;
                yytext = "";
                yylength = 0;
                int lastAccept = -1;
                unsigned int lastLength = 0;

                while (true) {
                    if (stdin == yyin)
                        nextChar = cin.get();
                    else
                        nextChar = fgetc(yyin);
                    if (nextChar == EOF)
                        if (0 == yylength)
                            return -1;
                        else
                            state = -1;
                    else
                    {
                        state = transitionTable[state][nextChar];
                        yytext.push_back(nextChar);
                        yylength++;
                        if (actionMap.find(state) != actionMap.end()) {
                            lastAccept = state;
                            lastLength = yylength;
                        }
                    }
                    if (state == -1) {
                        while (yylength > lastLength + (lastAccept == -1)) {
                            if (stdin == yyin)
                                cin.unget();
                            else
                                fseek(yyin, -1, SEEK_CUR);
                            yytext.pop_back();
                            yylength--;
                        }
                        if (lastAccept == -1)
                            return acceptDefault();
                        else
                            return actionMap.at(lastAccept)();
                    }
                }
                return 0;
            }
            """, dfa.start).stripIndent();
    }

    private String transitionTable() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("const int transitionTable[%s][%s] = {", dfa.transitionTable.size(), DFAUtil.COLUMNS));
        for (var row : dfa.transitionTable) {
            builder.append("\n\t");
            for (var state : row) {
                builder.append(state == null ? -1 : state).append(',');
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("\n};");
        return builder.toString();
    }
}