package LeetCode.JavaNormal;

import LeetCode.Tools.ListNode;

/**
 * @author Zeng-WD
 * @date 14:30 2021/1/10
 */
public class AddTwoNumbers_2 {

    public static void main(String[] args) {
        ListNode node_1c = new ListNode(3, null);
        ListNode node_1b = new ListNode(4, node_1c);
        ListNode node_1a = new ListNode(2, node_1b);
        ListNode node_2c = new ListNode(4, null);
        ListNode node_2b = new ListNode(6, node_2c);
        ListNode node_2a = new ListNode(5, node_2b);

        ListNode listNode = getInstance().addTwoNumbers(node_1a, node_2a);
        System.out.println(listNode);
    }

    private AddTwoNumbers_2() {
    }

    private static class SingletonInstance {
        private static final AddTwoNumbers_2 INSTANCE = new AddTwoNumbers_2();
    }

    public static AddTwoNumbers_2 getInstance() {
        return SingletonInstance.INSTANCE;
    }

    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     * <p>
     * 示例 1：
     * <p>
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     * <p>
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     * <p>
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     *
     * <p>
     * 提示：
     * <p>
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode res = new ListNode();
        add(l1, l2, res);
        return res;
    }

    public void add(ListNode l1, ListNode l2, ListNode cur) {
        int l1Val = l1 == null ? 0 : l1.val;
        int l2Val = l2 == null ? 0 : l2.val;
        cur.val = l1Val + l2Val + cur.val;
        boolean b = false;
        if (cur.val >= 10) {
            cur.val -= 10;
            cur.next = new ListNode(1);
            b = true;
        }
        l1 = l1 == null ? null : l1.next;
        l2 = l2 == null ? null : l2.next;
        if (l1 == null && l2 == null) {
            return;
        }
        if (!b) {
            cur.next = new ListNode(0);
        }
        cur = cur.next;
        add(l1, l2, cur);
    }

}
