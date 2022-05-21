package linkedlist;

/**
 * 1->3->5   2->4->6
 * 将这两个链表合并
 */

public class RESC01_MergeLinkedlist {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(5, null);
		ListNode node3 = new ListNode(3, node5);
		ListNode node1 = new ListNode(1, node3);


		ListNode node6 = new ListNode(6, null);
		ListNode node4 = new ListNode(4, node6);
		ListNode node2 = new ListNode(2, node4);

		mergeLinkedlist(node1, node2);

		System.out.println(node1);

	}

	public static void mergeLinkedlist(ListNode head1, ListNode head2) {
		ListNode l1 = head1;
		ListNode l2 = head2;
		ListNode temp1;
		ListNode temp2;
		while (l1 != null && l2 != null) {
			temp1 = l1.next;
			temp2 = l2.next;
			l1.next = l2;
			l2.next = temp1;
			l2 = temp2;
			l1 = temp1;
		}
	}
}