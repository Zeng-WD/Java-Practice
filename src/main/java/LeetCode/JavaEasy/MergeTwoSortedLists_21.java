package LeetCode.JavaEasy;

import LeetCode.Tools.ListNode;

/**
 * @author Zeng-WD
 * @date 0:21 2020/12/19
 */
public class MergeTwoSortedLists_21 {

    private MergeTwoSortedLists_21() {
    }

    private static final class SingletonInstance {
        private static final MergeTwoSortedLists_21 INSTANCE = new MergeTwoSortedLists_21();
    }

    public static MergeTwoSortedLists_21 instance() {
        return SingletonInstance.INSTANCE;
    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

}
