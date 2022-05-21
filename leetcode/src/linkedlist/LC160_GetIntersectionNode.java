package linkedlist;

import java.util.HashSet;
import java.util.List;

/**
 * 此题本质就是找出第一个相同节点，方法很多
 */

public class LC160_GetIntersectionNode {
	public static void main(String[] args) {
		ListNode node7 = new ListNode(7, null);
		ListNode node5 = new ListNode(5, node7);
		ListNode node3 = new ListNode(3, node5);
		ListNode node1 = new ListNode(1, node3);

		//ListNode node8 = new ListNode(8, null);
		//ListNode node6 = new ListNode(6, node8);
		ListNode node4 = new ListNode(4, node5);
		ListNode node2 = new ListNode(2, node4);

		System.out.println(getIntersectionNode(node1, node2));

	}

	/**
	 * 其实这题就是找出两条链表第一个相同的节点，可以抽象成两个数组找相同数字
	 * 自己考虑使用双重for循环，但是效率较低
	 */
/*    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode slow = headA;
        ListNode fast = headB;

        while (slow != null) {
            while (fast != null) {
                if (slow != fast) {
                    fast = fast.next;
                } else {
                    return slow;
                }
            }
            fast = headB;
            slow = slow.next;
        }
        return null;
    }*/


	/**
	 * leetcode官方解法一
	 * 使用集合将其中一个链表里的所有节点都存储起来，然后遍历另一个链表逐个比对是否存在于集合中
	 * 返回第一个匹配成功的节点
	 *
	 * 时间复杂度：O(m+n) 空间复杂度：O(m)
	 */
/*    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        HashSet<ListNode> set = new HashSet<>();
        ListNode currA=headA;
        ListNode currB=headB;
        while (currA!=null){
            set.add(currA);
            currA=currA.next;
        }

        while (currB!=null){
            if (set.contains(currB)){
                return currB;
            }
            currB=currB.next;
        }
        return null;
    }*/

	/**
	 * leetcode官方解法二
	 * 一个很巧妙的方法，本质是长度互补
	 * 假设链表A长度为a，链表B长度为b，假设从公共节点开始到末尾长度是c
	 * 那么从headA到公共节点长度为a-c，同理headB到公共节点长度为b-c
	 * 那么构建一个等式 a+（b-c）=b+(a-c)
	 * 这个等式意义就是A链表走到末尾后再从B链表开始走，B链表同理
	 * 这样两个节点必然相会于公共节点，因为它们走过的路程相同。
	 *
	 * 那么如果没有公共节点，它们会陷入死循环么？
	 * 答案是不会，我们可以将null视为一个公共节点，即长度c为0,
	 * 在走完对方的链表还没相遇的情况下，它们会相会于null节点
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode currA = headA;
		ListNode currB = headB;
		while (currA != currB) {
			currA = currA != null ? currA.next : headB;
			currB = currB != null ? currB.next : headA;
		}
		return currA;
	}
}