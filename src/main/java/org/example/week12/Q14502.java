package org.example.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14502 {
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int[][] map;
  static int N, M, max = 0;

  static void dfs(int x, int y, int[][] temp) {
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i], ny = y + dy[i];
      if (nx >= 0 && ny >= 0 && nx < N && ny < M && temp[nx][ny] == 0) {
        temp[nx][ny] = 2;
        dfs(nx, ny, temp);
      }
    }
  }

  static int countSafeZone(int[][] temp) {
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (temp[i][j] == 0)
          count++;
      }
    }
    return count;
  }

  static void buildWall(int count, int startX, int startY) {
    if (count == 3) {
      int[][] temp = new int[N][M];
      for (int i = 0; i < N; i++)
        System.arraycopy(map[i], 0, temp[i], 0, M);

      for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
          if (temp[i][j] == 2)
            dfs(i, j, temp);

      max = Math.max(max, countSafeZone(temp));
      return;
    }

    for (int i = startX; i < N; i++) {
      for (int j = (i == startX ? startY : 0); j < M; j++) {
        if (map[i][j] == 0) {
          map[i][j] = 1;
          buildWall(count + 1, i, j + 1);
          map[i][j] = 0;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    buildWall(0, 0, 0);
    System.out.println(max);
  }
}

// 296ms