package codingInterviewPatterns;

public class HappyNumber {
  public boolean isHappyNumber(int n) {
    if (n < 0) return false;
    int slow = n, fast = getNextNumber(n);

    while (fast != 1 && fast != slow) {
      slow = getNextNumber(slow);
      fast = getNextNumber(getNextNumber(fast));
    }
    return fast == 1;
  }

  public int getNextNumber(int n) {
    int next_num = 0;

    while (n > 0) {
      int digit = n % 10;
      next_num += digit * digit;
      n /= 10;
    }

    return next_num;
  }

  public static void main(String[] args) {
    HappyNumber hn = new HappyNumber();

    int[] tests = {1, 7, 19, 2, 20, 111, 123, 4};

    for (int n : tests) {
      System.out.println("Is " + n + " happy? → " + hn.isHappyNumber(n));
    }
  }
}
