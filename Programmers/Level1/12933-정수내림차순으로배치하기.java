import java.util.*;

class Solution {
    public long solution(long n) {
        ArrayList<Integer> set = new ArrayList<>();
        while(n != 0) {
            set.add((int)(n%10));
            n /= 10;
        }
        
        Collections.sort(set, Collections.reverseOrder());
        
        long answer = 0;
        int size = set.size();
        for(int i = 0; i < size; i++) {
            answer += set.get(i) * Math.pow(10, size-1-i);
        }
        
        return answer;
    }
}