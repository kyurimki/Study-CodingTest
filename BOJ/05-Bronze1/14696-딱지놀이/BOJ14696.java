import java.io.*;
import java.util.*;

public class BOJ14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 딱지놀이의 총 라운드 수
        int[] A;
        int[] B;
        for (int i = 0; i < N; i++) {
            A = new int[5];
            B = new int[5];

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // A가 낸 그림의 총 개수
            for (int j = 0; j < a; j++) {
                int x = Integer.parseInt(st.nextToken()); // A가 낸 그림
                A[x]++;
            }

            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken()); // B가 낸 그림의 총 개수
            for (int j = 0; j < b; j++) {
                int x = Integer.parseInt(st.nextToken()); // B가 낸 그림
                B[x]++;
            }

            boolean flag = false;
            for (int j = 4; j > 0; j--) {
                if (A[j] != B[j]) {
                    if (A[j] > B[j])
                        sb.append("A\n");
                    else if (A[j] < B[j])
                        sb.append("B\n");

                    flag = true;
                    break;
                }
            }
            if (!flag)
                sb.append("D\n");
        }
        System.out.print(sb);
    }
}