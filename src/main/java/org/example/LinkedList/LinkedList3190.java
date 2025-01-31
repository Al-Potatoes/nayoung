package org.example.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class LinkedList3190 {
  static int N, K, L;
  static int[][] board;
  static HashMap<Integer, String> map;
  static LinkedList<int[]> snake;
  static int time = 0;
  static int x = 0, y = 0;
  static int plusX = 0, plusY = 1;

  static int dummy() {
    snake = new LinkedList<>();
    snake.add(new int[]{x, y});

    while (true) {
      time++;

      x += plusX;
      y += plusY;

      if (check(x, y)) {
        return time;
      }

      if (board[x][y] == 1) {
        board[x][y] = 0;
      }
      else {
        snake.pollLast();
      }

      snake.addFirst(new int[]{x, y});

      if (map.containsKey(time)) {
        String turn = map.get(time);
        int temp = plusX;
        if (turn.equals("L")) {
          plusX = -plusY;
          plusY = temp;
        }
        else {
          plusX = plusY;
          plusY = -temp;
        }
      }
    }
  }

  static boolean check(int x1, int y1) {
    if (x1 < 0 || y1 < 0 || x1 >= N || y1 >= N) {
      return true;
    }
    for (int[] i : snake) {
      if (i[0] == x1 && i[1] == y1) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    board = new int[N][N];

    K = Integer.parseInt(br.readLine());
    for (int i = 0; i < K; i++) {
      String[] apple = br.readLine().split(" ");
      int a = Integer.parseInt(apple[0]) - 1;
      int b = Integer.parseInt(apple[1]) - 1;
      board[a][b] = 1;
    }

    L = Integer.parseInt(br.readLine());
    map = new HashMap<>();
    for (int i = 0; i < L; i++) {
      String[] directionInput = br.readLine().split(" ");
      int t = Integer.parseInt(directionInput[0]);
      String d = directionInput[1];
      map.put(t, d);
    }

    System.out.println(dummy());
  }
}