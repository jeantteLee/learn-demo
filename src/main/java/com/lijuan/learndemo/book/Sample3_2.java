package com.lijuan.learndemo.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 开灯问题
 */
public class Sample3_2 {

    public static List<Integer> func (int k, int n) {
        if (k <= 0 || n <=0 ) {
            return null;
        }
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = 1;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n ; j++) {
                if (j%i == 0) {
                    tmp[j-1] = -tmp[j-1];
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (tmp[i] == 1) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Objects.requireNonNull(func(7, 8)).forEach(System.out::println);
    }
}
