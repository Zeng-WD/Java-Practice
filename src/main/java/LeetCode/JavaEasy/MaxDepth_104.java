package LeetCode.JavaEasy;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zeng-WD 406927572@qq.com
 * @date 2023/3/26 16:54
 * @Description 二叉树的最大深度
 */
public class MaxDepth_104 {

    static int depth = 0;

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode node = TreeNode.arrayToTreeNode(arr);
        System.out.println(maxDepth(node));
    }

    /**
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     */
    public static int maxDepth(TreeNode root) {
        // 深度优先
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // 广度优先
    public int maxDepthBreadthFirst(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node != null && node.left != null) {
                    queue.offer(node.left);
                }
                if (node != null && node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

}
