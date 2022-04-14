package com.lijuan.learndemo.book;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 子序列之和
 */
public class Exercise2_4 {

    public static double[] func(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        double[] res = new double[len];
        for (int i = 0; i < len; i++) {
            res[i] = cal(nums[i][0], nums[i][1]);
        }
        return res;
    }

    public static double cal(int start, int end) {
        if (start < 0 || end < 0) {
            return 0.0;
        }
        long  t = (long) start * start;
        double sum = 1  * 1.0 / t;
        for (int i  = start + 1; i <= end ; i++) {
            t = t + 2L * i - 1;
            sum += 1* 1.0 / t;
        }
        return ((long) ((sum * 100000) + 0.5)) * 1.0 / 100000;
    }

    public static void main(String[] args) {
        double[] res = func(new int[][] { {65535, 655360}});
        Arrays.stream(res).forEach(System.out::println);
    }

}
