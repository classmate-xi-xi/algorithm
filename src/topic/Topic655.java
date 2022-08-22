package topic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: ywx
 * @description 输出二叉树
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2的height+1次方 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2的height-r-1次方]
 * 右子节点放置在 res[r+1][c+2的height-r-1次方] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 ""
 * @Date: 2022/08/22
 */

public class Topic655 {
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

    class Solution {
        public List<List<String>> printTree(TreeNode root) {
            // 树高从0开始
            int h = depth(root) - 1;

            int m = h + 1;
            // 2的h+1次方 - 1列
            int n = (1 << (h + 1)) - 1;

            // 构造结果数组
            List<List<String>> ans = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<String> list = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    list.add("");
                }
                ans.add(list);
            }

            // BFS遍历每个节点
            bfs(ans, root, n, h);

            return ans;
        }

        private void bfs(List<List<String>> ans, TreeNode root, int n, int h) {
            Queue<MyNode> queue = new LinkedList<>();
            queue.offer(new MyNode(root, 0, (n - 1) >> 1));

            while (!queue.isEmpty()) {
                MyNode node = queue.poll();
                ans.get(node.r).set(node.c, String.valueOf(node.treeNode.val));

                if (node.treeNode.left != null) {
                    queue.offer(new MyNode(node.treeNode.left, node.r + 1, node.c - (1 << (h - node.r - 1))));
                }

                if (node.treeNode.right != null) {
                    queue.offer(new MyNode(node.treeNode.right, node.r + 1, node.c + (1 << (h - node.r - 1))));
                }
            }
        }

        private int depth(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int depth = 0;
            while (!queue.isEmpty()) {
                depth++;
                int size = queue.size();
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }

            return depth;
        }

        class MyNode {
            TreeNode treeNode;
            int r;
            int c;

            MyNode(TreeNode treeNode, int r, int c) {
                this.treeNode = treeNode;
                this.r = r;
                this.c = c;
            }
        }
    }
}
