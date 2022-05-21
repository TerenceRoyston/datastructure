package linkedlist;

import java.util.HashSet;

/**
 * @author XuBowen
 * @date 2021/8/8 9:55
 * <p>
 * 移除重复节点，使用hashset作为一个是否存在判断，然后在原链表中做相应操作。而不是将遍历所有的节点存入hashset
 */
public class Interview0201_RemoveDuplicateNodes {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(1, null);
		ListNode node4 = new ListNode(2, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);
		System.out.println(removeDuplicateNodes(node1));
	}

	public static ListNode removeDuplicateNodes(ListNode head) {
		if (head == null) {
			return null;
		}
		HashSet<Integer> hashSet = new HashSet<>();
		hashSet.add(head.val);
		ListNode curr = head;
		while (curr.next != null) {
			if (hashSet.contains(curr.next.val)) {
				curr.next = curr.next.next;
			} else {
				hashSet.add(curr.next.val);
				curr = curr.next;
			}
		}
		//其实最后一个节点已经在循环中处理过了，所以跳出循环时什么都不用做直接返回头结点即可
		return head;
	}
}
