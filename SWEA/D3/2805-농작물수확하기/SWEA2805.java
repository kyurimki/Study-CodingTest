import java.io.*;

public class SWEA2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            for(int i = 0; i < n/2; i++) {
                char[] input = br.readLine().toCharArray();
                for(int j = (n/2-i); j <= (n/2+i); j++)
                    sum += input[j] - '0';
            }

            for(int i = n/2; i >= 0; i--) {
                char[] input = br.readLine().toCharArray();
                for(int j = (n/2-i); j <= (n/2+i); j++)
                    sum += input[j] - '0';
            }

            sb.append("#" + t + " " + sum + "\n");
        }
        System.out.print(sb);
    }
}