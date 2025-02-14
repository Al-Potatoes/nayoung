package org.example.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Graph2606 {
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

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    graph = new LinkedList[N + 1];
    visited = new boolean[N + 1];

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

    dfs(1);
    System.out.println(count);
  }
}

// 14224KB / 108ms