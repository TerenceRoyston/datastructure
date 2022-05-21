package linkedlist;

/**
 * @author XuBowen
 * @date 2021/8/8 15:07
 */
public class Sword52_GetIntersectionNode {
	public static void main(String[] args) {
		ListNode node7 = new ListNode(7, null);
		ListNode node5 = new ListNode(5, node7);
		ListNode node3 = new ListNode(3, node5);
		ListNode node1 = new ListNode(1, node3);

		//ListNode node8 = new ListNode(8, null);
		//ListNode node6 = new ListNode(6, node8);
		ListNode node4 = new ListNode(4, node5);
		ListNode node2 = new ListNode(2, node4);

		System.out.println(getIntersectionNode(node1, node2));
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode curr1=headA;
		ListNode curr2=headB;
		while (curr1!=curr2){
			curr1=curr1==null?headB:curr1.next;
			curr2=curr2==null?headA:curr2.next;
		}
		return curr1;
	}
}
