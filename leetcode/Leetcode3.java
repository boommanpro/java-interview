package cn.boommanpro;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode3 {

    @Test
    public void leetcode3() {
        int abcdefad = lengthOfLongestSubstring("abba");
        System.out.println(String.format("%s", abcdefad));
    }

    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0, interval = 0; i < n; i++) {
            char curr = s.charAt(i);
            if (map.containsKey(curr)) {
                interval = Math.max(map.get(curr), interval);
            }
            maxLength = Math.max(maxLength, i - interval + 1);
            map.put(curr, i+1);
        }
        return maxLength;
    }
}
