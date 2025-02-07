package org.example.recursion;

import java.util.Scanner;

public class Recursion2447 {
  static void printStar(int n, int i, int j, StringBuilder sb) {
    if (n == 1) {
      if (i == 1 && j == 1)
        sb.append(" ");
      else
        sb.append("*");

      return;
    }

    int size = n / 3;

    if ((i / size) % 3 == 1 && (j / size) % 3 == 1)
      sb.append(" ");
    else
      printStar(size, i % size, j % size, sb);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        printStar(N, i, j, sb);
      }
      sb.append("\n");
    }

    System.out.print(sb);

    sc.close();
  }
}
