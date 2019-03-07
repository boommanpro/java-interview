package cn.boommanpro;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode781 {
    @Test
    public void leetcode781() {
        int length = findLength(new int[]{0,0,0,0,0,0,1,0,0,0}, new int[]{0,0,0,0,0,0,0,1,0,0});
        System.out.println(String.format("length:%d",length));
    }



    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int maxLength = 0;
        for (int i = 1; i < A.length+1; i++) {
            for (int j = 1; j < B.length+1; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }


}
