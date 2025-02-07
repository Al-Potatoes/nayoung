package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort13164 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);

    int[] arr = new int[N];
    input = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(arr);

    int[] diff = new int[N - 1];
    for (int i = 0; i < N - 1; i++) {
      diff[i] = arr[i + 1] - arr[i];
    }

    Arrays.sort(diff);

    int result = 0;
    for (int i = 0; i < N - K; i++) {
      result += diff[i];
    }

    System.out.println(result);
  }
}
/*
* 다음 원소와의 차이를 저장
* 그 차를 저장한 배열 오름차순
* N-K개 만큼 더하기
* => 가장 작은 비용 N-K개 선택
*  */
