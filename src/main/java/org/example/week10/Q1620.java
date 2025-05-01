package org.example.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1620 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Map<String, Integer> map = new HashMap<>();
    Map<Integer, String> map2 = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      map.put(input, i + 1);
      map2.put(i + 1, input);
    }

    for (int i = 0; i < M; i++) {
      String input = br.readLine();
      if (isNumeric(input)) {
        int val = Integer.parseInt(input);
        sb.append(map2.get(val)).append("\n");
      } else {
        sb.append(map.get(input)).append("\n");
      }
    }

    System.out.println(sb);
  }

  public static boolean isNumeric(String str) {
    try {
      int num = Integer.parseInt(str);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}

// 708ms