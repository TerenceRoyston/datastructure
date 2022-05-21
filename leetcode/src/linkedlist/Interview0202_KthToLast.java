package linkedlist;

/**
 * @author XuBowen
 * @date 2021/8/1 19:53
 */
public class Interview0202_KthToLast {
	public static void main(String[] args) {

	}

	public static int kthToLast(ListNode head, int k) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null) {
			if (k != 0) {
				fast = fast.next;
				k--;
				continue;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return slow.val;
	}
}
