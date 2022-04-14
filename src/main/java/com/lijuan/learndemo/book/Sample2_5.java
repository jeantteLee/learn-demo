package com.lijuan.learndemo.book;


/**
 *  min max avg
 */
public class Sample2_5 {

    public static double[] func(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new double[]{};
        }
        int max = nums[0];
        int min = nums[0];
        int sum = nums[0];
        int len = nums.length;
        for (int i  = 1; i < len ; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
            sum += nums[i];
        }
        double avg = sum * 1.0/len;
        return new double[]{min*1.0, max*1.0, avg};
    }

    public static void main(String[] args) {

    }
}
