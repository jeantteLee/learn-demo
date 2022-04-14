package com.lijuan.learndemo.book;

import java.util.Optional;

/**
 * 蛇形方阵
 */
public class Sample3_3 {

    /**
     * 解法二
     *
     * @param n 方阵大小
     * @return arr 方阵数组
     */
    public static int[][] func2(int n) {
        if (n == 0) {
            return null;
        }
        int[][] arr = new int[n][n];
        // init
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 0;
            }
        }
        int tot = 0;
        int x = 0;
        int y = n - 1;
        int size = n * n;
        while (tot < size) {
            while (x < n) {
                arr[x++][y] = ++tot;
            }
            if (y > 0) {
                arr[--x][--y] = ++tot;
            }
            while (x > 0) {
                arr[--x][y] = ++tot;
            }
            if (y > 0) {
                y--;
            }
        }
        return arr;
    }

    /**
     * 解法1
     *
     * @param n 数组大小
     * @return arr 数组
     */
    public static int[][] func(int n) {
        if (n <= 0) {
            return null;
        }
        int count = 1;
        int[][] res = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            if ((n - i) % 2 == 0) {
                for (int j = n - 1; j >= 0; j--) {
                    res[j][i] = count++;
                }
            } else {
                for (int j = 0; j < n; j++) {
                    res[j][i] = count++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Optional.ofNullable(func2(4))
                .ifPresentOrElse(arr -> {
                    for (int[] ints : arr) {
                        for (int anInt : ints) {
                            System.out.print(anInt + " ");
                        }
                    }
                    System.out.println();
                }, () -> System.out.println(" null "));
    }

}
