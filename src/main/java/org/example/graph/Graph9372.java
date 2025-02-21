package org.example.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Graph9372 {
  static boolean[] visited;
  static LinkedList<Integer>[] graph;
  static int count = 0;

  static void dfs(int v) {
    visited[v] = true;

    for (int next : graph[v]) {
      if (!visited[next]) {
        count++;
        dfs(next);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      graph = new LinkedList[N + 1];
      visited = new boolean[N + 1];
      count = 0;
      for (int j = 1; j < N + 1; j++) {
        graph[j] = new LinkedList<>();
      }

      for (int j = 0; j < M; j++) {
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        graph[u].add(v);
        graph[v].add(u);
      }

      dfs(1);
      sb.append(count).append("\n");
    }

    System.out.println(sb);
  }
}

// 58992KB / 400ms

/*
* public class Graph9372 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      for (int j = 0; j < M; j++) {
        br.readLine();
      }

      sb.append(N - 1).append("\n");
    }

    System.out.print(sb);
  }
}
*
* 24204KB / 188ms*/