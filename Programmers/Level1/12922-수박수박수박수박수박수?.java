class Solution {
    public String solution(int n) {
        String[] set = {"박", "수"};
        String answer = "";
        
        for(int i = 1; i <= n; i++) {
            answer += set[i%2];
        }
        return answer;
    }
}