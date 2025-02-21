package org.example.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph14567 {
  public static int N, M;
  public static int[] indegree, semester;
  public static List<List<Integer>> graph;

  public static void topologySort() {
    Queue<Integer> q = new LinkedList<>();

    for (int i = 1; i <= N; i++) {
      if (indegree[i] == 0) {
        q.offer(i);
        semester[i] = 1;
      }
    }

    while (!q.isEmpty()) {
      int now = q.poll();

      for (int next : graph.get(now)) {
        indegree[next]--;
        semester[next] = Math.max(semester[next], semester[now] + 1);

        if (indegree[next] == 0) {
          q.offer(next);
        }
      }
    }

    for (int i = 1; i <= N; i++) {
      System.out.print(semester[i] + " ");
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new ArrayList<>();
    indegree = new int[N + 1];
    semester = new int[N + 1];

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());

      graph.get(A).add(B);
      indegree[B]++;
    }

    topologySort();
  }
}

// 128880KB / 592ms