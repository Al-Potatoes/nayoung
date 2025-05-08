package org.example.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q3986 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int count = 0;
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      Stack<Character> s = new Stack<>();

      for (char c : input.toCharArray()) {
        if (s.empty() || s.peek() != c) {
          s.push(c);
        } else {
          s.pop();
        }
      }

      if (s.empty()) {
        count++;
      }
    }
    System.out.println(count);
  }
}

// 256ms