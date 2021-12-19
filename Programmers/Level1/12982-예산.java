import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int count = 0;
        int sum = 0;
        for(int i = 0; i < d.length; i++) {
            if(sum + d[i] <= budget) {
                count++;
                sum += d[i];
            } else {
                break;
            }
        }
        
        return count;
    }
}