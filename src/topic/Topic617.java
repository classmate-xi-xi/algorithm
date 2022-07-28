package topic;

/**
 * @author: ywx
 * @description 合并二叉树
 * @Date: 2022/07/28
 */

public class Topic617 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode newRoot = new TreeNode();
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        newRoot = new TreeNode(root1.val + root2.val);
        newRoot.left = mergeTrees(root1.left, root2.left);
        newRoot.right = mergeTrees(root1.right, root2.right);
        return newRoot;
    }
}
