package linkedlist;

/**
 * @author XuBowen
 * @date 2021/8/2 21:28
 */
public class Sword24_ReverseList {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(5, null);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);

		System.out.println(reverseList(node1));
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev=null;
		ListNode curr =head;
		ListNode temp;

		while (curr!=null){
			temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
		}
		return prev;
	}
}
