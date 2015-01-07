package chap03;

/**
 * Created by yaodh on 2015/1/7.
 */
public class Chap03_06_LinkedListIntersection {
    class ListNode {
        int data;
        ListNode next;

        ListNode(int x) {
            data = x;
        }
    }

    boolean isIntersection(ListNode headA, ListNode headB) {
        ListNode lastA = headA;
        ListNode lastB = headB;
        while (headA != null) {
            lastA = headA;
            headA = headA.next;
        }
        while (headB != null) {
            lastB = headB;
            headB = headB.next;
        }
        return lastA == lastB;
    }

    boolean isIntersection_2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return false;
        }
        while (headA.next != null) {
            headA = headA.next;
        }
        while (headB.next != null) {
            headB = headB.next;
        }
        return headA == headB;
    }

    ListNode findIntersection(ListNode headA, ListNode headB) {
        int lenA = lengthOfLinkedList(headA);
        int lenB = lengthOfLinkedList(headB);
        while (lenA >= 0) {
            if (headA == headB) {
                return headA;
            }
            int diff = lenA - lenB;
            if (diff >= 0) {
                lenA--;
                headA = headA.next;
            }
            if (diff <= 0) {
                lenB--;
                headB = headB.next;
            }
        }
        return null;
    }

    int lengthOfLinkedList(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
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

    public static void main(String[] args) {
        ListNode L1 = new Chap03_06_LinkedListIntersection().generate(new int[]{1, 2, 3});
        ListNode L2 = new Chap03_06_LinkedListIntersection().generate(new int[]{9, 4, 5});
        L1.next.next = L2.next;
        boolean ans = new Chap03_06_LinkedListIntersection().isIntersection_2(L1, L2);
        System.out.println(ans);
        ListNode inter = new Chap03_06_LinkedListIntersection().findIntersection(L1, L2);
        System.out.println(inter.data);
    }
}
