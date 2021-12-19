import java.lang.*;

class Solution {
    public String solution(String s) {
        char ch[] = s.toCharArray();
        int count = 0;
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == ' ') {
                count = 0;
            } else {
                ch[i] = (count%2 == 0) ? Character.toUpperCase(ch[i]) : Character.toLowerCase(ch[i]);
                count++;
            } 
        }
        return new String(ch);
    }
}