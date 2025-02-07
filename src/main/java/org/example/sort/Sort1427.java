package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// quick sort
public class Sort1427 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String input = br.readLine();
    char[] arr = input.toCharArray();

    quicksort(arr, 0, arr.length - 1);

    for (char c : arr) {
      sb.append(c);
    }

    System.out.println(sb);
  }

  static void quicksort(char[] arr, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(arr, low, high);

      quicksort(arr, low, pivotIndex - 1);
      quicksort(arr, pivotIndex + 1, high);
    }
  }

  static int partition(char[] arr, int low, int high) {
    char pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (arr[j] > pivot) {
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, high);
    return i + 1;
  }

  static void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}