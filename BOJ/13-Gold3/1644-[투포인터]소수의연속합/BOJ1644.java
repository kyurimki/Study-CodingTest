import java.util.*;

public class BOJ1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        ArrayList<Integer> primeNum = getPrimeNums(N);
        int start = 0, end = 0, sum = 0, count = 0;
        while(true) {
            if(sum >= N) sum -= primeNum.get(start++);
            else if(end == primeNum.size()) break;
            else sum += primeNum.get(end++);

            if(sum == N) count++;
        }
        System.out.println(count);
    }

    static ArrayList<Integer> getPrimeNums(int N) {
        boolean[] isNotPrime = new boolean[N+1];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2; i <= N; i++) {
            for(int j = i*2; j <= N; j+=i) isNotPrime[j] = true;
        }

        for(int i = 2; i <= N; i++) {
            if(!isNotPrime[i]) list.add(i);
        }

        return list;
    }
}