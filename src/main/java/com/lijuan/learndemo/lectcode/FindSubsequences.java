
package com.lijuan.learndemo.lectcode;

import java.util.*;

public class FindSubsequences {

    public static List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>(nums[0]);
            List<List<Integer>> ret = new ArrayList<>();
            ret.add(list);
            return ret;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int val = nums[i];
            if (val >= stack.peek()) {
                stack.push(val);
            }
        }
        if (stack.size() == 1) {
            return null;
        }
        int n = stack.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put((int) Math.pow(2, i), i);
        }
        int size = (int) Math.pow(2, n);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> seq = getSeq(i, stack, map);
            if (seq.size() == 0) {
                continue;
            }
            ret.add(seq);
        }

        return ret;
    }

    public static List<Integer> getSeq(int i, Stack<Integer> stack, Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList<>();
        while (i != 0) {
            Integer idx = map.get(i & (-i));
            list.add(stack.get(idx));
            i = i - (i & (-i) );
        }
        return list;
    }

    public static void main(String[] args) {
        int i = 7;
        i = i - (i & (-i));
        System.out.println(i);

        System.out.println(findSubsequences(new int[]{1, 2, 3, 4}));
    }
}