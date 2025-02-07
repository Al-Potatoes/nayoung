package org.example.array;

import java.util.Scanner;

public class Array20437 {
  static int[] getStringLength(String w, int k) {
    int[] alphabet = new int[26];
    for (char ch : w.toCharArray()) {
      alphabet[ch - 'a']++;
    }

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < 26; i++) {
      if (alphabet[i] < k) continue;

      char ch = (char) ('a' + i);
      int count = 0;
      int first = -1;

      for (int j = 0; j < w.length(); j++) {
        if (w.charAt(j) == ch) {
          count++;
          if (count == 1) first = j;
          if (count == k) {
            int length = j - first + 1;
            min = Math.min(min, length);
            max = Math.max(max, length);
            first++;
            count--;
          }
        }
      }
    }

    return (min == Integer.MAX_VALUE) ? new int[]{-1} : new int[]{min, max};
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int i = 0; i < T; i++) {
      String w = sc.next();
      int K = sc.nextInt();
      int[] result = getStringLength(w, K);

      if (result[0] == -1)
        System.out.println(-1);
      else
        System.out.println(result[0] + " " + result[1]);
    }

    sc.close();
  }
}
