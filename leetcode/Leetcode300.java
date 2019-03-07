package cn.boommanpro;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode300 {
    @Test
    public void leetcode300() {
        int i = lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(String.format("result:%s", i));
    }


    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 1;
        int[] binaryArray = new int[nums.length + 1];
        binaryArray[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int position = binarySearchPosition(binaryArray, 1, len, nums[i]);
            binaryArray[position] = nums[i];
            if (position > len) {
                len = position;
            }
        }

        return len;
    }


    public int binarySearchPosition(int[] array, int left, int right, int key) {

        if (array[right] < key) {
            return right + 1;
        }

        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;


    }
}

