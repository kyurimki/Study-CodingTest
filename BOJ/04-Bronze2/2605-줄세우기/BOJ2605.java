import java.io.*;
import java.util.*;

public class BOJ2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> student = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(x == 0) student.add(i); // 0일 때는 원래 자리
            else student.add(i-x-1, i); // 이외라면 원래 자리에서 뽑은 수만큼 앞으로 이동
        }
        for(int s : student)
            sb.append(s + " ");
        System.out.println(sb);
    }
}