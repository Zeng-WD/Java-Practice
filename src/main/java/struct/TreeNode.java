package struct;

import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zeng-WD 406927572@qq.com
 * @date 2023/3/12 23:45
 * @Description 二叉树
 * 二叉搜索树：也称二叉查找树，或二叉排序树。定义也比较简单，要么是一颗空树，要么就是具有如下性质的二叉树：
 * （1）若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * （2）若任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * （3）任意节点的左、右子树也分别为二叉查找树；
 * （4）没有键值相等的节点。
 * 平衡二叉树：在二叉搜索树的基础上多了两个重要的特点：
 * （1）左右两子树的高度差的绝对值不能超过 1；
 * （2）左右两子树也是一颗平衡二叉树。
 */
@NoArgsConstructor
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode arrayToTreeNode(Integer[] array) {
        if (array.length == 0 || array[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (node != null) {
                if (isLeft) {
                    if (array[i] != null) {
                        node.left = new TreeNode(array[i]);
                        queue.offer(node.left);
                    }
                    isLeft = false;
                } else {
                    if (array[i] != null) {
                        node.right = new TreeNode(array[i]);
                        queue.offer(node.right);
                    }
                    queue.poll();
                    isLeft = true;
                }
            }
        }
        return root;
    }

    /**
     * 判断一棵树是不是二叉搜索树（Binary Search Tree）
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    /**
     * 在 BST 中查找一个数是否存在
     */
    public boolean isInBST(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;

        return isInBST(root.left, target) || isInBST(root.right, target);
        /*  优化，类似二分查找
            if (root == null) return false;
            if (root.val == target)
                return true;
            if (root.val < target)
                return isInBST(root.right, target);
            if (root.val > target)
                return isInBST(root.left, target);
        */
    }

    /**
     * 在 BST 中插入一个数
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null) return new TreeNode(val);
        // if (root.val == val)
        //     BST 中一般不会插入已存在元素
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }

    /**
     * 在 BST 中删除一个数
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            // 情况 1：A 恰好是末端节点，两个子节点都为空，那么它可以当场去世了。
            // 情况 2：A 只有一个非空子节点，那么它要让这个孩子接替自己的位置。
            // 这两个 if 把情况 1 和 2 都正确处理了
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 情况 3：A 有两个子节点，为了不破坏 BST 的性质，A 必须找到左子树中最大的那个节点，或者右子树中最小的那个节点来接替自己。
            TreeNode minNode = getMin(root.right);
            // 般不会通过 root.val = minNode.val 修改节点内部的值来交换节点，而是通过一系列略微复杂的链表操作交换 root 和 minNode 两个节点。
            // 因为具体应用中，val 域可能会很大，修改起来很耗时，而链表操作无非改一改指针，而不会去碰内部数据。
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    TreeNode getMin(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.left != null) node = node.left;
        return node;
    }


}
