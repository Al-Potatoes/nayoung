package org.example.LinkedList;

import java.io.*;
import java.util.*;

public class LinkedList1406 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String input = br.readLine();
    LinkedList<Character> list = new LinkedList<>();

    for (char c : input.toCharArray()) {
      list.add(c);
    }

    ListIterator<Character> count = list.listIterator(list.size());

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      String op = br.readLine();

      switch (op.charAt(0)) {
        case 'P':
          count.add(op.charAt(2));
          break;
        case 'L':
          if (count.hasPrevious()) count.previous();
          break;
        case 'D':
          if (count.hasNext()) count.next();
          break;
        case 'B':
          if (count.hasPrevious()) {
            count.previous();
            count.remove();
          }
          break;
      }
    }

    for (char c : list) {
      sb.append(c);
    }

    System.out.println(sb.toString());
  }
}
