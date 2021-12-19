class Solution {
    public boolean solution(String s) {
        int length = s.length();
        if(length != 4 && length != 6) {
            return false;
        } else {
            try {
                int x = Integer.parseInt(s);
                return true;
            } catch(NumberFormatException e) {
                return false;
            }
        }
    }
}