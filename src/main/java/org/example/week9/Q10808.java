package org.example.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10808 {
  public static void main(String[] args) throws IOException {
    String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
    int[] arr = new int[26];

    for (int i = 0; i < input.length(); i++) {
      arr[input.charAt(i) - 'a']++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      sb.append(arr[i]).append(" ");
    }
    System.out.println(sb);
  }
}

// 14256KB / 104ms