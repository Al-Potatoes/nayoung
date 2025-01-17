package org.example.PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueue1715 {
  static int minNumOfComparsion(PriorityQueue<Integer> pq) {
    int cnt = 0;

    while (pq.size() > 1) {
      int A = pq.poll();
      int B = pq.poll();

      cnt += A + B;
      pq.add(A + B);
    }

    return cnt;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < N; i++)
      pq.add(sc.nextInt());

    System.out.println(minNumOfComparsion(pq));

    sc.close();
  }
}
