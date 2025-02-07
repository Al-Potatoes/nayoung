package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort25947 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    int n = Integer.parseInt(input[0]);
    int b = Integer.parseInt(input[1]);
    int a = Integer.parseInt(input[2]);
    long sum = 0;

    input = br.readLine().split(" ");
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(arr);

    int count = 0;
    for (int i = 0; i < a; i++) {
      sum += arr[i] / 2;

      if (sum > b) {
        System.out.println(i);
        System.exit(0);
      }

      count = i + 1;
    }

    for (int i = a; i < n; i++) {
      sum += arr[i - a] / 2 + arr[i] / 2;

      if (sum > b) {
        System.out.println(i);
        System.exit(0);
      }

      count = i + 1;
    }

    System.out.println(count);
  }
}
/*
* 가장 싼 것부터 반값 해서 더함
* a개가 다 찼을 경우 앞에서 부터 더한 걸 취소하고
* 그 다음 값을 더해본다
*  */