package codingInterviewPatterns;

import java.util.Arrays;

public class PairSumSorted {

    public static int[] pairSumIdxs (int nums[], int target){
        int left = 0, right = nums.length -1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if(sum < target){
                left++;
            }else if(sum > target){
                right--;
            }else{
                return new int[]{left, right};
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int nums [] = new int[]{-5,-2,3,4,6};
        int target = 7;
        System.out.println("Res: " + Arrays.toString(pairSumIdxs(nums,target)));
    }
}

