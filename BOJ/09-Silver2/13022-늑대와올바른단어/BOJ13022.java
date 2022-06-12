import java.util.*;

public class BOJ13022 {
    static final int SIZE = 4;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(isCorrect(sc.nextLine()) ? 1 : 0);

        sc.close();
    }

    private static boolean isCorrect(String input) {
        if(input.charAt(0) != 'w' || input.length() % SIZE != 0) return false;

        char[] order = {'w', 'o', 'l', 'f'};
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < SIZE; i++)
            map.put(order[i], 0);

        int idx = 0;
        int pre = 0, cur = 0;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
                if(order[(idx+1)%SIZE] == c) {
                    idx++;
                    if(c == 'w') pre = 0;
                    else pre = cur;
                    cur = 1;
                } else if(order[idx%SIZE] == c) {
                    cur++;
                    if(c != 'w' && cur > pre) return false;
                } else return false;
            } else return false;
        }

        int count = map.get(order[0]);
        for(int i = 1; i < SIZE; i++)
            if(count != map.get(order[i])) return false;

        return true;
    }
}