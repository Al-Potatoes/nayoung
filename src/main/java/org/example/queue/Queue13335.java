package org.example.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue13335 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

    Queue<Integer> line = new LinkedList<>();
    Queue<Integer> bridge = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      line.add(Integer.parseInt(st.nextToken()));
    }

    int time = 0;
    int sum = 0;

    for (int i = 0; i < w; i++) {
      bridge.add(0);
    }

    while (!line.isEmpty() || sum != 0) {
      sum -= bridge.poll();

      if (!line.isEmpty()) {
        int truck = line.peek();
        if (sum + truck <= L) {
          bridge.add(line.poll());
          sum += truck;
        } else {
          bridge.add(0);
        }
      } else {
        bridge.add(0);
      }
      time++;
    }

    System.out.println(time);
  }
}

// 15192KB / 124ms