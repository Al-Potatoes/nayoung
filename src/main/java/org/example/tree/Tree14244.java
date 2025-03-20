package org.example.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tree14244 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int next = 1;
    for (int i = 0; i < m; i++) {
      sb.append(0).append(" ").append(next).append("\n");
      next++;
    }

    for (int i = next; i < n; i++) {
      sb.append((i - 1)).append(" ").append(i).append("\n");
    }

    System.out.println(sb);
  }
}

// 14312KB / 100ms
