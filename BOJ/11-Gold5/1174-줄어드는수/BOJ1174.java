import java.util.*;

public class BOJ1174 {
    static int N;
    static int[] numset = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static ArrayList<Long> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        if(N >= 1024)
            System.out.println(-1);
        else {
            list = new ArrayList<>();
            dfs(0, 0);
            
            Collections.sort(list);
            System.out.println(list.get(N-1));
        }
        sc.close();
    }

    static void dfs(long num, int idx) {
        if(!list.contains(num))
            list.add(num);
        
        if(idx >= 10) return ;

        dfs(10*num+numset[idx], idx+1);
        dfs(num, idx+1);
    }
}