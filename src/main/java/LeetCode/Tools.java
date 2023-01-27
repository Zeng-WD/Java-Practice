package LeetCode;

/**
 * @author Zeng-WD
 * @date 14:56 2021/1/10
 */
public class Tools {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            if (this.next != null) {
                return this.val + " " + this.next.toString();
            } else {
                return this.val + " ";
            }
        }
    }

}
