package linkedlist;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author XuBowen
 * @date 2021/8/1 19:55
 *
 * 这道题解法还是比较多的
 * 1. 直接先遍历链表，获取长度创建数组，再次遍历链表，将节点的值填到数组对应位置
 * 2. 也可以借助栈，利用其先入后出的特点
 */
public class Sword06_ReversePrint {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(5, null);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);

		int[] arr = reversePrint(node1);
		System.out.println(Arrays.toString(arr));
	}

	public static int[] reversePrint(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		ListNode curr = head;
		int length = 0;
		while (curr != null) {
			stack.push(curr.val);
			curr = curr.next;
			length++;
		}
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = stack.pop();
		}
		return arr;
	}
}
