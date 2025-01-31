package org.example.Recursion;

import java.util.Scanner;

public class Recursion1074 {
  static int count = 0;

  static void rZ(int N, int r, int c) {
    if (N == 0)
      return;

    int t = (int) Math.pow(2, N - 1);
    int k = t * t;

    if (r < t && c < t) {
      rZ(N - 1, r, c);
    }
    else if (r < t && c >= t) {
      count += k;
      rZ(N - 1, r, c - t);
    }
    else if (r >= t && c < t) {
      count += 2 * k;
      rZ(N - 1, r - t, c);
    }
    else {
      count += 3 * k;
      rZ(N - 1, r - t, c - t);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int r = sc.nextInt();
    int c = sc.nextInt();

    rZ(N, r, c);

    System.out.println(count);
  }
}