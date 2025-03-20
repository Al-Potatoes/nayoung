package org.example.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tree9934 {
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int K = Integer.parseInt(br.readLine());
    int N = (int) Math.pow(2, K) - 1;

    int[] arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    TreeNode1 root = buildTree(arr, 0, N - 1);

    levelOrder(root);

    System.out.println(sb);
  }

  static TreeNode1 buildTree(int[] arr, int s, int e) {
    if (s > e)
      return null;

    int mid = (s + e) / 2;
    TreeNode1 root = new TreeNode1(arr[mid]);

    root.left = buildTree(arr, s, mid - 1);
    root.right = buildTree(arr, mid + 1, e);

    return root;
  }

  static void levelOrder(TreeNode1 root) {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    Queue<TreeNode1> q = new LinkedList<TreeNode1>();
    q.offer(root);

    while (!q.isEmpty()) {
      ArrayList<Integer> level = new ArrayList<>();

      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode1 node = q.poll();
        level.add(node.val);

        if (node.left != null)
          q.offer(node.left);
        if (node.right != null)
          q.offer(node.right);
      }
      list.add(level);
    }

    for (ArrayList<Integer> level : list) {
      for (int val : level) {
        sb.append(val).append(" ");
      }
      sb.append("\n");
    }
  }
}

class TreeNode1 {
  int val;
  TreeNode1 left;
  TreeNode1 right;

  public TreeNode1(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

// 14676KB / 116ms
