package org.example.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LinkedList30885 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    LinkedList<long[]> list = new LinkedList<>();

    String[] a = br.readLine().split(" ");
    for (int i = 0; i < N; ++i) {
      list.addLast(new long[]{Long.parseLong(a[i]), i + 1});
    }

    while (list.size() > 1) {
      LinkedList<long[]> tmp = new LinkedList<>();
      long[] prev = {0, 0};

      while (!list.isEmpty()) {
        long[] curr = list.removeFirst();
        long size = curr[0];

        if (prev[0] > 0) {
          if (curr[0] >= prev[0])
            size += prev[0];
          else
            tmp.addLast(prev);
        }
        if (!list.isEmpty()) {
          long[] next = list.getFirst();
          if (curr[0] >= next[0]) {
            size += next[0];
            list.removeFirst();
          }
        }
        curr[0] = size;
        prev = curr;
      }
      if (prev[0] > 0)
        tmp.add(prev);
      list = tmp;
    }

    System.out.println(list.getLast()[0]);
    System.out.println(list.getLast()[1]);
  }
}
