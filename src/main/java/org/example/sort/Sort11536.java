package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Sort11536 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String[] name = new String[N];

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      name[i] = s;
    }

    String[] copyUp = name.clone();
    String[] copyDown = name.clone();

    Arrays.sort(copyUp);
    Arrays.sort(copyDown, Comparator.reverseOrder());

    if (Arrays.equals(name, copyUp)) {
      System.out.println("INCREASING");
    } else if (Arrays.equals(name, copyDown)) {
      System.out.println("DECREASING");
    } else {
      System.out.println("NEITHER");
    }
  }
}
/*
* 기존 배열, 증가 배열, 감소 배열
* 비교해서 출력
* */