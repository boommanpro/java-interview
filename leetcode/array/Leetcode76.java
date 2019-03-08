package array;


import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode76 {
    @Test
    public void leetcode76(){

    }

    public String minWindow(String s, String t) {


        if (t == null || t.length() == 0) {
            return "";
        }

        int[] ans = {-1, 0, 0};
        int l = 0, r = 0;

        //对t做初始化操作

        Map<Character, Integer> dictT = new HashMap<>();
        for (char c : t.toCharArray()) {
            dictT.put(c, dictT.getOrDefault(c, 0) + 1);
        }

        int required = dictT.size();

        //windowCount

        Map<Character, Integer> windowCount = new HashMap<>();

        int currentSize = 0;

        while (r < s.length()) {

            char curr = s.charAt(r);

            windowCount.put(curr, windowCount.getOrDefault(curr, 0) + 1);

            if (dictT.containsKey(curr) && dictT.get(curr).intValue() == windowCount.get(curr).intValue()) {
                currentSize++;
            }

            while (currentSize == required) {


                if (ans[0] == -1 || (r - l+1) < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                char removeC = s.charAt(l);

                windowCount.put(removeC, windowCount.get(removeC) - 1);

                if (dictT.containsKey(removeC)&&windowCount.get(removeC).intValue()<dictT.get(removeC).intValue()){
                    currentSize--;
                }

                l++;
            }

            r++;

        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
    }












}
