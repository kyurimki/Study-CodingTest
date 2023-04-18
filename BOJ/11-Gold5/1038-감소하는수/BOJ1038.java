import java.util.*;

public class BOJ1038 {
    static ArrayList<Long> numList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        if(N < 10) System.out.println(N);
        else if(N >= Math.pow(2, 10)-1) System.out.println(-1);
        else {
            for(int i = 0; i < 10; i++) dfs(i, 1);
            Collections.sort(numList);
            System.out.println(numList.get(N));
        }
    }

    static void dfs(long num, int idx) {
        if(idx > 10) return ;

        numList.add(num);
        for(int i = 0; i < num%10; i++)
            dfs(num*10+i, idx+1);
    }
}