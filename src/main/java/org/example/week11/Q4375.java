package org.example.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4375 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String input;
    while ((input = br.readLine()) != null) {
      int n = Integer.parseInt(input.trim());

      int m = 1;
      int l = 1;

      while (m % n != 0) {
        m = (m * 10 + 1) % n;
        l++;
      }
      sb.append(l).append("\n");
    }
    System.out.print(sb);
  }
}

// 100ms