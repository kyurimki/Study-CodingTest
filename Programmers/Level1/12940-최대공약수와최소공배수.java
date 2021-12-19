class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        answer[0] = gcd(n, m);
        answer[1] = n * m / gcd(n, m);
        
        return answer;
    }
    
    public int gcd(int n, int m) {
        if(n % m == 0) {
            return m;
        } else {
            return gcd(m, n%m);
        }
    }
}