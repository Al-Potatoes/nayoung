package org.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Stack27497 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Deque<Character> string = new ArrayDeque<>();
    Deque<String> deque = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      int op = Integer.parseInt(input[0]);

      switch (op) {
        case 1:
          char c1 = input[1].charAt(0);
          deque.addLast("1" + c1);
          break;
        case 2:
          char c2 = input[1].charAt(0);
          deque.addLast("2" + c2);
          break;
        case 3:
          deque.pollLast();
          break;
      }
    }

    if (deque.isEmpty()) {
      System.out.println("0");
      System.exit(0);
    }

    while (!deque.isEmpty()) {
      String s = deque.removeFirst();
      char op = s.charAt(0);
      char c = s.charAt(1);

      switch (op) {
        case '1':
          string.addLast(c);
          break;
        case '2':
          string.addFirst(c);
          break;
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!string.isEmpty()) {
      sb.append(string.removeFirst());
    }

    System.out.println(sb);
  }
}

// 344092KB / 1004ms