import java.io.*;
import java.util.*;

public class BOJ1092 {
    static int N, M;
    static ArrayList<Integer> crane, box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        crane = new ArrayList<>();
        String[] string = br.readLine().split(" ");
        for(String s : string) crane.add(Integer.parseInt(s));
        crane.sort(Comparator.reverseOrder());

        M = Integer.parseInt(br.readLine());
        box = new ArrayList<>();
        string = br.readLine().split(" ");
        for(String s : string) box.add(Integer.parseInt(s));
        box.sort(Comparator.reverseOrder());

        if(box.get(0) > crane.get(0)) bw.write(String.valueOf(-1));
        else {
            int time = 0;
            while(!box.isEmpty()) {
                time++;
                int idx = 0;
                for(int i = 0; i < N;) {
                    if(idx == box.size()) break;
                    if(crane.get(i) >= box.get(idx)) {
                        box.remove(idx);
                        i++;
                    } else
                        idx++;
                }
            }
            bw.write(String.valueOf(time));
        }   
        bw.flush();
        bw.close();
    }
}