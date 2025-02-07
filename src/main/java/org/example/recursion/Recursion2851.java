package org.example.recursion;

import java.util.Scanner;

public class Recursion2851 {
  static int sum = 0;
  static int min = 100;

  static int superMario(int[] arr, int i) {
    if (i == arr.length)
      return sum;
    if (Math.abs(sum + arr[i] - 100) > min) {
      min = Math.abs(sum + arr[i] - 100);
      return sum;
    }

    sum += arr[i];
    min = Math.min(min, Math.abs(sum - 100));

    return superMario(arr, i + 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] arr = new int[10];

    for (int i = 0; i < 10; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(superMario(arr, 0));
  }
}
