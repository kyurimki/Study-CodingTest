import java.io.*;
import java.util.*;

public class BOJ13335 {
    static int L;
    static Queue<Integer> trucks, bridge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        L = Integer.parseInt(st.nextToken()); // 다리 최대하중

        trucks = new LinkedList<>();
        bridge = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        while(n-- > 0) trucks.add(Integer.parseInt(st.nextToken()));
        while(w-- > 0) bridge.add(0);

        System.out.println(trucksMove());
    }

    static int trucksMove() {
        int time = 0, curWeight = 0;
        while(!bridge.isEmpty()) {
            time++;
            curWeight -= bridge.poll();
            if(!trucks.isEmpty()) {
                if(trucks.peek()+curWeight <= L) {
                    int weight = trucks.poll();
                    curWeight += weight;
                    bridge.add(weight);
                } else bridge.add(0);
            }
        }

        return time;
    }
}