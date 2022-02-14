import java.io.*;

public class BOJ12927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력값을 char[]로 받은 후 값이 Y일 때는 true, N일 때는 false로 저장
        // 문제 조건에서 스위치 범위가 1~N -> lights에 인덱스 1부터 저장
        char[] input = br.readLine().toCharArray();
        int n = input.length;
        boolean[] lights = new boolean[n+1];
        for(int i = 0; i < n; i++)
            if(input[i] == 'Y') lights[i+1] = true;
        
        // 켜진 전구일 때 그 인덱스와 배수의 저장값 반전
        int count = 0; // 스위치를 눌러야 하는 횟수 세기
        for(int i = 1; i <= n; i++) {
            if(lights[i]) {
                int j = i;
                while(j <= n) {
                    lights[j] = !lights[j];
                    j += i;
                }
                count++;
            }
        }

        // 모든 전구가 안 꺼졌을 때 return -1
        for(int i = 1; i <= n; i++) {
            if(lights[i]) {
                count = -1;
                break;
            }
        }
        System.out.println(count);
    }
}