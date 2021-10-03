package com.marchuk0.lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class NFA {
    final Set<Character> alphabet = new HashSet<>();
    final int statesNumber;
    final int startState;
    final Set<Integer> finalStates = new HashSet<>();
    final Map<Integer, Map<Character, Set<Integer>>> transitions = new HashMap();

    public NFA(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int alphabetSize = scanner.nextInt();
        for (int i = 0; i < alphabetSize; i++) {
            alphabet.add((char) ('a' + i));
        }
        statesNumber = scanner.nextInt();
        startState = scanner.nextInt();

        int finalStatesNum = scanner.nextInt();
        for (int i = 0; i < finalStatesNum; i++) {
            int finalState = scanner.nextInt();
            finalStates.add(finalState);
        }

        while (scanner.hasNext()) {
            int from = scanner.nextInt();
            char symbol = scanner.next().charAt(0);
            int to = scanner.nextInt();
            Map<Character, Set<Integer>> toStates = transitions.computeIfAbsent(from, k -> new HashMap<>());
            toStates.computeIfAbsent(symbol, s -> new HashSet<>()).add(to);
        }
    }

    /**
     * @param k length of the word
     * @return true if possible, false otherwise
     */
    public boolean checkAllWords(int k) {
        try {
            Set<Integer> states = Collections.singleton(startState);
            recursiveCheck(k, states, new Stack<>());
            System.out.println("All words of length " + k + " are recognizeable.");
            return true;
        } catch (RecursiveCheckFailed e) {
            System.out.println("Found unrecognizable word of length " + k + " word: " + e.word);
            return false;
        }
    }

    private void recursiveCheck(int steps, Set<Integer> states, Stack<Character> prefix) throws RecursiveCheckFailed {
        if (steps <= 0) {
            for (Integer i : finalStates) {
                if (states.contains(i)) return;
            }
            StringBuilder sb = new StringBuilder();
            for (char ch : prefix) {
                sb.append(ch);
            }
            throw new RecursiveCheckFailed(sb.toString());
        } else {
            for (Character ch : alphabet) {
                Set<Integer> newStates = doOneStepFromStates(states, ch);
                prefix.add(ch);
                recursiveCheck(steps - 1, newStates, prefix);
                prefix.pop();
            }
        }
    }

    private Set<Integer> doOneStepFromStates(Set<Integer> states, char symbol) {
        Set<Integer> result = new HashSet<>();
        for (int state : states) {
            result.addAll(doOneStepFromState(state, symbol));
        }
        return result;
    }

    private Set<Integer> doOneStepFromState(int state, char symbol) {
        return transitions.getOrDefault(state, Collections.emptyMap()).getOrDefault(symbol, Collections.emptySet());
    }

    private static class RecursiveCheckFailed extends Exception {
        public final String word;

        RecursiveCheckFailed(String word) {
            this.word = word;
        }
    }
}
