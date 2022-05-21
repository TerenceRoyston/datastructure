package linkedlist;

/**
 * @author XuBowen
 * @date 2021/7/27 0:09
 *
 * 解析：
 * 删除节点的思路值得借鉴，要删除一个节点就把它变成与下一个节点完全相同，包括节点值和指向
 * 于是这个节点就取代了它的下一个节点。真正被删除掉的是下一个节点
 */
public class LC237_DeleteNode {
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
