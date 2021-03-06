package com.hzq;

/**
 * 最大子数组的和，并输出最大子数组
 */
public class MaxSumSubArray {

    //[-2,1,-3,4,-1,2,1,-5,4] => max [4,-1,2,1]

    public static void main(String[] args) {
        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] result = maxSubArray(array);
        System.out.println("maxSum:" + result[0]);
        for(int i = result[1]; i <= result[2]; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();

        result = dpMaxSubArray(array);
        System.out.println("dpMaxSum:" + result[0]);
        for(int i = result[1]; i <= result[2]; i++){
            System.out.print(array[i] + " ");
        }
    }

    /**
     * 根据tempSum和maxSum两个变量求最大子数组和
     * 0 是和， 1 是start 2 是end
     */
    public static int[] maxSubArray(int[] A) {
        int[] result = new int[3];
        int maxSum = A[0];
        int tempSum = A[0];

        int start = 0;
        int end = 0;

        for (int i = 1; i < A.length; i++){
            if(tempSum <= 0){
                tempSum = A[i];
                start = i;
            } else {
                tempSum = tempSum + A[i];
            }

            if(maxSum < tempSum){
                maxSum = tempSum;
                end = i;
            }
        }

        result[0] = maxSum;
        result[1] = start;
        result[2] = end;
        return result;
    }

    /**
     * 动态规划
     */
    public static int[] dpMaxSubArray(int[] A) {
        int length = A.length;
        int[] dp = new int[length];//dp[i]代表以i结尾的最大子数组之和

        int[] result = new int[3];
        int maxSum = A[0];

        result[0] = A[0];
        int start = 0;
        int end = 0;

        for (int i = 1; i < length; i++){
            if(dp[i-1] > 0){
                dp[i] = dp[i-1] + A[i];
            } else {
                dp[i] = A[i];
                start = i;
            }

            if(maxSum < dp[i]){
                maxSum = dp[i];
                end = i;
            }
        }

        result[0] = maxSum;
        result[1] = start;
        result[2] = end;
        return result;
    }
}


