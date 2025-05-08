package org.example.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9996 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    String pattern = br.readLine();
    String[] pattern_ = pattern.split("\\*");
    String front = pattern_[0];
    String back = pattern_[1];

    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      if (input.startsWith(front) && input.endsWith(back)
      && front.length() + back.length() <= input.length()) {
        sb.append("DA\n");
      } else {
        sb.append("NE\n");
      }
    }
    System.out.println(sb);
  }
}

// 100ms