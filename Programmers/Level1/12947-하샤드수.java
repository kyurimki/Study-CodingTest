class Solution {
    public boolean solution(int x) {
        if(x % sum(x) == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int sum(int x) {
        int sum = 0;
        while(x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}