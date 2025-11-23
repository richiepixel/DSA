package codingInterviewPatterns;

import java.util.Arrays;
import java.util.HashMap;

public class PairNumUnsorted {
  public static int[] pairSumsUnsrtdIdx (int nums[], int target) {
    int n = nums.length;
    HashMap<Integer,Integer> map = new HashMap<>();

    for(int i = 0; i < n; i++){
      int compl = target - nums[i];
      if(map.containsKey(compl)){
        return new int[]{map.get(compl), i};
      }
      map.put(nums[i], i);
    }
    return new int[0];
  }

  public static void main(String[] args) {
    int nums[] = new int[]{-1,3,4,2};
    int target = 3;
    System.out.println("Result: " + Arrays.toString(pairSumsUnsrtdIdx(nums,target)));
  }
}
