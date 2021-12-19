class Solution {
    public long solution(long n) {
        long x = (long)Math.sqrt(n);
        
        if(n - x*x == 0) {
            return (x+1)*(x+1);
        }
    return -1;
    }
}