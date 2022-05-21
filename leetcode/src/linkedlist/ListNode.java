package linkedlist;

/**
 * @author XuBowen
 * @date 2021/7/27 0:07
 */
public class ListNode implements Cloneable{
	int val;
	ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode{" +
				"val=" + val +
				", next=" + next +
				'}';
	}

	// 深拷贝
	@Override
	protected Object clone() throws CloneNotSupportedException {
		ListNode l = (ListNode) super.clone();
		if (l.next==null){
			return super.clone();
		}
		ListNode ln = (ListNode) l.next.clone();
		l.next=ln;
		return l;
	}
}
