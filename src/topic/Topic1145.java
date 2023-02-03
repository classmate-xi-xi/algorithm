package topic;

/**
 * @author: ywx
 * @description 二叉树着色游戏
 * 最开始时：
 *
 * 「一号」玩家从 [1, n]中取一个值x（1 <= x <= n）；
 * 「二号」玩家也从[1, n]中取一个值y（1 <= y <= n）且y != x。
 * 「一号」玩家给值为x的节点染上红色，而「二号」玩家给值为y的节点染上蓝色。
 *
 * 之后两位玩家轮流进行操作，「一号」玩家先手。每一回合，玩家选择一个被他染过色的节点
 * 将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色（「一号」玩家染红色，「二号」玩家染蓝色）。
 *
 * 如果（且仅在此种情况下）当前玩家无法找到这样的节点来染色时，其回合就会被跳过。
 *
 * 若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。
 *
 * 现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个y值可以确保你赢得这场游戏，则返回true,若无法获胜，就请返回 false 。
 * @Date: 2023/02/03
 */

public class Topic1145 {
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

    private int left;

    private int right;

    /**
     * 1、取胜的关键是取得一半以上的节点数量，总共有n个节点（n为奇数），考虑其一半m = n / 2.
     * 2、一个节点，如果取它的左（右）节点，则左（右）节点的所有节点都是你的。取父节点，则父节点以上的所有节点也都是你的。
     * 3、假设一号玩家选取了x节点，其左节点的节点总数为left，右节点的节点总数为right。
     * a. left > m 或者 right > m, 你只要选取大于一半的那个节点，必赢
     * b. left == m 或者 right == m, 无论选取哪个节点，其他另一边节点和父节点都是一号玩家的，一号玩家总数超过一半，必输
     * c. m <= left + right < n, 无论选取哪个节点，其他另一边节点和父节点都是一号玩家的，一号玩家总数超过一半，必输
     * d. left + right < m, 选取父节点，总数超过一半，必赢
     * @param root  [1,2,3,4,5,6,7,8,9,10,11]
     * @param n 11
     * @param x 3
     * @return true
     */
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, x);
        int half = n / 2;
        return left > half || right > half || (left + right) < half;
    }

    private int dfs(TreeNode node, int x) {
        int leftNum = 0;
        int rightNum = 0;
        if (node.left != null) {
            leftNum = dfs(node.left, x);
        }
        if (node.right != null) {
            rightNum = dfs(node.right, x);
        }
        if (node.val == x) {
            left = leftNum;
            right = rightNum;
        }
        return leftNum + rightNum + 1;
    }
}
