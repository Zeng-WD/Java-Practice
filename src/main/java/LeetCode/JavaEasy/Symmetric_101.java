package LeetCode.JavaEasy;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeng-WD 406927572@qq.com
 * @date 2023/3/18 16:00
 * @Description 对称二叉树
 */
public class Symmetric_101 {

    static List<Integer> preList = new ArrayList<>();
    static List<Integer> subList = new ArrayList<>();

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 4, 1, null, 1, null, 4, 2, null, 2, null};
        TreeNode treeNode = TreeNode.arrayToTreeNode(arr);
        System.out.println(isSymmetric(treeNode));
        System.out.println(preList);
        System.out.println(subList);
    }

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * 示例 1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     * 提示：
     * 树中节点数目在范围 [1, 1000] 内
     * -100 <= Node.val <= 100
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        //调用递归函数，比较左节点，右节点
        return dfs(root.left, root.right);
    }

    static boolean dfs(TreeNode left, TreeNode right) {
        //递归的终止条件是两个节点都为空
        //或者两个节点中有一个为空
        //或者两个节点的值不相等
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        //再递归的比较 左节点的左孩子 和 右节点的右孩子
        //以及比较  左节点的右孩子 和 右节点的左孩子
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }


}
