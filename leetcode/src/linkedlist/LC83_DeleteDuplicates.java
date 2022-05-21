package linkedlist;

/**
 * @author XuBowen
 * @date 2021/8/14 19:34
 *
 * 解析：这题还是比较容易的，用两个辅助指针，快指针逐个遍历，每当有和前面不一样的节点，就把慢指针指向它
 */
public class LC83_DeleteDuplicates {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(3, null);
		ListNode node4 = new ListNode(3, node5);
		ListNode node3 = new ListNode(2, node4);
		ListNode node2 = new ListNode(1, node3);
		ListNode node1 = new ListNode(1, node2);

		System.out.println(node1);
		System.out.println(deleteDuplicates(node1));
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode curr = head.next;
		ListNode temp = head;

		while (curr != null) {
			if (curr.val != temp.val) {
				temp.next = curr;
				temp = temp.next;
			}
			curr = curr.next;
		}
		if (temp.next != null) {
			temp.next = null;
		}
		return head;
	}
}
