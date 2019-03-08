package array;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode27 {
    @Test
    public void leetcode27(){
        int i = removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
        System.out.println(String.format("result:%s", i));
    }


    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val)
                nums[k++] = nums[i];
        }
        return k;
    }

    public int removeElement2(int[] nums, int val) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {

                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                length++;
            }
        }
        return length;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
