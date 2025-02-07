package org.example.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.HashMap;

public class Heap7662 {
  static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  static HashMap<Integer, Integer> map = new HashMap<>();

  static void addNum(int n) {
    minHeap.add(n);
    maxHeap.add(n);
    map.put(n, map.getOrDefault(n, 0) + 1);
  }

  static void removeNum(int n) {
    if (n == 1) {
      cleanHeap(maxHeap);
      if (!maxHeap.isEmpty()) {
        int maxValue = maxHeap.poll();
        map.put(maxValue, map.get(maxValue) - 1);
      }
    }
    else if (n == -1) {
      cleanHeap(minHeap);
      if (!minHeap.isEmpty()) {
        int minValue = minHeap.poll();
        map.put(minValue, map.get(minValue) - 1);
      }
    }
  }

  static void cleanHeap(PriorityQueue<Integer> heap) {
    while (!heap.isEmpty() && map.getOrDefault(heap.peek(), 0) == 0) {
      heap.poll();
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      int k = Integer.parseInt(br.readLine());
      minHeap.clear();
      maxHeap.clear();
      map.clear();

      for (int j = 0; j < k; j++) {
        String[] input = br.readLine().split(" ");
        String op = input[0];
        int n = Integer.parseInt(input[1]);

        if (op.equals("I"))
          addNum(n);
        else if (op.equals("D"))
          removeNum(n);
      }

      cleanHeap(minHeap);
      cleanHeap(maxHeap);

      if (minHeap.isEmpty() || maxHeap.isEmpty())
        bw.write("EMPTY\n");
      else
        bw.write(maxHeap.peek() + " " + minHeap.peek() + "\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
