package linkedlist;

import java.util.Arrays;

/**
 * @author XuBowen
 * @date 2021/8/15 10:41
 * <p>
 * 解析：链表中的荷兰国旗问题
 */
public class RESC04_LinkedListPartition {
	public static void main(String[] args) {

		ListNode node6 = new ListNode(6, null);
		ListNode node5 = new ListNode(2, node6);
		ListNode node4 = new ListNode(3, node5);
		ListNode node3 = new ListNode(5, node4);
		ListNode node2 = new ListNode(4, node3);
		ListNode node1 = new ListNode(1, node2);

		System.out.println(partitionLinkedList(node1, 3));
	}

	/**
	 * 这是经典荷兰国旗做法，把链表放到数组中，然后使用partition，但是使用额外的空间复杂度
	 * 适合于笔试场景
	 */
/*	public static void partitionLinkedList(ListNode head, int target) {
		ListNode curr = head;
		int count = 0;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		ListNode[] nodes = new ListNode[count];
		curr = head;
		for (int i = 0; i < count; i++) {
			nodes[i] = curr;
			curr = curr.next;
		}
		System.out.println(Arrays.toString(nodes));
		int left = 0;
		int lessArea = left - 1;
		int right = nodes.length - 1;
		int moreArea = right + 1;

		while (left < moreArea) {
			if (nodes[left].val < target) {
				swap(nodes, left, lessArea + 1);
				lessArea++;
				left++;
			} else if (nodes[left].val > target) {
				swap(nodes, left, moreArea - 1);
				moreArea--;
			} else {
				left++;
			}
		}
		System.out.println(Arrays.toString(nodes));
	}*/

	/**
	 * 使用六个变量，sH|ST表示小于区域的头和尾，eH|eT表示等于区域的头和尾，mH|mT表示大于区域的头和尾
	 * 每遍历一个节点就判断属于哪个区域，然后再判断对应区域的头和尾是否为空，如果为空，就把头和尾都指向当前节点，
	 * 如果不为空，就把尾指向该节点，然后尾移动到当前节点。判断完后，当前节点移动一步。
	 * 遍历结束后需要判断各区域是否为空的情况，方法必须揣摩
	 * 这种方法没有使用额外的空间，只定义了六个指针
	 */
	public static ListNode partitionLinkedList(ListNode head, int target) {
		ListNode sH = null;
		ListNode sT = null;
		ListNode eH = null;
		ListNode eT = null;
		ListNode mH = null;
		ListNode mT = null;
		ListNode curr = head;

		while (curr != null) {
			if (curr.val < target) {
				if (sH == null) {
					sH = curr;
					sT = curr;
				} else {
					sT.next = curr;
					sT = sT.next;
				}
			} else if (curr.val == target) {
				if (eT == null) {
					eH = curr;
					eT = curr;
				} else {
					eT.next = curr;
					eT = eT.next;
				}
			} else {
				if (mT == null) {
					mH = curr;
					mT = curr;
				} else {
					mT.next = curr;
					mT = mT.next;
				}
			}
			curr = curr.next;
		}


		// 这里要考虑一下三个分区如果各自为空怎么办？
		if (sT != null) {
			sT.next = eH;
			// 这一步很巧妙了
			eT = eT == null ? sT : eT;
		}
		if (eT != null) {
			eT.next = mH;
		}

		return sH != null ? sH : eH != null ? eH : mH;
	}

	public static void swap(ListNode[] arr, int i, int j) {
		ListNode temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


}
