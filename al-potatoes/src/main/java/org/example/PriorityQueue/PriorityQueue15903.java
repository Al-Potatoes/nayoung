package org.example.PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueue15903 {
  static void minScore(PriorityQueue<Long> pq) {
    Long x = pq.poll();
    Long y = pq.poll();

    pq.add(x + y);
    pq.add(x + y);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), m = sc.nextInt();

    PriorityQueue<Long> pq = new PriorityQueue<>();

    for (int i = 0; i < n; i++)
      pq.add(sc.nextLong());

    for (int i = 0; i < m; i++)
      minScore(pq);

    long sum = 0;
    while (!pq.isEmpty())
      sum += pq.poll();

    System.out.println(sum);

    sc.close();
  }
}
