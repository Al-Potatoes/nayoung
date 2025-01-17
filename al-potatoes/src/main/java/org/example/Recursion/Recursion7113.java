package org.example.Recursion;

import java.util.Scanner;

public class Recursion7113 {
  static int rectangle(int a, int b) {
    if (b == 0) return 0;

    return (a / b) + rectangle(b, a % b);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), m = sc.nextInt();

    if (n > m)
      System.out.println(rectangle(n, m));
    else
      System.out.println(rectangle(m, n));

    sc.close();
  }
}