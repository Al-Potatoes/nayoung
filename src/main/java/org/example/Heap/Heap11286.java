package org.example.Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

class AbsHeap {
  int value;
  int abs;

  public AbsHeap(int value) {
    this.value = value;
    this.abs = Math.abs(value);
  }
}

public class Heap11286 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    PriorityQueue<AbsHeap> pq = new PriorityQueue<>((a, b) -> {
      if (a.abs == b.abs)
        return Integer.compare(a.value, b.value);
      else
        return Integer.compare(a.abs, b.abs);
    });

    for (int i = 0; i < N; i++) {
      int n = sc.nextInt();

      if (n == 0) {
        if (pq.peek() == null)
          System.out.println(0);
        else
          System.out.println(pq.poll().value);
      }
      else pq.add(new AbsHeap(n));
    }

    sc.close();
  }
}
