import java.io.*;
import java.util.*;

class Title19637 {
    String name;
    int ceiling;

    public Title19637(String name, int ceiling) {
        this.name = name;
        this.ceiling = ceiling;
    }
}

public class BOJ19637 {
    static ArrayList<Title19637> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        list = new ArrayList<>();
        while(n-- > 0) {
            input = br.readLine().split(" ");
            list.add(new Title19637(input[0], Integer.parseInt(input[1])));
        }

        while(m-- > 0) {
            int toSearch = Integer.parseInt(br.readLine());
            sb.append(binarySearch(toSearch)).append('\n');
        }

        System.out.println(sb);
    }

    private static String binarySearch(int n) {
        int start = 0, end = list.size()-1, mid = 0;

        while(start <= end) {
            mid = (start+end) / 2;
            if(n > list.get(mid).ceiling) start = mid+1;
            else end = mid-1;
        }

        return list.get(end+1).name;
    }
}