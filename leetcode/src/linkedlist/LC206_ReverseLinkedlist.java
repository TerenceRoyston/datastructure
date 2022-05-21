package linkedlist;

/**
 * @author XuBowen
 * @date 2021/7/28 21:52
 *
 * 解析：
 * 反转链表，必会！
 * 要搞明白变量名，对象，引用之间的关系。head与curr其实只是一个名字，都指向了内存中的一块区域
 */
public class LC206_ReverseLinkedlist {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(5, null);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);

		reverseLinkedList(node1);

		System.out.println(node3);

	}

	public static void reverseLinkedList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode temp;

		while (curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
	}
}
