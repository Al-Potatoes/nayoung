package org.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack25918 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String input = br.readLine();

    Stack<Character> stack = new Stack<>();

    int count = 0;
    for (char ch : input.toCharArray()) {
      if (!stack.isEmpty()) {
        if (stack.peek() == '(' && ch == ')'
            || stack.peek() == ')' && ch == '(') {
          stack.pop();
        } else {
          stack.push(ch);
        }
      } else {
        stack.push(ch);
      }

      if (stack.size() > count) {
        count = stack.size();
      }
    }

    if (!stack.isEmpty()) {
      System.out.println("-1");
    } else {
      System.out.println(count);
    }
  }
}

// 19472KB / 240ms