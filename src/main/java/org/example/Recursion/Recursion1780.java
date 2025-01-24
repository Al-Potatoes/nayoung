package org.example.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursion1780 {
  static int[][] paper;
  static int[] result = new int[3];

  static void divide(int x, int y, int size) {
    if (checkNum(x, y, size)) {
      result[paper[x][y] + 1]++;
      return;
    }

    int newSize = size / 3;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        divide(x + i * newSize, y + j * newSize, newSize);
      }
    }
  }

  static boolean checkNum(int x, int y, int size) {
    int value = paper[x][y];
    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (paper[i][j] != value) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    paper = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        paper[i][j] = Integer.parseInt(input[j]);
      }
    }

    divide(0, 0, n);

    System.out.println(result[0]);
    System.out.println(result[1]);
    System.out.println(result[2]);
  }
}
