class Solution {
    public boolean isPrime(int num) {
        for(int x = 2; x*x <= num; x++) {
            if(num % x == 0) return false;
        }
        return true;
    }
    
    public int solution(int[] nums) {
        int answer = 0;

        int size = nums.length;
        int sum;
        for(int i = 0; i < size-2; i++) {
            for(int j = i+1; j < size-1; j++) {
                for(int k = j+1; k < size; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum)) answer++;
                }
            }
        }
        return answer;
    }
}