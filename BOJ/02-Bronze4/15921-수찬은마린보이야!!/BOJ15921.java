import java.io.*;
import java.util.*;

public class BOJ15921 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 0) {
            System.out.println("divide by zero");
            System.exit(0);
        }

        int[] score = new int[n];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            sum += score[i];
        }

        double average = (double)sum / n;
        double ex = 0;

        for(int i = 0; i < n; i++) {
            ex += (score[i] * ((double)1/n));
        }

        if(ex == 0) System.out.println("divide by zero");
        else System.out.printf("%.2f", average/ex);
    }
}