package linkedlist;

/**
 * 解析：此题我们是构造虚拟节点
 * 但是链表中有很重要的解题思想就是递归与迭代，我们借这一道题来学习这两种解题方法
 */

public class LC203_RemoveElements {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(3, null);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);

		System.out.println(removeElements(node1, 3));
	}

/*    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val != val) {
                temp.next = curr;
                temp = temp.next;
            }
            curr = curr.next;
        }

        if (curr != null) {
            if (curr.val == val) {
                temp.next = null;
            } else {
                //加这一步还是很有必要的，加入只有一个头结点的情况下，虚拟节点与头结点是不连接的，此时就需要这个语句把它们连接起来
                temp.next = curr;
            }
        }
        return dummy.next;
    }*/

	/**
	 * 这里用的就是迭代法，啥叫迭代？ 相同的一个变量每次给它赋予不同的值让他一步步向最终结果迈进
	 * 在此题中就是不断移动temp，判断是否满足条件，知道temp移到末尾，迭代就结束了
	 */
	public static ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode();
		ListNode temp = dummy;
		// 在这里我们可以一开始就让dummy与head相连，就不用了额外构造指针了
		temp.next = head;
		while (temp.next != null) {
			if (temp.next.val == val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		return dummy.next;
	}

	/**
	 * 递归法还需要再讨论
	 */

}