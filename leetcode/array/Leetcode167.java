package array;

import org.junit.Test;

import java.util.Arrays;



/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode167 {


    @Test
    public void leetcode167(){
        //     Input: numbers = [2,7,11,15], target = 9
        //     Output: [1,2]
        //     Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.


        int[] ints = twoSum(new int[]{5,25,75}, 100);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];

        for(int i=0, j=numbers.length-1;i<j ;){
            if(numbers[i]+numbers[j]>target)
                j--;
            else if(numbers[i]+numbers[j]<target)
                i++;
            else
            {
                index[0]=i+1;index[1]=j+1;
                break;
            }
        }
        return index;
    }


}
