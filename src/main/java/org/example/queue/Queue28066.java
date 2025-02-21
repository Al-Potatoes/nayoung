package org.example.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Queue28066 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < N; i++) {
      deque.addLast(i + 1);
    }

    while (deque.size() >= K) {
      deque.addLast(deque.pollFirst());
      for (int i = 1; i < K; i++) {
        deque.pollFirst();
      }
    }

    System.out.println(deque.peek());
  }
}

// 44696KB / 188ms
/*
* 일단 전부 다 넣고
* 첫번째는 뒤로 보내고 K-1번 앞에서 제거
* 마지막 남은거 출력*/