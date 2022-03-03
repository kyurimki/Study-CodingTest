import java.io.*;
import java.util.*;

class Data {
    char[] num;
    int S;
    int B;

    public Data(char[] num, int S, int B) {
        this.num = num;
        this.S = S; // 스트라이크
        this.B = B; // 볼
    }
}

public class BOJ2503 {
    static ArrayList<Data> dataList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        dataList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            dataList.add(new Data(Integer.toString(num).toCharArray(), strike, ball));
        }
        System.out.println(baseball());
    }

    private static int baseball() {
        ArrayList<char[]> possible = new ArrayList<>(); // 가능한 수
        for(int i = 123; i <= 987; i++) {
            char[] c = Integer.toString(i).toCharArray();
            if(c[1] == '0' || c[2] == '0') continue; // 1~9까지 수
            if(c[0] == c[1] || c[1] == c[2] || c[2] == c[0]) continue; // 모든 자리 수는 달라야 함
            possible.add(c);
        }

        for(Data d : dataList) {
            ArrayList<char[]> tmp = new ArrayList<>();
            for(char[] c : possible) {
                int sCnt = isStrike(d, c); // 스트라이크 횟수
                int bCnt = isBall(d, c); // 볼 횟수

                if(d.S == sCnt && d.B == bCnt) tmp.add(c);
            }
            possible = tmp;
        }
        return possible.size();
    }

    private static int isStrike(Data d, char[] c) {
        int count = 0;
        for(int i = 0; i < 3; i++)
            if(d.num[i] == c[i]) count++;
        return count;
    }

    private static int isBall(Data d, char[] c) {
        int count = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == j) continue;
                if(d.num[i] == c[j]) count++;
            }
        }
        return count;
    }
}