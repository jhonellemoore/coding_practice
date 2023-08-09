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

 /* in-order traversal of the tree
 left, itself and right
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // build list as you're going through the tree
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list.get(k-1);
    }

    public void helper(TreeNode root, List<Integer> list){
        // check left
        // check curr
        // check right

        if (root.left != null){
            helper(root.left, list);
        }
        list.add(root.val);
        if (root.right != null){
            helper(root.right, list);
        }
    }


}
