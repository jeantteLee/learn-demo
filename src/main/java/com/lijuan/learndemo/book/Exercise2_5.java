package com.lijuan.learndemo.book;

import java.util.ArrayList;
import java.util.List;

/**
 * 排列
 */
public class Exercise2_5 {

    public static List<String> func() {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    boolean[] res = new boolean[9];
                    res[i-1] = true;
                    res[j-1] = true;
                    res[k-1] = true;
                    int a = i*100 + j*10 + k;
                    int b = a*2;
                    int c = a*3;
                    if (b > 999 || c > 999) {
                        continue;
                    }
                    if(!check(b,c, res)) {
                        continue;
                    }
                    result.add(a + " " + b + " " + c);
                }
            }
        }
        return result;
    }

    public static boolean check (int b, int c, boolean[] res) {
       return checkNum(b, res) && checkNum(c, res);
    }

    private static boolean checkNum(int b, boolean[] res) {
        int x =  b/100;
        int y = b%100/10;
        int z = b%10;
        if (x == 0 || y == 0 || z == 0 ) {
            return false;
        }
        if (res[x - 1] || res[y - 1] || res[z - 1]) {
            return false;
        }
        res[x - 1] =  true;
        res[y - 1] = true;
        res[z - 1] = true;
        return true;
    }

    public static void main(String[] args) {
        func().forEach(System.out::println);
    }
}
