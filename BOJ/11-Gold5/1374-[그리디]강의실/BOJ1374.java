import java.io.*;
import java.util.*;

class Lecture1374 implements Comparable<Lecture1374> {
    int no, start, end;

    public Lecture1374(int no, int start, int end) {
        this.no = no;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lecture1374 o) {
        if(this.end == o.end)
            return this.start - o.start;
        return this.end - o.end;
    }
}

public class BOJ1374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Lecture1374[] table = new Lecture1374[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int no = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            table[i] = new Lecture1374(no, start, end);
        }
        Arrays.sort(table);
        for(Lecture1374 lec : table) System.out.println(lec.no);

        int count = 1;
        PriorityQueue<Lecture1374> pq = new PriorityQueue<>();
        pq.offer(table[0]);

        if(table.length != 1) {
            for(int i = 1; i < N; i++) {
                if(!pq.isEmpty()) {
                    Lecture1374 lec = pq.peek();
                    System.out.println(lec.no + " : " + lec.start + ", " + lec.end);
                    if(lec.end <= table[i].start) pq.poll();
                    else count++;
                    pq.offer(table[i]);
                }   
            }
        }
        System.out.println(count);
    }
}