package com.hzq;

/**
 * 最长公共子序列
 */
public class MaxLCS {

    private static int[][] lcsDP;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        String s1 = "abcdefga23f";
        String s2 = "aceeg2f";
        int length1 = s1.length();
        int length2 = s2.length();
        lcsDP = new int[length1 + 1][length2 + 1];
        System.out.println(maxLCSLength(s1, s2));
        int i = length1;
        int j = length2;
        while (i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else {
                if(lcsDP[i-1][j] == lcsDP[i][j-1]){
                    i--;
                } else if(lcsDP[i-1][j] < lcsDP[i][j-1]){
                    j--;
                } else {
                    i--;
                }
            }
        }
        System.out.println(sb.reverse().toString());
    }



    /**
     * 生成lcsDP
     */
    private static int maxLCSLength(String s1, String s2){
        for (int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    lcsDP[i][j] = lcsDP[i-1][j-1] + 1;
                } else {
                    lcsDP[i][j] = Math.max(lcsDP[i-1][j], lcsDP[i][j-1]);
                }
            }
        }

        return lcsDP[s1.length()][s2.length()];
    }
}
