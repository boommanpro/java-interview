package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode88 {



    @Test
    public void leetcode88(){

        //[1,2,4,5,6,0]
        //5
        //[3]
        //1

        int[] nums1 = new int[]{1,2,3,0,0,0};

        merge(nums1, 3, new int[]{2,5,6}, 3);

        System.out.println(Arrays.toString(nums1));

    }

    //  Input:
    //  nums1 = [1,2,3,0,0,0], m = 3
    //  nums2 = [2,5,6],       n = 3
    //
    //  Output: [1,2,2,3,5,6]

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //倒着放就不需要后面填充了

        if (nums2 == null || nums2.length == 0) {
            return;
        }

        int allLength = nums1.length;

        int anewStart = allLength - m;


        for (int i = allLength-1; i >= n; i--) {
            nums1[i] = nums1[i-n];
        }



        int i = 0;
        int j = 0;
        int curr = 0;
        while (i < m&&j<n) {
            if (nums1[anewStart + i] < nums2[j] ) {
                nums1[curr] = nums1[anewStart + i];
                i++;
            }else {
                nums1[curr] = nums2[j];
                j++;
            }
            curr++;

        }

        while (i < m) {
            nums1[curr] = nums1[anewStart+i];
            curr++;
            i++;
        }

        while (j < n) {
            nums1[curr] = nums2[j];
            curr++;
            j++;
        }
    }
}
