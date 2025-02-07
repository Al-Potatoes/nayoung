package org.example.array;

import java.util.Scanner;

/*
* 색종이가 붙은 검은 영역의 넓이 구하기
* => 2차원 배열로 모두 0으로 초기화하고 해당 좌표에서
* 10x10 크기만큼 값을 증가시킴
* 전체 종이에서 0보다 큰 값의 개수를 세는 방식
* */
public class Array2563 {
  static int[][] paper = new int[100][100];

  static void blackpaper(int x, int y) {
    for (int i = x; i < x + 10; i++) {
      for (int j = y; j < y + 10; j++) {
        paper[i][j] = 1;
      }
    }
  }

  static int calculate() {
    int count = 0;

    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (paper[i][j] > 0)
          count++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        paper[i][j] = 0;
      }
    }

    for (int i = 0; i < N; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();

      blackpaper(x, y);
    }

    System.out.println(calculate());
  }
}
