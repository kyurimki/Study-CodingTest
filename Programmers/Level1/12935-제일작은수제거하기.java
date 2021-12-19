import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length <= 1) {
            int[] answer = {-1};
            return answer;
        } else {
            int min = 0;
            int length = arr.length;
            int[] answer = new int[length-1];
            for(int i = 1; i < length; i++) {
                if(arr[min] > arr[i]) {
                    min = i;
                }
            }
            int idx = 0;
            for(int i = 0; i < length; i++) {
                if(i != min) {
                    answer[idx++] = arr[i];
                }
            }
            return answer;
        }
    }
}