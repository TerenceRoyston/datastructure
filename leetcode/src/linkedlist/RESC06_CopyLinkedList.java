package linkedlist;

/**
 * @author XuBowen
 * @date 2021/8/19 22:28
 *
 * 如何复制一个单链表
 * ListNode类需要实现Clonable接口，重写clone方法，注意这里要是深拷贝
 * 单链表在定义next时具有递归特性，因此在复制时只需要复制头结点就可以实现整个链表的复制
 */
public class RESC06_CopyLinkedList {
	public static void main(String[] args) throws CloneNotSupportedException {
		ListNode node5 = new ListNode(5, null);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);
		ListNode newHead = copyLinkedList(node1);
		System.out.println(newHead);
		System.out.println(node1);
	}

	public static ListNode copyLinkedList(ListNode head) throws CloneNotSupportedException {
		ListNode newHead = (ListNode) head.clone();
		return newHead;
	}
}
