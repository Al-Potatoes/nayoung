package org.example.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1213 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringBuilder f = new StringBuilder();
    String input = br.readLine();

    int[] arr = new int[26];

    for (char c : input.toCharArray()) {
      arr[c - 'A']++;
    }

    int even_c = 0;
    int odd_c = 0;
    char mid = 'a';

    for (int i = 0; i < 26; i++) {
      if (arr[i] % 2 == 0) {
        even_c++;
      } else {
        odd_c++;
        if (odd_c > 1) {
          System.out.println("I'm Sorry Hansoo");
          return;
        } else {
          mid = (char)('A' + i);
          arr[mid - 'A']--;
        }
      }
      arr[i] /= 2;
    }

    for (int i = 0; i < 26; i++) {
      while (arr[i] != 0) {
        f.append((char) ('A' + i));
        arr[i]--;
      }
    }
    sb.append(f);
    if (mid != 'a') {
      sb.append(mid);
    }
    sb.append(f.reverse());
    System.out.println(sb);
  }
}

// 104ms