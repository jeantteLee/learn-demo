package com.lijuan.learndemo.lectcode;

public class OnlyNum {

    public static int getOnlyNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
       return dfs(nums, 0, nums.length -1 );
    }

    public static int dfs (int[] nums, int low, int high) {
        int len = nums.length;

        if (low < 0 || high > len -1 || low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        int val = nums[mid];
        boolean flag1 = false;
        boolean flag2 = false;
        if (mid + 1 < len && val != nums[mid + 1]) {
            flag1 = true;
        }
        if (mid -1 >= 0 && val != nums[mid - 1]) {
            flag2 = true;
        }
        if (mid + 1 >= len && flag2) {
            return mid;
        }
        if (mid - 1 < 0 && flag1) {
            return  mid;
        }

        if (flag1 && flag2) {
            return mid;
        }

        int res = dfs(nums, mid + 1, high);
        return res == -1 ? dfs(nums, low, mid - 1) : res;
    }

    public static void main (String[] args) {
        System.out.println(getOnlyNum(new int[]{1,1,2,2,3,3,4}));
    }

}
