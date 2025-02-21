package org.example.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph6858 {
  static int[] indegree;
  static List<List<Integer>> graph;

  private static List<Integer> topologicalSort() {
    List<Integer> result = new ArrayList<>();
    Queue<Integer> q = new PriorityQueue<>();

    for (int i = 1; i <= 7; i++) {
      if (indegree[i] == 0) {
        q.offer(i);
      }
    }

    while (!q.isEmpty()) {
      int now = q.poll();
      result.add(now);

      for (int next : graph.get(now)) {
        indegree[next]--;
        if (indegree[next] == 0) {
          q.offer(next);
        }
      }
    }

    if (result.size() != 7) {
      return new ArrayList<>();
    }

    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    graph = new ArrayList<>();
    indegree = new int[8];

    for (int i = 0; i <= 7; i++) {
      graph.add(new ArrayList<>());
    }

    int[][] toDo = { {1, 7}, {1, 4}, {2, 1}, {3, 4}, {3, 5} };

    for (int[] c : toDo) {
      graph.get(c[0]).add(c[1]);
      indegree[c[1]]++;
    }

    while (true) {
      int a = Integer.parseInt(br.readLine());
      int b = Integer.parseInt(br.readLine());
      if (a == 0 && b == 0)
        break;

      graph.get(a).add(b);
      indegree[b]++;
    }

    List<Integer> order = topologicalSort();

    if (order.isEmpty()) {
      System.out.println("Cannot complete these tasks. Going to bed.");
    } else {
      StringBuilder sb = new StringBuilder();
      for (int task : order) {
        sb.append(task).append(" ");
      }
      System.out.println(sb.toString().trim());
    }
  }
}

// 14112KB / 100ms
/*
* 각 노드의 진입 차수를 계산
진입 차수가 0인 노드를 큐에 삽입
큐에서 노드를 꺼내면서 해당 노드와 연결된 간선 제거
새롭게 진입 차수가 0이 된 노드를 다시 큐에 삽입
큐가 빌 때까지 반복
* */