package org.example.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2468 {
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int[][] arr;
  static boolean[][] visited;
  static int N;

  static void dfs(int x, int y, int height) {
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
        if (arr[nx][ny] > height && !visited[nx][ny]) {
          dfs(nx, ny, height);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    int max = 0;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        max = Math.max(max, arr[i][j]);
      }
    }

    int maxSafeArea = 1;

    for (int h = 0; h <= max; h++) {
      visited = new boolean[N][N];
      int safeArea = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (arr[i][j] > h && !visited[i][j]) {
            dfs(i, j, h);
            safeArea++;
          }
        }
      }

      maxSafeArea = Math.max(maxSafeArea, safeArea);
    }

    System.out.println(maxSafeArea);
  }
}

// 212ms