package struct;

import LeetCode.Tools;

/**
 * @author Zeng-WD 406927572@qq.com
 * @date 2023/3/10 19:00
 */
public class ListNode {
    public int val;
    public Tools.ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, Tools.ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        if (this.next != null) {
            return this.val + " " + this.next;
        } else {
            return this.val + " ";
        }
    }
}
