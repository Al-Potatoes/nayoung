package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort11650 {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(bf.readLine());
    int[][] arr = new int[N][2];

    for (int i = 0; i < N; i++) {
      String[] input = bf.readLine().split(" ");
      arr[i][0] = Integer.parseInt(input[0]);
      arr[i][1] = Integer.parseInt(input[1]);
    }

    Arrays.sort(arr, (a, b) -> {
      if (a[0] != b[0]) {
        return Integer.compare(a[0], b[0]);
      }
      return Integer.compare(a[1], b[1]);
    });

    for (int i = 0; i < N; i++) {
      sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
    }

    System.out.println(sb);
  }
}
