package org.example.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1940 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        int val = arr[i] + arr[j];
        if (val == K) {
          count++;
        }
      }
    }

    System.out.println(count);
  }
}

// 360ms