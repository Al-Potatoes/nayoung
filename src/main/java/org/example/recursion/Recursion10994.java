package org.example.recursion;

import java.util.Scanner;

public class Recursion10994 {
  static char[][] board;

  static void printStar(int x, int m) {
    for (int i = x; i < m; i++) {
      board[x][i] = '*';
      board[i][x] = '*';
      board[m - 1][i] = '*';
      board[i][m - 1] = '*';
    }

    if (m == 1)
      return;

    printStar(x + 2, m - 2);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = 4 * N - 3;

    board = new char[M][M];

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < M; j++) {
        board[i][j] = ' ';
      }
    }

    printStar(0, M);

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < M; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }
}