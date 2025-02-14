package org.example.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Graph2667 {
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int[][] map;
  static boolean[][] visited;
  static int N, count;

  static void dfs(int x, int y) {
    visited[x][y] = true;
    count++;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
        if (map[nx][ny] == 1 && !visited[nx][ny]) {
          dfs(nx, ny);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = Character.getNumericValue(input.charAt(j));
        visited[i][j] = false;
      }
    }

    ArrayList<Integer> house = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          count = 0;
          dfs(i, j);
          house.add(count);
        }
      }
    }

    Collections.sort(house);

    sb.append(house.size()).append("\n");
    for (int i = 0; i < house.size(); i++) {
      sb.append(house.get(i)).append("\n");
    }

    System.out.println(sb);
  }
}

// 14244KB / 104ms