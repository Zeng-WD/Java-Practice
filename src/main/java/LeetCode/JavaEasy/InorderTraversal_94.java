package LeetCode.JavaEasy;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zeng-WD 406927572@qq.com
 * @date 2023/3/12 23:41
 * @Description 二叉树的中序遍历
 */
public class InorderTraversal_94 {

    static TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));

    public static void main(String[] args) {
        System.out.println(inorderTraversal(treeNode));
    }

    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     * 示例 1：
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     * 输入：root = [1]
     * 输出：[1]
     * 提示：
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traver(result, root);
        return result;
    }

    public static void traver(List<Integer> list, TreeNode root) {
        if (root == null) return;
        traver(list, root.left);
        list.add(root.val);
        traver(list, root.right);
    }

    public static void iterate(List<Integer> list, TreeNode root) {
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            list.add(root.val);
            root = root.right;
        }
    }

}
