package topic;

/**
 * @author: ywx
 * @description 打印出每个节点的左右子树各有多少节点
 * @Date: 2022/07/26
 */

public class Topic100001 {
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

    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        // 后序位置
        System.out.println("节点" + root + "的左子树有" + leftCount + "个节点，右子树有" + rightCount + "个节点");
        return leftCount + rightCount + 1;
    }

}
