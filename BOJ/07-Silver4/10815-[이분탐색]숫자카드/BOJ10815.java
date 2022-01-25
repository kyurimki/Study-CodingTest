import java.io.*;
import java.util.*;

public class BOJ10815 {
    static int n;
    static int[] cards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        cards = new int[n];
        st  = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) cards[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        st  = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int toFind = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(toFind)).append(' ');
        }
        System.out.println(sb);
    }

    public static int binarySearch(int toFind) {
        int start = 0;
        int end = n-1;
        int mid;

        while(start <= end) {
            mid = (start + end) / 2;

            if(cards[mid] == toFind) return 1;
            if(cards[mid] < toFind) start = mid+1;
            else end = mid-1;
        }
        return 0;
    }
}