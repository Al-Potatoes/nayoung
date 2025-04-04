package org.example.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11655 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    StringBuilder sb = new StringBuilder();
    for (char c : input.toCharArray()) {
      if ((c >= 'a' && c <= 'z')) {
        c = (char) ('a' + (c - 'a' + 13) % 26);
      } else if (c >= 'A' && c <= 'Z') {
        c = (char) ('A' + (c - 'A' + 13) % 26);
      }
      sb.append(c);
    }
    System.out.println(sb);
  }
}

// 14244KB / 100ms