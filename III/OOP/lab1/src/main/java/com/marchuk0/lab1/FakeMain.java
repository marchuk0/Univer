package com.marchuk0.lab1;

import javafx.collections.FXCollections;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FakeMain {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        while (true) {
//            String str = reader.readLine();
//            System.out.println(SpreadSheetHelper.evalExpression(str));
//            SpreadSheetHelper.replaceVariables(str);
        try (FileOutputStream fin = new FileOutputStream("/home/olexander/123.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fin);) {
            HashMap<String, Cell> toWriteObject = new HashMap<>();
            toWriteObject.put("123", new Cell(1, 123));
            oos.writeObject(toWriteObject);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        }
    }
}
