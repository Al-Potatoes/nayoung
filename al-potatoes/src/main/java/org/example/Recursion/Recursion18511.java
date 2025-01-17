package org.example.Recursion;

import java.util.Scanner;

public class Recursion18511 {
    static int[] arr;

    static void sortArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static int getMax(int N, int x) {
        if (x > N)
            return 0;

        int max = x;

        for (int i = 0; i < arr.length; i++) {
            int n = getMax(N, x * 10 + arr[i]);
            max = Math.max(max, n);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), num = sc.nextInt();
        arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        sortArray(arr);

        System.out.println(getMax(N, 0));
    }
}
