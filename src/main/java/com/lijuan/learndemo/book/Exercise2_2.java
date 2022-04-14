package com.lijuan.learndemo.book;

import java.util.Arrays;

/**
 *  韩信点兵
 */
public class Exercise2_2 {

    public static int[] func(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length != 3) {
            return null;
        }
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int a = nums[i][0];
            int b = nums[i][1];
            int c = nums[i][2];
            res[i] = cal(a, b, c);
        }
        return res;
    }

    public static int cal (int a, int b, int c) {
        // b = (3 * a + x - y)/5
        // c = (3 *a  + x - z)/7
        if (a == b && b == c) {
            return a;
        }
        int i = 1;
        int max = a * b * c;
        boolean res = true;
        while ((3 * i + a - b)%5 != 0 || (3 * i + a - c)%7 != 0) {
            /*if ((3 * i + a) > max) {
                res = false;
                break;
            }*/
            i++;
        }
        return 3 * i + a;
    }

    public static void main(String[] args) {
        int[] res = func(new int[][]{{2, 1, 6}});
        Arrays.stream(res).forEach(System.out::println);
    }

}
