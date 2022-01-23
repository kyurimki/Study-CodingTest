import java.io.*;
import java.util.*;

public class BOJ17202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        ArrayList<Integer> count = new ArrayList<Integer>();
        for(int i = 0; i < A.length(); i++) {
            count.add(A.charAt(i)-'0');
            count.add(B.charAt(i)-'0');
        }

        while(true) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int i = 0; i < count.size()-1; i++)
                tmp.add((count.get(i) + count.get(i+1)) % 10);
            count = tmp;
            if(count.size() == 2) break;
        }
        System.out.println(count.get(0) + "" + count.get(1));
    }
}