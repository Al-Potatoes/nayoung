package org.example.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q9375 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    StringTokenizer st;
    for (int i = 0; i < T; i++) {
      int n = Integer.parseInt(br.readLine());
      HashMap<String, Integer> map = new HashMap<>();
      for (int j = 0; j < n; j++) {
        st = new StringTokenizer(br.readLine());
        String name = st.nextToken();
        String kind = st.nextToken();

        if (map.containsKey(kind)) {
          map.put(kind, map.get(kind) + 1);
        } else {
          map.put(kind, 1);
        }
      }
      int count = 1;
      for (int val : map.values()) {
        count *= (val + 1);
      }
      sb.append(count - 1).append("\n");
    }
    System.out.println(sb);
  }
}

// 108ms