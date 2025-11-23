package codingInterviewPatterns;

public class LargestContainer {
  public static int findMaxContainer(int heights[]) {
    int n = heights.length;
    int maxArea = 0;
    int left = 0;
    int right = n - 1;

    while(left < right){
      int width = right - left;
      int currentHeight = Math.min(heights[left],heights[right]);
      int currentArea = width * currentHeight;

      maxArea = Math.max(maxArea, currentArea);

      if(left < right) left++;
      else right++;
    }
    return maxArea;
  }

  public static void main(String[] args) {
    int heights[] = new int[]{2,7,8,3,7,6};
    System.out.printf("maxArea: " + findMaxContainer(heights));
  }
}
