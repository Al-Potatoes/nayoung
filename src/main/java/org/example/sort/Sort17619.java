package org.example.sort;

import java.io.*;
import java.util.*;

public class Sort17619 {
  static int N, Q;
  static int[][] arr;
  static Map<Integer, Integer> group = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    Q = Integer.parseInt(input[1]);

    arr = new int[N][4];

    for (int i = 0; i < N; i++) {
      input = br.readLine().split(" ");
      int x1 = Integer.parseInt(input[0]);
      int x2 = Integer.parseInt(input[1]);
      int y = Integer.parseInt(input[2]);
      arr[i] = new int[]{x1, x2, y, i + 1};
    }

    Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]));

    int groupId = 1;
    int maxRight = arr[0][1];
    group.put(arr[0][3], groupId);

    for (int i = 1; i < N; i++) {
      if (arr[i][0] <= maxRight) {
        group.put(arr[i][3], groupId);
        maxRight = Math.max(maxRight, arr[i][1]);
      }
      else {
        groupId++;
        group.put(arr[i][3], groupId);
        maxRight = arr[i][1];
      }
    }

    for (int i = 0; i < Q; i++) {
      input = br.readLine().split(" ");
      int start = Integer.parseInt(input[0]);
      int end = Integer.parseInt(input[1]);

      if (group.get(start).equals(group.get(end))) {
        sb.append(1).append("\n");
      } else {
        sb.append(0).append("\n");
      }
    }

    System.out.print(sb);
  }
}
/*
* x1, x2, y, 통나무 번호
* x1 기준 정렬, 같으면 x2 기준 정렬(오름차순)
* 겹치는 통나무들을 하나의 그룹으로 묶음
* 그룹 내에서 점프 가능한지 판별
* */