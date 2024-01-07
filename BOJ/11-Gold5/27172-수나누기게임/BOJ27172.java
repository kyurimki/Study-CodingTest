/*
 * 2024.01.07
 * 1~1000000 범위 카드 -> SIZE=1000001로 정의
 * 어떤 수도 x에서 2번 이상 등장 X -> boolean[] cards 정의
 * 플레이어가 갖고 있는 카드의 2의 배수~SIZE까지 돌면서 점수 계산
 * 첫 시도 때 i <= SIZE로 두면서 ArrayIndexOutOfBounds 발생
 */

import java.io.*;
import java.util.*;

public class BOJ27172 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int SIZE = 1000001;
        int[] players = new int[N];
        boolean[] cards = new boolean[SIZE];
        int[] score = new int[SIZE];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            players[i] = Integer.parseInt(st.nextToken());
            cards[players[i]] = true;
        }

        for(int player : players) {
            for(int i = player*2; i < SIZE; i += player) {
                if(cards[i]) {
                    score[player]++;
                    score[i]--;
                }
            }
        }
        for(int player : players) sb.append(score[player]).append(' ');
        System.out.println(sb);
    }
}