package topic;

/**
 * @author: ywx
 * @description 计算布尔二叉树的值
 * 给你一棵 完整二叉树的根，这棵树有以下特征：
 *
 * 叶子节点要么值为0要么值为1，其中0 表示False，1 表示True。
 * 非叶子节点 要么值为 2要么值为 3，其中2表示逻辑或OR ，3表示逻辑与AND。
 * 计算一个节点的值方式如下：
 *
 * 如果节点是个叶子节点，那么节点的 值为它本身，即True或者False。
 * 否则，计算两个孩子的节点值，然后将该节点的运算符对两个孩子值进行 运算。
 * 返回根节点root的布尔运算值。
 *
 * 完整二叉树是每个节点有 0个或者 2个孩子的二叉树。
 *
 * 叶子节点是没有孩子的节点。
 * @Date: 2023/02/06
 */

public class Topic2331 {
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

    /**
     *
     * @param root [2,1,3,null,null,0,1]
     * @return true
     */
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null) {
            return root.val == 1;
        }
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}
