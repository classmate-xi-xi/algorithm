package topic;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: ywx
 * @description 二叉树最大宽度
 * @Date: 2022/08/27
 */

public class Topic662 {
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

    public int widthOfBinaryTree(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(new TreeNode(1, root.left, root.right));
        while (!queue.isEmpty()) {
            int count = queue.size();
            int leftCode = 0;
            int rightCode = 0;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                rightCode = node.val;
                if (leftCode == 0) {
                    leftCode = node.val;
                }
                // 对每个节点下的左右节点的左右子节点进行编号
                if (node.left != null) {
                    queue.offer(new TreeNode(node.val * 2, node.left.left, node.left.right));
                }
                if (node.right != null) {
                    queue.offer(new TreeNode(node.val * 2 + 1, node.right.left, node.right.right));
                }
            }
            result = Math.max(result, rightCode - leftCode);
        }
        return result + 1;
    }
}
