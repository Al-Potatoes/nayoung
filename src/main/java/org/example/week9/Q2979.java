package org.example.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2979 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    int[] arr = new int[100];
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      for (int j = s; j < e; j++) {
        arr[j]++;
      }
    }
    int sum = 0;
    for (int i = 0; i < 100; i++) {
      if (arr[i] == 1) {
        sum += A;
      } else if (arr[i] == 2) {
        sum += (B * 2);
      } else if (arr[i] == 3) {
        sum += (C * 3);
      }
    }
    System.out.println(sum);
  }
}

// 14108KB / 104ms