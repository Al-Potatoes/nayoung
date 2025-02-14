package org.example.graph;

import java.io.*;

public class Graph32942 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String[] input = br.readLine().split(" ");
    int A = Integer.parseInt(input[0]);
    int B = Integer.parseInt(input[1]);
    int C = Integer.parseInt(input[2]);

    for (int i = 1; i <= 10; i++) {
      boolean flag = false;
      for (int j = 1; j <= 10; j++) {
        if (A * i + B * j == C) {
          sb.append(j).append(" ");
          flag = true;
        }
      }

      if (!flag) {
        sb.append("0");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}

// 14164KB / 108ms