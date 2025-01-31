package org.example.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Heap1655 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < N; i++) {
      int n = Integer.parseInt(br.readLine());

      if (pq2.isEmpty() || n <= pq2.peek())
        pq2.add(n);
      else
        pq1.add(n);

      if (pq1.size() + 1 < pq2.size())
        pq1.add(pq2.poll());
      else if (pq1.size() > pq2.size())
        pq2.add(pq1.poll());

      sb.append(pq2.peek());
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
