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
    int ans = 0;
    
    public int sumNumbers(TreeNode root) {
        add(root, 0);
        return ans;
    }

    public void add(TreeNode root, int sum){
        int currSum = sum*10 + root.val;

        if(root == null) return;
        if(root.left == null && root.right == null){
            ans += sum*10 + root.val;
            return;
        }

        if(root.left != null) add(root.left, currSum);
        if(root.right != null) add(root.right, currSum);
    }
}










