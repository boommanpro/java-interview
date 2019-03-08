package array;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode80 {
    @Test
    public void leetcode80(){
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 4};
        int i = removeDuplicates(nums);
        System.out.println(String.format("result:%s", i));
        System.out.println(Arrays.toString(nums));
    }


    public int removeDuplicates(int[] nums) {
        //一个相同字母最多出现两次

        boolean doubleAppear = false;
        int current = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[current]) {
                current++;
                nums[current]=nums[i];
                doubleAppear = false;
            }else if (!doubleAppear){
                doubleAppear=true;
                current++;
                nums[current]=nums[i];
            }
        }

        return current+1;
    }

    public int removeDuplicates1(int[] nums) {
        //相同的值最多允许出现两次
        int currentPosition=0;
        int time=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[currentPosition] != nums[i]) {
                currentPosition++;
                nums[currentPosition] = nums[i];
                time = 1;
                continue;
            }
            if (time==1){
                currentPosition++;
                nums[currentPosition] = nums[i];
                time++;
            }
        }

        return currentPosition + 1;
    }
}
