package com.marchuk0.lab4;

import com.marchuk0.lab4.dfa.DFA;
import com.marchuk0.lab4.dfa.DFAUtil;
import com.marchuk0.lab4.io.LexFile;
import com.marchuk0.lab4.nfa.IntegratedNFA;


public class Main {
    public static void main(String[] args) throws Exception {
        int[] a = new int[]{2, 1}; // 9
        findKthLargest(a, 1);
        log(a);
    }
//    [3,2,3,1,2,4,5,5,6]
//        4

    static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        int l = 0, r = n-1;
        while (l<r) {
            int pos = partition(l, r, nums);
            if(pos==k) return nums[pos];
            if(pos<k) {
                l = pos+1;
            } else {
                r = pos-1;
            }
        }
        return 0;
    }

    static int partition(int l, int r, int[] a) {
        int pos = l;
        int mid = a[l];
        l++;
        while (l<=r) {
            while (a[l] < mid) {
                l++;
            }
            while(a[r] > mid) {
                r--;
            }
            if (l <= r) {
                swap(l, r, a);
                l++;
                r--;
            }

        }
        swap(pos, r, a);
        return r;
    }

    static void swap(int i,int j, int[] a) {
        int mem = a[i];
        a[i] = a[j];
        a[j] = mem;
    }

    static void log(int[] a) {
        for(int i = 0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
}
