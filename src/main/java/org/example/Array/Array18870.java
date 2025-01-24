package org.example.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/*
 * 좌표 압축
 * => 오름차순으로 정렬된 배열 생성해서 각 원소의 등수를 구하는 방식
 */
public class Array18870 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    String[] input = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    int[] copyArr = arr.clone();
    Arrays.sort(copyArr);

    HashMap<Integer, Integer> rank = new HashMap<>();
    int t = 0;
    for (int i = 0; i < N; i++) {
      if (!rank.containsKey(copyArr[i])) {
        rank.put(copyArr[i], t++);
      }
    }

    for (int i = 0; i < N; i++) {
      sb.append(rank.get(arr[i])).append(" ");
    }

    System.out.println(sb.toString().trim());
    br.close();
  }
}
