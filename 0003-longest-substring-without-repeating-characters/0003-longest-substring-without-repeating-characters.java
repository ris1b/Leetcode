class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int si=0;
        int n = s.length();
        // first make a window
        while(si < n && !set.contains(s.charAt(si))){
            set.add(s.charAt(si));
            si++;
        }

        int ei = si;
        si = 0;
        int len = set.size();
        while(ei < n){
            char incoming = s.charAt(ei);
            while(set.contains(incoming)){
                char out = s.charAt(si);
                set.remove(out);
                si++;
            }
            set.add(incoming);
            len = Math.max(len, set.size());
            ei++;
        }
        return len;
    }
}