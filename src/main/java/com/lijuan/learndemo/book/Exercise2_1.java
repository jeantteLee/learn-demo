package com.lijuan.learndemo.book;


public class Exercise2_1 {

    public static int[]  func () {
        int[] res = new int[1000];
        int len = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    int n = i*100 + j*10 +k;
                    if (n == i*i*i + j*j*j + k*k*k) {
                        res[len++] = n;
                    }
                }
            }
        }
        return res;
    }



    public static void sout(int[] a){
        if (a == null || a.length == 0) {
            return;
        }
        int len = a.length;
        for (int i = 0; i < len && a[i] != 0; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        sout(func());
    }

}
