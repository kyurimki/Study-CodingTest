import java.io.*;
import java.util.*;

class Jewel1202 implements Comparable<Jewel1202> {
    int weight, price;

    public Jewel1202(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewel1202 j) {
        if(this.weight == j.weight) return j.price-this.price;
        return this.weight-j.weight;
    }
}

public class BOJ1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel1202> jewels = new PriorityQueue<>();
        ArrayList<Integer> bags = new ArrayList<>();

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel1202(M, V));
        }

        while(K-- > 0) bags.add(Integer.parseInt(br.readLine()));
        Collections.sort(bags);

        System.out.println(steal(jewels, bags));
    }

    static long steal(PriorityQueue<Jewel1202> jewels, ArrayList<Integer> bags) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(Integer bag : bags) {
            while(!jewels.isEmpty() && jewels.peek().weight <= bag) pq.add(jewels.poll().price);
            if(!pq.isEmpty()) sum += pq.poll();
        }

        return sum;
    }
}