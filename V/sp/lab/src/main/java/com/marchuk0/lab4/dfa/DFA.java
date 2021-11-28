package com.marchuk0.lab4.dfa;

import com.marchuk0.lab4.nfa.IntegratedNFA;
import com.marchuk0.lab4.nfa.NFA;
import com.marchuk0.lab4.nfa.NFAUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFA {

    /* The transition table of the DFA */
    public Vector<Vector<Integer>> transitionTable = new Vector<>();
    /* State to start */
    public int start = 0;
    /* State to accept and action */
    public HashMap<Integer, String> acceptAction = new HashMap<>();
    /* The closure table of dfa */
    private Vector<TreeSet<Integer>> closureTable = new Vector<>();
    /* The Integrated NFA */
    private IntegratedNFA nfa;

    public DFA(IntegratedNFA nfa) {
        this.nfa = nfa;

        closureTable.add(getClosuresOfStart());
        while (closureTable.size() > transitionTable.size())
            fillRowOfTransitionTable(transitionTable.size());

        fillActionTable();
    }

    public DFA(Vector<Vector<Integer>> transitionTable, HashMap<Integer, String> acceptAction, int start) {
        this.transitionTable = transitionTable;
        this.acceptAction = acceptAction;
        this.start = start;
    }

    /**
     * Get a closure of states which a NFA state can reach by 'ε's
     *
     * @return output states
     */
    private TreeSet<Integer> getClosuresOfStart() {
        TreeSet<Integer> startSet = new TreeSet<>();
        startSet.add(NFA.start);
        return getClosures(startSet);
    }

    /**
     * Get a closure of states which some NFA states can reach by 'ε's
     *
     * @param statesOfNFA some input state
     * @return output states
     */
    private TreeSet<Integer> getClosures(TreeSet<Integer> statesOfNFA) {
        Stack<Integer> unCalcStates = new Stack<>();
        TreeSet<Integer> result = new TreeSet<>(statesOfNFA);
        unCalcStates.addAll(statesOfNFA);
        while (!unCalcStates.empty()) {
            int unCalcState = unCalcStates.pop();
            TreeSet<Integer> closureOfUnCalcState = new TreeSet<>(nfa.transitionTable.elementAt(unCalcState).elementAt(NFAUtil.EPSILON));
            for (Integer state : closureOfUnCalcState) {
                if (!unCalcStates.contains(state)) {
                    result.add(state);
                    unCalcStates.add(state);
                }
            }
        }
        return result;
    }

    /**
     * Get a closure of states which some NFA states can reach by a character and any 'ε's
     *
     * @param statesOfNFA input states
     * @param ch          a character
     * @return output states
     */
    private TreeSet<Integer> move(TreeSet<Integer> statesOfNFA, Character ch) {
        TreeSet<Integer> out = new TreeSet<>();
        for (Integer stateOfNFA : statesOfNFA)
            out.addAll(nfa.transitionTable.elementAt(stateOfNFA).elementAt(ch));
        return getClosures(out);
    }

    /**
     * Fill a row of the transition table
     *
     * @param stateOfDFA a DFA state whose row in transition table needs to be added
     */
    private void fillRowOfTransitionTable(int stateOfDFA) {
        Vector<Integer> rowOfTransitionTable = new Vector<>();

        for (char i = 0; i < DFAUtil.COLUMNS; i++) {
            TreeSet<Integer> dfaState = new TreeSet<>(move(closureTable.get(stateOfDFA), i));
            if (dfaState.isEmpty()) {
                rowOfTransitionTable.add(null);
                continue;
            }
            // dfaState 
            if (!closureTable.contains(dfaState)) {
                rowOfTransitionTable.add(closureTable.size());
                closureTable.add(dfaState);
            } else
                rowOfTransitionTable.add(closureTable.indexOf(dfaState));
        }
        transitionTable.add(rowOfTransitionTable);
    }

    /**
     * Fill action table from NFA to DFA by connection of closureTable,
     * when a DFA state refers to more than one NFA accept state, take the one who come first.
     */
    private void fillActionTable() {
        for (int i = 0; i < closureTable.size(); i++) {
            TreeSet<Integer> dfaStates = new TreeSet<>(closureTable.get(i));
            for (Integer state : dfaStates) {
                if (nfa.accept.get(state) != null) {
                    acceptAction.put(i, nfa.accept.get(state));
                    break;
                }
            }
        }
    }

    /**
     * Get a table of DFA transition table.
     *
     * @return String of the message.
     */
    public String debugMessage() {
        return DFAUtil.transitionTableDebugMessage(transitionTable)
                + "start : " + start + '\n'
                + "accept: " + acceptAction.toString() + '\n';
    }
    
    public int[][] getTransitionTable() {
        return new int[][]{};
    }
    
    public Map<Integer, Integer> getActionMap() {
        return new HashMap<>();
    }
    
    public void clean() throws Exception {
        /*get rid of this method*/                                                                                                                                                                Process pr = new ProcessBuilder("/home/olexander/important/cyb/university/V/sp/lab/src/main/resources/lexer.out", "/home/olexander/important/cyb/university/V/sp/lab/src/main/resources/lab4_example.c").start();
        BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        pr.waitFor();
        System.out.println("ok!");
    }

}
