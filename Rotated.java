class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Rotated {

    public ListNode rotateLeft(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;

        if (k == 0) {
            return head;
        }

        ListNode newTail = head;
        for (int i = 1; i < k; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Rotated solution = new Rotated();

        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.next = new ListNode(60);

        System.out.println("Original:");
        solution.printList(head);

        ListNode rotatedLeft = solution.rotateLeft(head, 4);
        System.out.println("Rotation:");
        solution.printList(rotatedLeft);
    }
}
