package topic;

/**
 * @author: ywx
 * @description 二叉树的最大深度
 * @Date: 2022/07/26
 */

public class Topic104 {
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

    int res = 0, depth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        depth++;
        if (root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        depth--;
    }

    /**
     * 分解问题
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth1(root.left);
        int rightMax = maxDepth1(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);

        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        node.left = node1;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        int i = new Topic104().maxDepth1(node);
        System.out.println(i);
    }
}
