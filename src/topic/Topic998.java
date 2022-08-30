package topic;

/**
 * @author: ywx
 * @description 最大二叉树 II
 * @Date: 2022/08/30
 */

public class Topic998 {
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
     * 由于val是加在最后一个位置，因此他只能插入右子树或者变为根节点。
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        //若val > root.val，则该节点是根节点，其左节点为之前的根节点
        if (root.val < val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        //遍历右边节点
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
