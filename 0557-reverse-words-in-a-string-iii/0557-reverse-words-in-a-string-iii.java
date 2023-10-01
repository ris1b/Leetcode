class Solution {
    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();

        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);

            if(c == ' '){
                while(!stack.isEmpty()){
                    sb.insert(sb.length(), stack.peek());
                    stack.pop();
                }
                sb.insert(sb.length(), c);
            } else {
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            sb.insert(sb.length(), stack.peek());
            stack.pop();
        }
        
        return sb.toString();

    }
}