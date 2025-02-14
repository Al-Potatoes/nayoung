package org.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack12789 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Stack<Integer> line = new Stack<>();
    Stack<Integer> space = new Stack<>();

    String[] input = br.readLine().split(" ");

    for (int i = N - 1; i >= 0; i--) {
      int n = Integer.parseInt(input[i]);

      line.push(n);
    }

    int i = 1;
    while (!line.isEmpty()) {
      int l = line.peek();

      if (l == i) {
        line.pop();
        i++;
      } else if (!space.isEmpty() && space.peek() == i) {
        space.pop();
        i++;
      } else {
        space.push(line.pop());
      }
    }

    while (!space.isEmpty()) {
      int n = space.pop();
      if (n != i)
        line.push(n);
      else i++;
    }

    if (i - 1 == N) {
      System.out.println("Nice");
    } else {
      System.out.println("Sad");
    }
  }
}
/*
* 줄과 추가공간
* 줄에서 해당 번호인 사람이 나올때까지 추가공간에 저장
* 매번 추가공간의 첫번째 사람이 해당 번호인지도 검사
* 줄이 비어있을때까지 검사후
* 추가공간에서 순서대로 나갈수 있는지 검사
* */
// 14400KB / 112ms