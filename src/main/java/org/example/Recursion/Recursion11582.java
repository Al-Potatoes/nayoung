package org.example.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Recursion11582 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    String[] input = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    int k = Integer.parseInt(br.readLine());

    int c = N / k;
    for (int i = 0; i < N; i += c) {
      Arrays.sort(arr, i, Math.min(i + c, N));
    }

    for (int i : arr) {
      sb.append(i).append(" ");
    }

    System.out.println(sb.toString().trim());

    br.close();
  }
}
