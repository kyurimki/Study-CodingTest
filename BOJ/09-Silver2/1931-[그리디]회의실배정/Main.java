import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int [][] timetable = new int[N][2];
        for(int i = 0; i < N; i++) {
            timetable[i][0] = sc.nextInt();
            timetable[i][1] = sc.nextInt();
        }

        Arrays.sort(timetable, (p1, p2) -> p1[0] - p2[0]);
        Arrays.sort(timetable, (p1, p2) -> p1[1] - p2[1]);

        int time = 0;
        int answer = 0;
        for(int i = 0; i < N; i++) {
            if(timetable[i][0] >= time) {
                answer++;
                time = timetable[i][1];
            }
        }
        System.out.println(answer);
        sc.close();
    }
}
