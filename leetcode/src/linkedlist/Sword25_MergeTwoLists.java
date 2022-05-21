package linkedlist;

/**
 * @author XuBowen
 * @date 2021/8/5 23:18
 * <p>
 * 解析：合并两个递增的有序链表
 * 一开始思考是以其中一个链表为基准，将另一个链表里的每一个节点向基准链表里插入。
 * 但是这种方法有问题，首先需要判断一下头结点值得大小才能确定基准链表。其次，还要找到每个节点合适的插入位置，比较麻烦。
 * 此处的合适解法是构建一个新链表伪头节点，然后依次比较两个链表的头结点大小，将较小的插入到新节点的尾部，循环此过程。
 * 这种解法就解决了以上两个问题。
 * <p>
 * 知识点：
 * 1. node1 -> node2 -> node3 -> node4
 * node1.next=node3
 * node3=node4
 * 注意此时node1.next依然是node3,并没有变成node4
 */
public class Sword25_MergeTwoLists {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(6, null);
		ListNode node4 = new ListNode(3, node5);

		ListNode node3 = new ListNode(5, null);
		ListNode node2 = new ListNode(4, node3);
		ListNode node1 = new ListNode(1, node2);
		System.out.println(mergeTwoLists(node1, node4));

	}

	/**
	 * 自己的解法由于习惯于构造新的辅助指针，造成代码整体看起来较为臃肿，可以在原始指针上操作
	 */
/*	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		ListNode curr1 = l1;
		ListNode curr2 = l2;
		ListNode temp = dummy;
		while (curr1 != null && curr2 != null) {
			if (curr1.val <= curr2.val) {
				temp.next = curr1;
				temp = temp.next;
				curr1 = curr1.next;
			} else {
				temp.next = curr2;
				temp = temp.next;
				curr2 = curr2.next;
			}
		}
		if (curr2 == null) {
			temp.next = curr1;
		}
		if (curr1 == null) {
			temp.next = curr2;
		}
		return dummy.next;
	}*/

	/**
	 * 这种解法就使用原有的l1,l2指针，而没有重新构造指针，代码结构精简
	 * 同时注意结尾三元运算符的使用，以后可以多尝试。可显著减少代码量
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		ListNode curr = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		curr.next = l1 == null ? l2 : l1;
		return dummy.next;
	}
}
