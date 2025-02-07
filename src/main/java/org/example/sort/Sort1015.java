package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort1015 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    String[] input = br.readLine().split(" ");

    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    int[] rank = new int[N];

    for (int i = 0; i < N; i++) {
      rank[i] = 0;
      for (int j = 0; j < N; j++) {
        if (arr[i] > arr[j]) {
          rank[i]++;
        }
      }

      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] == arr[i]) {
          rank[i]++;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      sb.append(rank[i] + " ");
    }
    System.out.println(sb);
  }
}
/*
* 자신보다 큰 원소의 개수 세기
* 자신과 같은 원소 중 자신보다 앞에 있는 원소의 개수 세기
* */