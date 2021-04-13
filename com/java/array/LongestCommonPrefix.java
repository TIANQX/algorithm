package com.java.array;

/**
 * @Author tqx
 * @CreateDate 2021/4/2
 * @Description 查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

    }

    public static String[] LongestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs.length; i++) {

            if (i != strs.length - 1) {
                int re = strs[i].indexOf(strs[i + 1]);
                if (re == -1) {

                }
            }
        }
        return null;

    }
}
