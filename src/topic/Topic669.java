package topic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ywx
 * @description 修剪二叉搜索树
 * @Date: 2022/09/10
 */

public class Topic669 {
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

    public TreeNode trimBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    private TreeNode dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return dfs(root.right, low, high);
        }
        if (root.val > high) {
            return dfs(root.left, low, high);
        }
        root.left = dfs(root.left, low, high);
        root.right = dfs(root.right, low, high);
        return root;
    }
}
