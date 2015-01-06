package chap03;

/**
 * Created by yaodh on 2015/1/6.
 */
public class Chap03_04_DeleteLinkedListNode {
    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
        }
    }

    void deleteNode(Node p) {
        if (p.next == null) {
            return;
        }
        p.data = p.next.data;
        p.next = p.next.next;
    }

    public static void main(String[] args) {
        Node head = new Chap03_04_DeleteLinkedListNode().generate(new int[]{1, 2, 3, 4});
        Node p = head.next.next;
        new Chap03_04_DeleteLinkedListNode().deleteNode(p);
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    private Node generate(int[] numbers) {
        Node head = new Node(numbers[0]);
        Node p = head;
        for (int i = 1; i < numbers.length; i++) {
            Node node = new Node(numbers[i]);
            p = p.next = node;
        }
        return head;
    }
}
