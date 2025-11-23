package codingInterviewPatterns;

public class Palindrome {
  public static boolean isPalindrome(String word) {
    int n = word.length();
    int left = 0, right = n - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(word.charAt(left))) left++;
      while (left < right && !Character.isLetterOrDigit(word.charAt(right))) right--;
      if (word.charAt(left) == word.charAt(right)) {
        left++;
        right--;
      } else return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String word = "ani.tala!valatin.a";
    System.out.printf("Is " + word + " a palindrome: " + isPalindrome(word));
  }
}
