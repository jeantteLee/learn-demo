package com.lijuan.learndemo.book;

public class Exercise2_3 {

    public static void ptf(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            int len = (n - i) * 2 - 1;
            for (int k = 0; k < len; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ptf(5);
    }
}
