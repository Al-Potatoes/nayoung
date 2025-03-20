package org.example.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tree11725 {
  static int N;
  static List<Integer>[] tree;
  static int[] parent;
  static boolean[] visited;

  static void dfs(int v) {
    visited[v] = true;

    for (int child : tree[v]) {
      if (!visited[child]) {
        parent[child] = v;
        dfs(child);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    tree = new List[N + 1];
    parent = new int[N + 1];
    visited = new boolean[N + 1];
    for (int i = 1; i <= N; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      tree[a].add(b);
      tree[b].add(a);
    }

    dfs(1);

    for (int i = 2; i <= N; i++) {
      sb.append(parent[i]).append("\n");
    }
    System.out.println(sb);
  }
}

// 64956KB / 484ms