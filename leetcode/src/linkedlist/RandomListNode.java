package linkedlist;

/**
 * @author XuBowen
 * @date 2021/8/19 8:04
 */
public class RandomListNode implements Cloneable {
	int val;
	RandomListNode next;
	RandomListNode random;

	public RandomListNode(int val) {
		this.val = val;
	}

	public RandomListNode(int val, RandomListNode next, RandomListNode random) {
		this.val = val;
		this.next = next;
		this.random = random;
	}

	@Override
	public String toString() {
		return "RandomListNode{" +
				"val=" + val +
				", next=" + next +
				'}';
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
