class Solution {
    public char findTheDifference(String s, String t) {
//         Set<Character> set = new HashSet<>();
        int ans = 0;
        
        for(int i=0; i<s.length(); i++){
            ans ^= s.charAt(i) - 'a';
        }
            // set.add(s.charAt(i));
        
        for(int i=0; i<t.length(); i++){
            ans ^= t.charAt(i) - 'a';
        }
        
//         char ans = t.charAt(0);
        
//         for(int i=0; i<t.length(); i++){
//             if(!set.contains(t.charAt(i))){
//                 return t.charAt(i);
//             }
//         }
        return (char)(ans + 'a');
    }
}