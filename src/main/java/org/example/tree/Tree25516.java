package org.example.tree;

import java.io.*;
import java.util.*;

public class Tree25516 {
  static List<Integer>[] tree;
  static int[] apples;
  static int n, k, totalApples = 0;

  static void dfs(int node, int distance) {
    if (distance > k) return;
    totalApples += apples[node];
    for (int child : tree[node]) {
      dfs(child, distance + 1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    tree = new ArrayList[n];
    apples = new int[n];

    for (int i = 0; i < n; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int parent = Integer.parseInt(st.nextToken());
      int child = Integer.parseInt(st.nextToken());
      tree[parent].add(child);
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      apples[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0, 0);
    System.out.println(totalApples);
  }
}

// 67484KB / 416ms
