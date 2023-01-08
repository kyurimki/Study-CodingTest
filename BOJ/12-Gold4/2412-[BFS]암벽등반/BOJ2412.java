import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ2412 {
    static int SIZE = 200001;
    static int n, T;
    static ArrayList<Integer>[] furrow;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        furrow = new ArrayList[SIZE];
        for(int i = 0; i < SIZE; i++)
            furrow[i] = new ArrayList<>();
            
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            furrow[y].add(x);
        }
        for(int i = 0; i < SIZE; i++)
            Collections.sort(furrow[i]);

        System.out.println(climb());
    }

    private static int climb() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        int move = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Point p = q.poll();
                if(p.y == T) return move;

                for(int y = p.y-2; y <= p.y+2; y++) {
                    if(y < 0 || y >= SIZE) continue;
                    for(int j = 0; j < furrow[y].size(); j++) {
                        int x = furrow[y].get(j);
                        if(x - p.x > 2) break;
                        else if(p.x - x < 2) continue;

                        q.add(new Point(x, y));
                        furrow[y].remove(j);
                        j--;
                    }
                }
            }
            move++;
        }
        System.out.println(move);
        return -1;
    }
}