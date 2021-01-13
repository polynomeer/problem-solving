package leetcode;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LC_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
            
        ListNode node = head;
        
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }
  

    public static void main(String[] args) {
        LC_83 LC83 = new LC_83();

        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(1);
        ListNode l1_3 = new ListNode(2);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(1);
        ListNode l2_3 = new ListNode(2);
        ListNode l2_4 = new ListNode(3);
        ListNode l2_5 = new ListNode(3);
        l2_1.next = l2_2;
        l2_2.next = l2_3;
        l2_3.next = l2_4;
        l2_4.next = l2_5;

        LC83.printList(l1_1);
        ListNode resultNode1 = LC83.deleteDuplicates(l1_1);
        LC83.printList(resultNode1);
        System.out.println();
        LC83.printList(l2_1);
        ListNode resultNode2 = LC83.deleteDuplicates(l2_1);
        LC83.printList(resultNode2);
    }

    public void printList(ListNode node) {
        System.out.print("[ ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println("]");
    }
}
