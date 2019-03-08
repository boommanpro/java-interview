package cn.boommanpro;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode583 {
    @Test
    public void leetcode583() {
        int i = minDistance("seeat", "eeast");
        System.out.println(String.format("step:%d", i));
    }

    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int res = dp[word1.length()][word2.length()];
        res = word1.length() + word2.length() - 2 * res;

        return res;
    }

}
