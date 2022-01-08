import java.util.*;

class Solution {
    static boolean visited[];
    static ArrayList<String> routes;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        routes = new ArrayList<String>();
        
        int count = 0;
        dfs(count, "ICN", "ICN", tickets);
        Collections.sort(routes);
        
        String[] answer = routes.get(0).split(" ");
        return answer;
    }
    
    public void dfs(int count, String cur, String route, String[][] tickets) {
        if(count == tickets.length) {
            routes.add(route);
            return ;
        }
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                dfs(count+1, tickets[i][1], route+" "+tickets[i][1], tickets);
                visited[i] = false;
            }
        }
        return ;
    }
}