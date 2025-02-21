package org.example.graph;

import java.io.*;
import java.util.*;

public class Graph7576 {
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int[][] farm, dist;
  static int M, N;
  static Queue<int[]> queue = new LinkedList<>();

  static void bfs() {
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int x = cur[0];
      int y = cur[1];

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
          if (farm[nx][ny] == 0 && dist[nx][ny] == -1) {
            farm[nx][ny] = 1;
            dist[nx][ny] = dist[x][y] + 1;
            queue.offer(new int[]{nx, ny});
          }
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    farm = new int[N][M];
    dist = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        farm[i][j] = Integer.parseInt(st.nextToken());

        if (farm[i][j] == 1) {
          queue.offer(new int[]{i, j});
        }
        if (farm[i][j] == 0) {
          dist[i][j] = -1;
        }
      }
    }

    bfs();

    int day = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (dist[i][j] == -1) {
          System.out.println(-1);
          return;
        }
        day = Math.max(day, dist[i][j]);
      }
    }
    System.out.println(day);
  }
}

//123772KB / 628ms
