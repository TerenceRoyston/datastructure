package linkedlist;

/**
 * @author XuBowen
 * @date 2021/8/8 10:49
 */
public class LC21_MergeTwoLists {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(6, null);
		ListNode node4 = new ListNode(3, node5);

		ListNode node3 = new ListNode(5, null);
		ListNode node2 = new ListNode(4, node3);
		ListNode node1 = new ListNode(1, node2);
		System.out.println(mergeTwoLists(node1, node4));
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		ListNode curr = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		curr.next = l1 == null ? l2 : l1;
		return dummy.next;
	}
}
