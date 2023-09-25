class Solution {
    public char findTheDifference(String s, String t) {
        int ans = 0;
        
        for(int i=0; i<s.length(); i++){
            ans ^= s.charAt(i) - 'a';
        }
        
        for(int i=0; i<t.length(); i++){
            ans ^= t.charAt(i) - 'a';
        }
        
        return (char)(ans + 'a');
    }
}