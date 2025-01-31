package org.example.LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedList2840 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    LinkedList<Character> wheel = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      wheel.add('?');
    }

    int count = 0;
    int flag = 0;

    for (int i = 0; i < K; i++) {
      int S = sc.nextInt();
      char ch = sc.next().charAt(0);

      count = (count + S) % N;

      if (wheel.get(count) == '?') {
        if (wheel.contains(ch)) {
          flag = 1;
          break;
        }
        wheel.set(count, ch);
      }
      else if (wheel.get(count) != ch) {
        flag = 1;
        break;
      }
    }

    if (flag == 1) {
      System.out.println("!");
    } else {
      for (int i = 0; i < N; i++) {
        System.out.print(wheel.get((count + N - i) % N));
      }
    }
  }
}
