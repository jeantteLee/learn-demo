package com.lijuan.learndemo.lectcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 *  两数之和
 */
public class SumOfTarget {

    public static int[] getIndexOfTarget(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return null;
        }

        if (nums.length == 2 ) {
            return nums[0] + nums[1] == target ? new int[] {0, 1} : null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i  = 0; i < len ; i++) {
            Integer idx =  map.get(target - nums[i]);
            if (idx != null) {
                return new int[] {idx, i};
            }
            map.put(nums[i], i);

        }

        return null;
    }

    public static void main (String[] args) {

        int[] res = getIndexOfTarget(new int[]{1, 4, 5, 9}, 9);
        Arrays.stream(res).forEach(i -> System.out.print(i + " ") );


    }
}
