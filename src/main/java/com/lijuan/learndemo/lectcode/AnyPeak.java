package com.lijuan.learndemo.lectcode;


/**
 * 寻找数组中任意一个顶峰
 */
public class AnyPeak {

    public static int peak(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while (low < high) {
            int mid = high - (high - low) / 2;
            if (mid - 1 < 0 || mid + 1 > len - 1) {
                return -1;
            }
            int left = nums[mid + 1];
            int right = nums[mid - 1];
            int val = nums[mid];
            if (val > left && val > right) {
                return mid;
            }
            if (left > mid && mid > right) {
                high = mid;
                continue;
            }
            low = mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(peak(new int[] {1, 2, 3, 2, 5, 6, 7}));
    }


}
