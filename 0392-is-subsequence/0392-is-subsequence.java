class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        int count = 0;
        
        for(int i=0; i<t.length() && j<s.length(); i++){
            char c1 = s.charAt(j);
            char c2 = t.charAt(i);
            
            if(c1 == c2) {
                count++;
                j++;
            }
        }
        
        return count == s.length();
    }
}