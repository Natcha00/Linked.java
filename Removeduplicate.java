class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Removeduplicate {

    public static ListNode removeDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(12);
        head.next = new ListNode(12);
        head.next.next = new ListNode(21);
        head.next.next.next = new ListNode(41);
        head.next.next.next.next = new ListNode(43);

        System.out.println("Original:");
        printList(head);

        ListNode result = removeDuplicates(head);

        System.out.println("Removing Duplicates:");
        printList(result);
    }
}
