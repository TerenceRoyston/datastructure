package linkedlist;

/**
 * @author XuBowen
 * @date 2021/8/1 19:10
 */
public class Interview0203_DeleteNode {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(5, null);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);

		deleteNode(node3);
		System.out.println(node2.next);
	}

	public static void deleteNode(ListNode node){
		node.val=node.next.val;
		node.next=node.next.next;
	}
}
