import java.io.*;
import java.util.*;

class Temp implements Comparable<Temp> {
    int low, high;

    public Temp(int low, int high) {
        this.low = low;
        this.high = high;
    }

    @Override
    public int compareTo(Temp o) {
        return this.high-o.high;
    }
}

public class JO1828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        Temp[] temp = new Temp[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            temp[i] = new Temp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(temp);

        int count = 1;
        int max = temp[0].high;
        for(int i = 1; i < N; i++) {
            if(max < temp[i].low) {
                max = temp[i].high;
                count++;
            }
        }
        System.out.println(count);
    }
}