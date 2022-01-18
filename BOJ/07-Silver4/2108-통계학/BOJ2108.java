import java.io.*;
import java.util.*;

public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        double sum = 0;
        int[] count = new int[8001];
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
            sum += x;
            count[x+4000]++;
        }

        Arrays.sort(arr);

        sb.append(Math.round(sum/n)).append('\n');
        sb.append(arr[n/2]).append('\n');
        
        int max = count[0];
        ArrayList<Integer> maxes = new ArrayList<Integer>();
        maxes.add(-4000);
        for(int i = 1; i < count.length; i++) {
            if(count[i] == max) maxes.add(i-4000);
            else if(count[i] > max) {
                max = count[i];
                maxes.clear();
                maxes.add(i-4000);
            }
        }

        if(maxes.size() > 1) sb.append(maxes.get(1)).append('\n');
        else sb.append(maxes.get(0)).append('\n');

        sb.append(arr[n-1]-arr[0]).append('\n');

        System.out.println(sb);
    }
}