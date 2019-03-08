package array;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode75 {
    @Test
    public void leetcode75() {
        int[] ints = {2,0,2,1,1,0};
        sortColors(ints);
        System.out.println(Arrays.toString(ints));

    }


    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i <=right; i++) {
            if (nums[i] == 0 && i != left) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            } else if (nums[i] == 2) {
                int temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;
                i--;
            }
        }
    }
}


