package cn.boommanpro;

import org.junit.Test;

import java.util.Stack;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode32 {

    @Test
    public void leetcode32Test(){
        int i = longestValidParentheses("()(())");
        System.out.println(String.format("result:%s",i));
    }

    public int longestValidParentheses(String s) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.toCharArray().length; i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                stack.push(i);
            }
            if (curr == ')') {
                stack.pop();
                if (!stack.empty()) {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }else {
                    stack.push(i);
                }
            }
        }
        return maxLength;
    }
}
