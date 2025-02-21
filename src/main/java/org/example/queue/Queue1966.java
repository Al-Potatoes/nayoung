package org.example.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue1966 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int C = Integer.parseInt(br.readLine());

    for (int i = 0; i < C; i++) {
      Queue<int[]> q = new LinkedList<>();
      PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int n = Integer.parseInt(st.nextToken());
        q.add(new int[]{n, j});
        pq.add(n);
      }

      int count = 0;
      while (!pq.isEmpty()) {
        int n = pq.peek();
        int[] cur = q.poll();
        if (n == cur[0]) {
          pq.poll();
          count++;
          if (cur[1] == M) {
            break;
          }
        } else {
          q.add(cur);
        }

      }
      sb.append(count).append("\n");
    }
    System.out.println(sb);
  }
}

// 14700KB / 124ms