package org.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack2504 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();
    Stack<Character> stack = new Stack<>();
    int score = 0;
    int temp = 1;

    for (int i = 0; i < input.length(); i++) {
      char cur = input.charAt(i);

      if (cur == '(') {
        stack.push(cur);
        temp *= 2;
      } else if (cur == '[') {
        stack.push(cur);
        temp *= 3;
      } else if (cur == ')') {
        if (stack.isEmpty() || stack.peek() != '(') {
          score = 0;
          break;
        }
        if (input.charAt(i - 1) == '(') {
          score += temp;
        }

        stack.pop();
        temp /= 2;
      } else if (cur == ']') {
        if (stack.isEmpty() || stack.peek() != '[') {
          score = 0;
          break;
        }
        if (input.charAt(i - 1) == '[') {
          score += temp;
        }

        stack.pop();
        temp /= 3;
      }
    }

    if (!stack.isEmpty()) {
      score = 0;
    }

    System.out.println(score);
  }
}

// 14368KB / 108ms

/*
* 여는 괄호는 일단 스택에 집어넣음
* temp에 2나 3을 곱해서 저장해 놓음
* 닫는 괄호를 만나면 앞에 거가 여는 괄호가 맞는지 검사해서
* 맞으면 score에 temp 값 더하기
* 틀리면 잘못된 괄호이니까 종료
* 스택이 비어있으면 score 출력 아니면 0 출력*/