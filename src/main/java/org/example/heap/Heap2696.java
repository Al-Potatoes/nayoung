package org.example.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Heap2696 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int M = Integer.parseInt(br.readLine());

      PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      ArrayList<Integer> result = new ArrayList<>();

      int count = 0;
      while (count < M) {
        String[] input = br.readLine().split(" ");
        for (String num : input) {
          int value = Integer.parseInt(num);
          count++;

          if (maxHeap.isEmpty() || value <= maxHeap.peek())
            maxHeap.offer(value);
          else
            minHeap.offer(value);

          if (maxHeap.size() > minHeap.size() + 1)
            minHeap.offer(maxHeap.poll());
          else if (maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());

          if (count % 2 == 1)
            result.add(maxHeap.peek());

          if (count == M)
            break;
        }
      }

      sb.append(result.size()).append("\n");

      for (int j = 0; j < result.size(); j++) {
        sb.append(result.get(j)).append(" ");
        if ((j + 1) % 10 == 0)
          sb.append("\n");
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}