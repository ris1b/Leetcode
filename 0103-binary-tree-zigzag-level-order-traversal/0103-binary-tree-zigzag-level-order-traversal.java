/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        Stack<TreeNode> ms = new Stack<>(); // mainStack
        Stack<TreeNode> cs = new Stack<>(); //childStack
        
        ms.push(root);
        boolean lr = true;
        
        while(!ms.isEmpty()){
            List<Integer> smallop = new ArrayList<>();
            int n = ms.size();
            while(n > 0){
                TreeNode t = ms.pop();
                smallop.add(t.val);
                int i = 0;
                int k = n;
                if(lr){
                    // Add Left to right in stack
                    //left
                    if(t.left != null)  cs.push(t.left);
                    //right
                    if(t.right != null)  cs.push(t.right);
                    // lr = false;
                }
                else{
                    // Add Right to Left in stack
                    // right
                    if(t.right != null)  cs.push(t.right);
                    // left
                    if(t.left != null)  cs.push(t.left);
                    // lr= true;
                }
                n--;
            }
            
            lr = !lr; 
            ans.add(smallop);
            
            // make mainStack point to childStack
            if(ms.isEmpty()){
                Stack<TreeNode> temp = cs;
                cs = ms;
                ms = temp;
            }
        }
        return ans;
    }
}






