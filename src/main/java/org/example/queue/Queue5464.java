package org.example.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue5464 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] parking = new int[N];
    int[] fee = new int[N];
    int[] weight = new int[M];
    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      fee[i] = Integer.parseInt(br.readLine());
      parking[i] = 0;
    }

    for (int i = 0; i < M; i++) {
      weight[i] = Integer.parseInt(br.readLine());
    }

    int sum = 0;
    for (int i = 0; i < 2 * M; i++) {
      int n = Integer.parseInt(br.readLine());

      if (n > 0) {
        boolean flag = false;
        for (int j = 0; j < N; j++) {
          if (parking[j] == 0) {
            parking[j] = n;
            flag = true;
            break;
          }
        }
        if (!flag) {
          q.add(n);
        }
      } else {
        n = -n;
        for (int j = 0; j < N; j++) {
          if (parking[j] == n) {
            sum += fee[j] * weight[n - 1];
            parking[j] = 0;
            if (!q.isEmpty()) {
              int next = q.poll();
              parking[j] = next;
            }
            break;
          }
        }
      }
    }

    System.out.println(sum);
  }
}

// 16196KB / 124ms