package org.example.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Tree25601 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    Map<String, String> tree = new HashMap<>();

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      String child = st.nextToken();
      String parent = st.nextToken();
      tree.put(child, parent);
    }

    st = new StringTokenizer(br.readLine());
    String A = st.nextToken();
    String B = st.nextToken();

    if (check(A, B, tree) || check(B, A, tree)) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }

  private static boolean check(String A, String B, Map<String, String> tree) {
    String cur = A;
    while (tree.containsKey(cur)) {
      cur = tree.get(cur);
      if (cur.equals(B)) {
        return true;
      }
    }
    return false;
  }
}

// 52440KB / 444ms
