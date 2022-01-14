import java.util.*;

public class BOJ17009 {
    public static void main(String[] args) {
        int[] score = new int[2];
        
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 2; i++) {
            for(int j = 3; j > 0; j--) {
                score[i] += sc.nextInt()*j;
            }
        }

        if(score[0] > score[1]) System.out.println("A");
        else if(score[0] < score[1]) System.out.println("B");
        else System.out.println("T");

        sc.close();
    }
}