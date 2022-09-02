package topic;

/**
 * @author: ywx
 * @description 最长同值路径
 * @Date: 2022/09/02
 */

public class Topic687 {
    public class TreeNode {
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

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLen = 0;
        int rightLen = 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.left != null && root.left.val == root.val) {
            leftLen = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightLen = right + 1;
        }
        max = Math.max(max, leftLen + rightLen);
        return Math.max(leftLen, rightLen);
    }


}
