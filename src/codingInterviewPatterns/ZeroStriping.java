package codingInterviewPatterns;

import java.util.HashSet;

public class ZeroStriping {

  public static void zeroStriping(int [][] matrix){
    int m = matrix.length;
    int n = matrix[0].length;
    HashSet<Integer> rows = new HashSet<>();
    HashSet<Integer> columns = new HashSet<>();

    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        int current = matrix[i][j];
        if(current == 0){
          rows.add(i);
          columns.add(j);
        }
      }
    }

    for(int i = 0; i < m; i++){
      for (int j = 0; j < n; j++) {
        if(rows.contains(i) || columns.contains(j)){
          matrix[i][j] = 0;
        }
      }
    }
  }

  public static void zeroStripingInPlace(int [][] matrix){
    int m = matrix.length;
    int n = matrix[0].length;

    boolean isFirstRowZero = false;
    boolean isFirstColumnZero = false;

    //Check if there are some first row/column
    for(int i = 0; i < m; i++){
      if(matrix[i][0] == 0) isFirstColumnZero = true;
    }

    for(int j = 0; j < n; j++){
      if(matrix[0][j] == 0) isFirstRowZero = true;
    }

    //mark zeros
    for(int i = 1; i < m; i++){
      for(int j = 0; j < n; j++){
        if(matrix[i][j] == 0){
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    //Set zeros using the markers
    for(int i = 1; i < m; i++){
      for(int j = 1; j < n; j++){
        if(matrix[i][0] == 0 || matrix[0][j] == 0){
          matrix[i][j] = 0;
        }
      }
    }

    //check again the first row/column
    if(isFirstRowZero){
      for(int j = 0; j < n; j++) matrix[0][j] = 0;
    }

    if(isFirstColumnZero){
      for(int i = 0; i < m; i++) matrix[i][0] = 0;
    }



  }

  public static void main(String[] args) {
    int [][] matrix = {
            {1,2,3,4,5},
            {6,0,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,0}
    };

    zeroStripingInPlace(matrix);
    for (int[] row : matrix) {
      for (int val : row) System.out.print(val + " ");
      System.out.println();
    }
  }
}
