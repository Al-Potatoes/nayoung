package org.example.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueue2075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N * N; i++)
            pq.add(sc.nextInt());

        int cnt = 0;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            cnt++;

            if (cnt == N) {
                System.out.println(num);
                break;
            }
        }
        sc.close();
    }
}
