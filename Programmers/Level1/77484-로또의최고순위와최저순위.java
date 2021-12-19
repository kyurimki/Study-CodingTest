import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeros = 0;
        int same = 0;
        
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) zeros++;
            else {
                for(int win_num : win_nums) {
                    if(lottos[i] == win_num) same++;
                }
            }
        }
        
        int score = 0;
        answer[0] = 6-same+1-zeros;
        if(same > 0) {
            answer[1] = 6-same+1;
        } else {
            if(zeros == 0) {
                answer[0] = 6;
            }
            answer[1] = 6;   
        }
        
// 가능한 경우의 수:
//         1. zeros > 0, same > 0: 6-same+1-zeros, 6-same+1
//         2. zeros > 0, same = 0: 6+1-zeros, 6
//         3. zeros = 0, same > 0: 6+1-same, 6+1-same
//         4. zeros = 0, same = 0: 6, 6
        
        return answer;
    }
}