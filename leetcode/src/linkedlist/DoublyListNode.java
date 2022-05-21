package linkedlist;

/**
 * @author XuBowen
 * @date 2021/8/14 20:36
 */
public class DoublyListNode {
	int val;
	ListNode front;
	ListNode next;

	public DoublyListNode() {

	}

	public DoublyListNode(int val) {
		this.val = val;
	}

	public DoublyListNode(int val, ListNode front, ListNode next) {
		this.val = val;
		this.front = front;
		this.next = next;
	}

	@Override
	public String toString() {
		return "DoublyListNode{" +
				"val=" + val +
				", front=" + front +
				", next=" + next +
				'}';
	}
}
