package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sort1931 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    ArrayList<int[]> timetable = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      int start = Integer.parseInt(input[0]);
      int end = Integer.parseInt(input[1]);
      timetable.add(new int[]{start, end});
    }

    timetable.sort((a, b) ->
        a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

    int count = 0, end = 0;
    for (int[] i : timetable) {
      if (i[0] >= end) {
        count++;
        end = i[1];
      }
    }

    System.out.println(count);
  }
}
/*
* 끝나는 시간 순으로 정렬
* 종료 시각이 같다면 시작 시간이 빠른 순으로
* 현재 회의 시작 시간이 이전 회의 종료 시각 이후면 선택*/