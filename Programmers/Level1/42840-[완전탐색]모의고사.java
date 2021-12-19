import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[] set1 = {1, 2, 3, 4, 5};
        int[] set2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] set3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] correct = {0, 0, 0};
        
        for(int i = 0; i < answers.length; i++) {
            if(set1[i%set1.length] == answers[i]) {
                correct[0]++;
            }
            if(set2[i%set2.length] == answers[i]) {
                correct[1]++;
            }
            if(set3[i%set3.length] == answers[i]) {
                correct[2]++;
            }
        }
        
        int max = Math.max(Math.max(correct[0], correct[1]), correct[2]);
        for(int i = 0; i < 3; i++) {
            if(correct[i] == max) {
                answer.add(i+1);
            }
        }
        
        return answer;
    }
}