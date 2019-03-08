package cn.boommanpro;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode680 {


    @Test
    public void leetcode680() {
        boolean aba = validPalindrome("abc");
        System.out.println(String.format("%s",aba));
    }

    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                //删除字符串
                return validPalindromeChildren(s.substring(start, end)) || validPalindromeChildren(s.substring(start+1, end+1));
            }

            start++;
            end--;
        }
        return true;
    }


    public boolean validPalindromeChildren(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }
}
