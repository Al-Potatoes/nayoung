package org.example.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2309 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] arr = new int[9];
    for (int i = 0; i < 9; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int flag = 0, i, j = 0;
    for (i = 0; i < 9; i++) {
      for (j = 0; j < 9; j++) {
        if (i == j)
          continue;
        int sum = 0;
        for (int k = 0; k < 9; k++) {
          if (k != i && k != j) {
            sum += arr[k];
          }
        }
        if (sum == 100) {
          flag = 1;
          break;
        }
      }
      if (flag == 1)
        break;
    }
    arr[i] = 0;
    arr[j] = 0;

    Arrays.sort(arr);
    StringBuilder sb = new StringBuilder();
    for (i = 2; i < 9; i++) {
      sb.append(arr[i]).append("\n");
    }
    System.out.println(sb);
  }
}

// 14216KB / 100ms