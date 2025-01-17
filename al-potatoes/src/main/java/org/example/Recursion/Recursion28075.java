package org.example.Recursion;

import java.util.Scanner;

public class Recursion28075 {
    static int N, M;
    static int[][] progressInfo = new int[2][3];

     static int getProgress(int day, int progress, int prevSite) {
        if (day == N) {
            if (progress >= M)
                return 1;
            return 0;
        }

        int cnt = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                int curProgress;

                if (j == prevSite)
                    curProgress = progressInfo[i][j] / 2;
                else curProgress = progressInfo[i][j];

                cnt += getProgress(day + 1, progress + curProgress, j);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                progressInfo[i][j] = sc.nextInt();
            }
        }

        System.out.println(getProgress(0, 0,-1));
    }
}
