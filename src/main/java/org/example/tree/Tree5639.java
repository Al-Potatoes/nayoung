package org.example.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tree5639 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    BinarySearchTree tree = new BinarySearchTree();

    String input;
    while ((input = br.readLine()) != null && !input.isEmpty()) {
      int n = Integer.parseInt(input);
      tree.insert(n);
    }

    StringBuilder sb = tree.postorder();
    System.out.println(sb);
  }
}
class BinarySearchTree {
  static class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
      this.value = value;
    }
  }

  TreeNode root;

  BinarySearchTree() {
    root = null;
  }

  public void insert(int value) {
    root = insert(root, value);
  }

  public TreeNode insert(TreeNode root, int value) {
    if(root == null) {
      root = new TreeNode(value);
      return root;
    }

    if(root.value > value) {
      root.left = insert(root.left, value);
    } else if(root.value < value) {
      root.right = insert(root.right, value);
    }

    return root;
  }

  // 후위 순회
  public StringBuilder postorder() {
    StringBuilder sb = new StringBuilder();
    postorder(root, sb);
    return sb;
  }

  private void postorder(TreeNode root, StringBuilder sb) {
    if (root != null) {
      postorder(root.left, sb);
      postorder(root.right, sb);
      sb.append(root.value).append("\n");
    }
  }
}

// 18056KB / 540ms
