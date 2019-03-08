package array;

import com.sun.istack.internal.Nullable;
import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode125 {


    //      Example 1:
    //
    //      Input: "A man, a plan, a canal: Panama"
    //      Output: true
    //      Example 2:
    //
    //      Input: "race a car"
    //      Output: false


    @Test
    public void leetcode125() {
        boolean palindrome = isPalindrome("0P");
        System.out.println(String.format("result:%s", palindrome));
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        s = s.toLowerCase();
        while (i < j) {

            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) {
                i++;
            }
            while (!Character.isLetterOrDigit(s.charAt(j)) && i < j) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;

        }

        return true;
    }



}
