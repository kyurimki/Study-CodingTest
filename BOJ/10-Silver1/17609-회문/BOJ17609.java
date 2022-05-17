import java.io.*;

public class BOJ17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            char[] input = br.readLine().toCharArray();
            if(check(input, 0, input.length-1))
                sb.append('0');
            else {
                if(checkPseudo(input, 0, input.length-1))
                    sb.append('1');
                else
                    sb.append('2');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static boolean check(char[] input, int start, int end) {
        while(start <= end) {
            if(input[start] != input[end])
                return false;
            start++;
            end--;
        }
        return true;
    }

    private static boolean checkPseudo(char[] input, int start, int end) {
        while(start <= end) {
            if(input[start] != input[end]) {
                boolean flag1 = check(input, start+1, end);
                boolean flag2 = check(input, start, end-1);

                if(!flag1 && !flag2)
                    return false;
                else
                    return true;
            }
            start++;
            end--;
        }
        return true;
    }
}