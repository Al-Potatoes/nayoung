package org.example.graph;

import java.io.*;
import java.util.*;

public class Graph14218 {
  static LinkedList<Integer>[] graph;

  static int[] bfs(int start, int n) {
    int[] result = new int[n + 1];
    Arrays.fill(result, -1);
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    result[start] = 0;

    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int next : graph[cur]) {
        if (result[next] == -1) {
          result[next] = result[cur] + 1;
          queue.offer(next);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String[] input = br.readLine().trim().split("\\s+");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    graph = new LinkedList[n + 1];
    for (int i = 1; i <= n; i++) {
      graph[i] = new LinkedList<>();
    }

    for (int i = 0; i < m; i++) {
      input = br.readLine().trim().split("\\s+");
      int u = Integer.parseInt(input[0]);
      int v = Integer.parseInt(input[1]);
      graph[u].add(v);
      graph[v].add(u);
    }

    input = br.readLine().trim().split("\\s+");
    int q = Integer.parseInt(input[0]);
    for (int i = 0; i < q; i++) {
      input = br.readLine().trim().split("\\s+");
      int u = Integer.parseInt(input[0]);
      int v = Integer.parseInt(input[1]);

      graph[u].add(v);
      graph[v].add(u);

      int[] result = bfs(1, n);
      for (int j = 1; j <= n; j++) {
        sb.append(result[j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
// 1412ms