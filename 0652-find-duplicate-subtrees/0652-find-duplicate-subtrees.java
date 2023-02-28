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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,Integer> map = new HashMap<>();
        List<TreeNode>op = new ArrayList<>();
        traverse(map,op,root);
        return op;
    }
    public String traverse(HashMap<String,Integer> map, List<TreeNode> list, TreeNode root){
        if(root == null){
            return "#";
        }
        String ans = root.val + "," + traverse(map, list, root.left) + "," + traverse(map, list,
                    root.right);
        map.put(ans, map.getOrDefault(ans,0)+1);
        if(map.get(ans) == 2){
            list.add(root);
        }
        return ans;
    }
}