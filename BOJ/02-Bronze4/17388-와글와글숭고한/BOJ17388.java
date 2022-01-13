import java.util.*;

public class BOJ17388 {
    public static void main(String[] args) {
        String[] schools = {"Soongsil", "Korea", "Hanyang"};

        Scanner sc = new Scanner(System.in);

        int scores[] = new int[3];
        int idx = 0;
        int sum = 0;
        for(int i = 0; i < 3; i++) {
            scores[i] = sc.nextInt();
            sum += scores[i];
            if(scores[idx] > scores[i]) idx = i;
        }

        if(sum >= 100) System.out.println("OK");
        else System.out.println(schools[idx]);

        sc.close();
    }
}