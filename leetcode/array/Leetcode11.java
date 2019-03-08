package array;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode11 {

    //-----------------------------------------------------------------------
    //  [1,8,6,2,5,4,8,3,7]
    //  49
    //-----------------------------------------------------------------------

    @Test
    public void leetcode11Test(){
        int i = maxArea(new int[]{2,3,4,5,18,17,6});
        System.out.println(String.format("result:%s",i));

    }


    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            res = Math.max(res, h * (j - i));
            if (height[i] < height[j]) {
                i++;
            }else {
                j--;
            }
        }
        return res;
    }
}
