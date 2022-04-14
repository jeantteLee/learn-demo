package com.lijuan.learndemo.lectcode;

import java.util.Arrays;
import java.util.Optional;

/**
 * 回型数组
 */
public class 回型数组 {

    /**
     * 输出回型数组
     *
     * @param m     行数
     * @param n     列数
     * @param start 起始值
     * @return 数组 arr
     */
    public static int[][] func(int m, int n, int start) {
        if (m <= 0 || n <= 0) {
            return null;
        }
        int[][] arr = new int[m][n];
        // init
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 0;
            }
        }
        int x = 0;
        int y = 0;
        int tot = start;
        int size = tot + m * n - 1;
        arr[x][y] = tot;
        while (tot < size) {
            while (y + 1 < n && arr[x][y + 1] == 0) {
                arr[x][++y] = ++tot;
            }
            while (x + 1 < m && arr[x + 1][y] == 0) {
                arr[++x][y] = ++tot;
            }
            while (y - 1 >= 0 && arr[x][y - 1] == 0) {
                arr[x][--y] = ++tot;
            }
            while (x - 1 >= 0 && arr[x - 1][y] == 0) {
                arr[--x][y] = ++tot;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Optional.ofNullable(func(3, 3, 1))
                .ifPresentOrElse(e -> {
                    for (int[] a : e) {
                        for (int i : a ) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    }
                }, () -> System.out.println("null "));
    }

}
