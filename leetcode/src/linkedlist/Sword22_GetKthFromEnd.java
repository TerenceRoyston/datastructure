package linkedlist;

/**
 * @author XuBowen
 * @date 2021/8/1 19:35
 * 解析：
 * 取链表倒数第k个节点
 * 快慢指针，快指针先走k步，然后快慢指针同时走
 */
public class Sword22_GetKthFromEnd {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(5, null);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);

		System.out.println(getKthFromEnd(node1, 4));
	}

	// 快慢指针 不解释了。但是没有双100%  继续优化。思路是把第一个循环取消，在第二个中进行判断
/*	public static ListNode getKthFromEnd(ListNode head, int k) {
		ListNode fast = head;
		ListNode slow = head;

		while (k != 0) {
			fast = fast.next;
			k--;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;
	}*/

	public static ListNode getKthFromEnd(ListNode head, int k) {
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
		return slow;
	}

}
