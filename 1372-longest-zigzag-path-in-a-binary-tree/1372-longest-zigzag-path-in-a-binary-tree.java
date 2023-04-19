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
    int max = Integer.MIN_VALUE;
    public int longestZigZag(TreeNode root) {
        help(root, true, 0);
        help(root, false, 0);

        return max;
    }

    public void help(TreeNode root, boolean dir, int currCount){
        if(root == null) return;

        max = Math.max(currCount, max);
        if(dir){
            // dir is right, go left
            help(root.left, false, currCount+1);
            help(root.right, true, 0+1);
        } else{
            // dir is left, go right
            help(root.right, true, currCount+1);
            help(root.left, false, 0+1);
        }
    }
}







