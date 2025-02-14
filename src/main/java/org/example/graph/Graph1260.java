package org.example.graph;

import java.io.*;
import java.util.*;

public class Graph1260 {
  static boolean[] visited;
  static LinkedList<Integer>[] graph;

  static void dfs(int v) {
    visited[v] = true;
    System.out.print(v + " ");

    for (int next : graph[v]) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }

  static void bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(v);
    visited[v] = true;

    while (!queue.isEmpty()) {
      int temp = queue.poll();
      System.out.print(temp + " ");

      for (int next : graph[temp]) {
        if (!visited[next]) {
          queue.add(next);
          visited[next] = true;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    graph = new LinkedList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new LinkedList<>();
    }

    for (int i = 0; i < M; i++) {
      String[] input = br.readLine().split(" ");
      int u = Integer.parseInt(input[0]);
      int v = Integer.parseInt(input[1]);

      graph[u].add(v);
      graph[v].add(u);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(graph[i]);
    }

    visited = new boolean[N + 1];
    dfs(V);
    System.out.println();

    visited = new boolean[N + 1];
    bfs(V);
    System.out.println();
  }
}

// 21544KB / 272ms