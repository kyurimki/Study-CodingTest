import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        ArrayList<String> added = new ArrayList<>();
        
        for(int i = 0; i < strings.length; i++) {
            added.add(strings[i].charAt(n) + strings[i]);
        }
        
        Collections.sort(added);
        
        for(int i = 0; i < strings.length; i++) {
            answer[i] = added.get(i).substring(1, added.get(i).length());
        }
        
        return answer;
    }
}