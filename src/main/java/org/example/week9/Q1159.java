package org.example.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Q1159 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    Map<Character, Integer> map = new TreeMap<>();
    int N = Integer.parseInt(st.nextToken());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      char s = st.nextToken().charAt(0);

      int count = map.getOrDefault(s, 0);
      map.put(s, count + 1);
    }

    StringBuilder sb = new StringBuilder();
    for (Character key: map.keySet()) {
      if (map.get(key) >= 5) {
        sb.append(key);
      }
    }
    if (sb.length() == 0) {
      System.out.println("PREDAJA");
    } else {
      System.out.println(sb);
    }
  }
}

// 14200KB / 104ms