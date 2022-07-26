package topic;

/**
 * @author: ywx
 * @description 二叉树的直径
 * @Date: 2022/07/26
 */

public class Topic543 {

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



    /**
     * 每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和
     *
     * @param root
     * @return
     */
    int maxDepth = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDepth;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int myDepth = leftMax + rightMax;
        maxDepth = Math.max(maxDepth, myDepth);
        return Math.max(leftMax, rightMax) + 1;
    }
}
