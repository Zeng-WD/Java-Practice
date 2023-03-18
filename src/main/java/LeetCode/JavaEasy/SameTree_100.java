package LeetCode.JavaEasy;

import struct.TreeNode;

/**
 * @author Zeng-WD 406927572@qq.com
 * @date 2023/3/18 15:05
 * @Description 相同的树
 */
public class SameTree_100 {

    static boolean same = true;

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, null, new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(3), null);
        System.out.println(isSameTree(p, q));
    }


    /**
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * 示例 1：
     * 输入：p = [1,2,3], q = [1,2,3]
     * 输出：true
     * 示例 2：
     * 输入：p = [1,2], q = [1,null,2]
     * 输出：false
     * 示例 3：
     * 输入：p = [1,2,1], q = [1,1,2]
     * 输出：false
     * 提示：
     * 两棵树上的节点数目都在范围 [0, 100] 内
     * -104 <= Node.val <= 104
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        isSame(p, q);
        return same;
    }

    public boolean sameTree(TreeNode root1, TreeNode root2) {
        // 都为空的话，显然相同
        if (root1 == null && root2 == null) return true;
        // 一个为空，一个非空，显然不同
        if (root1 == null || root2 == null) return false;
        // 两个都非空，但 val 不一样也不行
        if (root1.val != root2.val) return false;

        // root1 和 root2 该比的都比完了
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }


    public static void isSame(TreeNode p, TreeNode q) {
        if (same) {
            if (p == null && q == null) {
                return;
            }
            if (p == null || q == null) {
                same = false;
                return;
            }
            if (p.val == q.val) {
                isSame(p.left, q.left);
                isSame(p.right, q.right);
            } else {
                same = false;
            }
        }
    }

}
