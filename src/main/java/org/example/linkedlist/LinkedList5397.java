package org.example.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LinkedList5397 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      LinkedList<Character> list = new LinkedList<>();

      int count = 0;
      for (int j = 0; j < s.length(); j++) {
        char ch = s.charAt(j);

        if (ch == '<') {
          if (count != 0)
            count--;
        }
        else if (ch == '>') {
          if (count != list.size())
            count++;
        }
        else if (ch == '-') {
          if (count != 0) {
            list.remove(--count);
          }
        }
        else
          list.add(count++, ch);
      }

      for (char c : list)
        sb.append(c);
      sb.append("\n");
    }

    System.out.println(sb.toString());
  }
}
