package cn.boommanpro;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode686 {

    @Test
    public void leetcode686(){
        int i = repeatedStringMatch("abcd", "cdabcdab");
        // - - - - - - - - - - - - - - -
        // abcd cdab      abcdabcd
        // - - - - - - - - - - - - - - -

        System.out.println(String.format("result:%s",i));
    }

    public int repeatedStringMatch(String A, String B) {

        int q = 1;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            q++;
        }
        if (sb.indexOf(B) != -1) {
            return q;
        }
        sb.append(A);
        if (sb.indexOf(B) != -1) {
            return q+1;
        }
        return -1;
    }
}
