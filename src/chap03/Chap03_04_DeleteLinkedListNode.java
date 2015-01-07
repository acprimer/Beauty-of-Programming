package chap03;

/**
 * Created by yaodh on 2015/1/6.
 */
public class Chap03_04_DeleteLinkedListNode {
    class ListNode {
        int data;
        ListNode next;

        ListNode(int x) {
            data = x;
        }
    }

    void deleteNode(ListNode p) {
        if (p.next == null) {
            return;
        }
        p.data = p.next.data;
        p.next = p.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new Chap03_04_DeleteLinkedListNode().generate(new int[]{1, 2, 3, 4});
        ListNode p = head.next.next;
        new Chap03_04_DeleteLinkedListNode().deleteNode(p);
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    private ListNode generate(int[] numbers) {
        ListNode head = new ListNode(numbers[0]);
        ListNode p = head;
        for (int i = 1; i < numbers.length; i++) {
            ListNode node = new ListNode(numbers[i]);
            p = p.next = node;
        }
        return head;
    }
}
