import java.util.*;

class NumInfo {
    String str;
    int num;

    public NumInfo(String str, int num) {
        this.str = str;
        this.num = num;
    }    
}

public class BOJ1755 {
    public static void main(String[] args) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int M = sc.nextInt();
        int N = sc.nextInt();

        ArrayList<NumInfo> list = new ArrayList<>();
        for(int i = M; i <= N; i++) {
            char[] tochar = String.valueOf(i).toCharArray();

            String str = "";
            for(int j = 0; j < tochar.length; j++)
                str += nums[tochar[j]-'0'] + " ";
            
            list.add(new NumInfo(str, i));
        }

        Collections.sort(list, new Comparator<NumInfo>() {
            @Override
            public int compare(NumInfo o1, NumInfo o2) {
                return o1.str.compareTo(o2.str);
            }
        });

        int cnt = 0;
        for(NumInfo n : list) {
            sb.append(n.num);
            cnt++;
            if(cnt % 10 == 0) sb.append('\n');
            else sb.append(' ');
        }
        System.out.println(sb);

        sc.close();
    }
}