package org.example.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Tree1991 {
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    Map<Character, TreeNode1> tree = new HashMap<>();

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      char A = st.nextToken().charAt(0);
      char B = st.nextToken().charAt(0);
      char C = st.nextToken().charAt(0);

      if (!tree.containsKey(A)) {
        tree.put(A, new TreeNode1(A));
      }
      if (B != '.') {
        tree.put(B, new TreeNode1(B));
        tree.get(A).left = tree.get(B);
      }
      if (C != '.') {
        tree.put(C, new TreeNode1(C));
        tree.get(A).right = tree.get(C);
      }
    }
    TreeNode1 root = tree.get('A');

    preOrderTraversal(root);
    sb.append('\n');
    inOrderTraversal(root);
    sb.append('\n');
    postOrderTraversal(root);

    System.out.print(sb);
  }

  // 전위순회
  static void preOrderTraversal(TreeNode1 root) {
    if (root == null) {
      return;
    }
    sb.append(root.val);
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
  }

  // 중위순회
  static void inOrderTraversal(TreeNode1 root) {
    if (root == null) {
      return;
    }
    inOrderTraversal(root.left);
    sb.append(root.val);
    inOrderTraversal(root.right);
  }

  // 후위순회
  static void postOrderTraversal(TreeNode1 root) {
    if (root == null) {
      return;
    }
    postOrderTraversal(root.left);
    postOrderTraversal(root.right);
    sb.append(root.val);
  }
}

class TreeNode {
  char val;
  TreeNode1 left;
  TreeNode1 right;

  public TreeNode(char val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

// 14124 KB / 104ms
