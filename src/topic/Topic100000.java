package topic;

/**
 * @author: ywx
 * @description 如果把根节点看做第 1 层，打印出每一个节点所在的层数
 * @Date: 2022/07/26
 */

public class Topic100000 {
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

    void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // 前序位置
        System.out.println("节点" + root + "在第" + level + "层");
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        // 这样调用
        new Topic100000().traverse(root, 1);
    }

}
