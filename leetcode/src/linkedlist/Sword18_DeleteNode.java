package linkedlist;

/**
 * 此题为重复题，不再多说
 */
public class Sword18_DeleteNode {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(3, null);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);

		System.out.println(deleteNode(node1, 3));
	}

	public static ListNode deleteNode(ListNode head, int val){
		ListNode dummy = new ListNode();
		ListNode temp = dummy;
		temp.next = head;
		while (temp.next != null) {
			if (temp.next.val == val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		return dummy.next;
	}
}