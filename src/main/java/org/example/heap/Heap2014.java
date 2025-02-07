package org.example.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Heap2014 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    int K = Integer.parseInt(input[0]);
    int N = Integer.parseInt(input[1]);

    long[] arr = new long[K];
    PriorityQueue<Long> q = new PriorityQueue<>();

    String[] input2 = br.readLine().split(" ");
    for (int i = 0; i < K; i++) {
      arr[i] = Long.parseLong(input2[i]);
      q.add(arr[i]);
    }

    for (int i = 0; i < N - 1; i++) {
      long num = q.poll();

      for (int j = 0; j < K; j++) {
        q.add(num * arr[j]);

        if (num % arr[j] == 0)
          break;
      }
    }

    System.out.println(q.poll());
  }
}
