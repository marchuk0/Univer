package com.marchuk0.lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    private static final File resourcesDirectory = new File("src/main/resources");

    public static boolean checkUniqueLetters(String word) {
        Set<Character> set = new HashSet<>();
        String lowerCaseWord = word.toLowerCase();
        for (int i = 0; i < lowerCaseWord.length(); i++) {
            char ch = lowerCaseWord.charAt(i);
            
            if (ch < 'a' || ch > 'z') {
                continue;
            }
            if (set.contains(ch)) {
                return false;
            }

            set.add(ch);
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(resourcesDirectory, "lab1_file.txt"));
        scanner.useDelimiter(Pattern.compile("[.,:;()?!\" \\t\\n\\r]+"));
        Set<String> set = new HashSet<>();
        
        while (scanner.hasNext()) {
            String word = scanner.next();
            String trimWord = word.substring(0, Math.min(word.length(), 30));
            
            if (checkUniqueLetters(trimWord)) {
                set.add(trimWord);
            }
        }
        
        for(String str : set) {
            System.out.println(str);
        }
    }
}
