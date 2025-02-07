package org.example.recursion;

import java.util.Scanner;

public class Recursion1629 {
  static long multiply(int a, int b, int c) {
    if (b == 1)
      return a % c;

    long result = multiply(a, b / 2, c);

    if (b % 2 == 0)
      return result * result % c;
    else
      return (result * result % c) * a % c;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();

    System.out.println(multiply(A, B, C));

    sc.close();
  }
}
