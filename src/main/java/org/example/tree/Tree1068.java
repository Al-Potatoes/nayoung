package org.example.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tree1068 {

  static ArrayList<Integer>[] tree;
  static int target;
  static int count = 0;

  static void dfs(int v) {
    if (v == target) {
      return;
    }

    int childCount = 0;
    for (int next : tree[v]) {
      if (next != target) {
        childCount++;
        dfs(next);
      }
    }

    if (childCount == 0) {
      count++;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    tree = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      tree[i] = new ArrayList<>();
    }

    int root = 0;
    for (int i = 0; i < N; i++) {
      int n = Integer.parseInt(st.nextToken());
      if (n == -1) {
        root = i;
      } else {
        tree[n].add(i);
      }
    }

    target = Integer.parseInt(br.readLine());

    dfs(root);
    System.out.println(count);
  }
}

// 14236KB / 104ms
