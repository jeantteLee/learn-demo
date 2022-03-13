package com.lijuan.learndemo.lectcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  数字转大写汉字
 */
public class NumTransferToChinese {

    public static String transfer(String nums) {

        if (nums == null || nums.length() == 0) {
            return null;
        }

        int len = nums.length();

        String[] numStr = new String[(nums.length() + 3)/4];
        int j = 0;
        StringBuilder builder = new StringBuilder();
        for (int i  = 1; i <= len; i++) {
            builder.append(nums.indexOf(len - 1 - i));
            if (i%4 == 0) {
                numStr[j++]  = builder.reverse().toString();
                builder.delete(0, builder.length());
            }
        }

        numStr[j] = builder.toString();

        String[] charGroup = new String[numStr.length];
        len = numStr.length;
        for (int i =0; i < len ; i++) {
            charGroup[i] = trans(numStr[i]);
        }

        char ch = charGroup.length %2 == 0 ? '亿' : '万';
        StringBuilder res = new StringBuilder();
        for (int i = charGroup.length - 1; i >= 0; i--) {
            res.append(charGroup[i]);
            if (i != 0) {
                res.append(ch);
                ch = reverse(ch);
            }
        }
        return res.toString();
    }

    private static String trans(String s) {
        Map<String, String> map  = new HashMap<>();
        map.put("1", "一");
        map.put("2", "二");
        map.put("3", "三");
        map.put("4", "四");
        map.put("5", "五");
        map.put("6", "六");
        map.put("7", "七");
        map.put("8", "八");
        map.put("9", "九");

        Map<Integer, String> unitMap = new HashMap<>();
        unitMap.put(3, "千");
        unitMap.put(2, "百");
        unitMap.put(1, "十");

        int len = s.length();
        StringBuilder builder =  new StringBuilder();
        boolean flag = false;

        for (int i  = 0; i <  len; i++) {
            String ch = s.substring(i, i+1);
            if (ch.equals("0") && !flag) {
                builder.append("零");
                flag = true;
                continue;
            }
            else if (ch.equals("0")) {
                continue;
            }
            else  {
                builder.append(map.get(ch));
            }

            if (i != len -1) {
                builder.append(unitMap.get(len - 1 - i));
            }
        }

        return builder.toString();
    }

    private static char reverse(char ch) {
        return ch == '亿' ? '万': '亿';
    }

    public static String longestPalindrome (String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int len = s.length();
        int[][] res = new int[len][len];

        for (int i = 0; i < len; i++) {
            res[i][i] = 1;
            if (i + 1 < len) {
                res[i][i+1] = chars[i] == chars[i+1] ? 1 : 0;

            }
        }
        int maxi = 0;
        int maxj = 0;

        for (int i = 2; i < len; i++) {
            for (int j = i, k = 0; j < len; j++, k++) {
                res[k][j] = chars[k] == chars[j] && res[k+1][j-1] == 1 ? 1 : 0;
                if (res[k][j] == 1 && j - k + 1 > maxj - maxi + 1) {
                    maxi = k;
                    maxj = j;
                }
            }
        }
        return s.substring(maxi, maxj+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }


}
