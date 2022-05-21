package linkedlist;

/**
 * @author XuBowen
 * @date 2021/8/14 23:23
 * <p>
 * 给定两个有序链表，打印公共部分
 * 解析：两个指针比大小，谁小谁先走，两者相同时同时走，以此循环
 * 总结：凡是两个链表的问题，都是要构造两个指针，然后比大小。合并两个有序表也是这个思路
 */
public class RESC03_GetCommonNode {
	public static void main(String[] args) {
		ListNode node6 = new ListNode(5, null);
		ListNode node5 = new ListNode(4, node6);
		ListNode node4 = new ListNode(3, node5);

		ListNode node3 = new ListNode(5, null);
		ListNode node2 = new ListNode(4, node3);
		ListNode node1 = new ListNode(1, node2);

		getCommonNode(node1, node4);
	}

	public static void getCommonNode(ListNode headA, ListNode headB) {
		ListNode curr1 = headA;
		ListNode curr2 = headB;

		while (curr1 != null && curr2 != null) {
			if (curr1.val == curr2.val) {
				System.out.println(curr1.val);
				curr1 = curr1.next;
				curr2 = curr2.next;
			} else if (curr1.val < curr2.val) {
				curr1 = curr1.next;
			} else {
				curr2 = curr2.next;
			}
		}

	}
}
