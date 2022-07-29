import java.util.*;

public class BOJ2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) q.add(i);

        boolean flag = true;
        while(q.size() != 1) {
            if(flag) q.poll();
            else q.offer(q.poll());
            flag = !flag;
        }

        System.out.println(q.poll());

        sc.close();
    }
}