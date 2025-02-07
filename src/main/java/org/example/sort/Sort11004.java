package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// merge sort
public class Sort11004 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);

    int[] arr = new int[N];

    String[] input2 = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(input2[i]);
    }

    mergeSort(arr);

    System.out.println(arr[K - 1]);
  }

  static void mergeSort(int[] arr) {
    if (arr.length > 1) {
      int mid = arr.length / 2;

      int[] arr1 = Arrays.copyOfRange(arr, 0, mid);
      int[] arr2 = Arrays.copyOfRange(arr, mid, arr.length);

      mergeSort(arr1);
      mergeSort(arr2);

      merge(arr, arr1, arr2);
    }
  }

  static void merge(int[] arr, int[] arr1, int[] arr2) {
    int i = 0, j = 0, k = 0;

    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] <= arr2[j]) {
        arr[k++] = arr1[i++];
      } else {
        arr[k++] = arr2[j++];
      }
    }

    while (i < arr1.length) {
      arr[k++] = arr1[i++];
    }

    while (j < arr2.length) {
      arr[k++] = arr2[j++];
    }
  }
}


