package linkedlist;

import java.util.HashMap;

/**
 * @author XuBowen
 * @date 2021/8/19 22:33
 * <p>
 * 如何复制一个随机链表
 * 解析： 这与复制单链表有区别，单链表实现clone方法为深拷贝，但是随机链表实现clone方法要是浅拷贝，就是因为有这个随机节点的存在。
 * 我们使用一个hashmap ，每遍历老链表的一个节点，浅拷贝出一个新节点，将这两个节点放入hashmap中，然后重新再遍历老链表，
 * 根据老节点的节点指向配置新节点的指向。但是这使用了额外空间，只能在笔试中使用
 * <p>
 * 那么根据惯例，我们肯定需要一个不使用额外空间的做法
 */
public class RESC05_CopyRandomLinkedList {
	public static void main(String[] args) throws CloneNotSupportedException {
		RandomListNode node5 = new RandomListNode(5, null, null);
		RandomListNode node4 = new RandomListNode(4, node5, node5);
		RandomListNode node3 = new RandomListNode(3, node4, node5);
		RandomListNode node2 = new RandomListNode(2, node3, node5);
		RandomListNode node1 = new RandomListNode(1, node2, node4);

		//RandomListNode node_1 = copyRandomList(node1);
		//System.out.println(node_1);
		//System.out.println(node_1.random);
		//System.out.println(node_1.random.hashCode());
		//System.out.println(node_1.next.random.hashCode());

//		RandomListNode newHead = insertCopyNodes(node1);
//		System.out.println(newHead);
//		RandomListNode[] splitCopyList = splitCopyList(newHead);
//		System.out.println(splitCopyList[0]);
//		System.out.println(splitCopyList[1]);

		RandomListNode newHead = copyRandomList(node1);
		System.out.println(newHead.random);
		System.out.println(node1.random);

	}

	/**
	 * 哈希表法，使用了额外空间
	 */
/*	public static RandomListNode copyRandomList(RandomListNode head) throws CloneNotSupportedException {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

		RandomListNode curr = head;
		while (curr != null) {
			RandomListNode rlcopy = (RandomListNode) curr.clone();
			map.put(curr, rlcopy);
			curr = curr.next;
		}

		curr = head;
		while (curr != null) {
			RandomListNode currCopy = map.get(curr);
			currCopy.next = map.get(curr.next);
			currCopy.random = map.get(curr.random);
			curr = curr.next;
		}

		return map.get(head);
	}*/

	/**
	 * 不使用哈希表，将新老节点串在一起，形成hashmap的效果
	 */
	public static RandomListNode copyRandomList(RandomListNode head) throws CloneNotSupportedException {
		//将老链表每一个节点复制放到下一位
		RandomListNode newHead = insertCopyNodes(head);
		RandomListNode curr = newHead;

		// 根据老链表的随机指向设置新链表的随机指向，注意这里只设置随机指向
		while (curr != null) {
/*			if (curr.random != null) {
				curr.next.random = curr.random.next;
			} else {
				curr.next.random = null;
			}*/

			// 简写
			curr.next.random = curr.random != null ? curr.random.next : null;
			curr = curr.next.next;
		}

		// 将混合链表中的老链表和新链表分隔开，返回新链表的头节点
		RandomListNode[] copyArr = splitCopyList(head);

		return copyArr[1];
	}

	/**
	 * 遍历链表，拷贝每个节点并将其插入到下一个节点
	 */
	public static RandomListNode insertCopyNodes(RandomListNode head) {
		RandomListNode curr = head;
		RandomListNode temp;
		while (curr != null) {
			temp = curr.next;
			RandomListNode copyNode = new RandomListNode(curr.val);
			curr.next = copyNode;
			copyNode.next = temp;
			curr = temp;
		}
		return head;
	}

	/**
	 * 将原链表与复制链表重新剥离开
	 */
	public static RandomListNode[] splitCopyList(RandomListNode head) {
		RandomListNode curr1 = head;
		RandomListNode res1 = head;
		RandomListNode curr2 = head.next;
		RandomListNode res2 = head.next;
		while (curr1 != null && curr2 != null) {
			if (curr2.next == null) {
				curr1.next = null;
				curr2.next = null;
				break;
			}
			curr1.next = curr1.next.next;
			curr2.next = curr2.next.next;
			curr1 = curr1.next;
			curr2 = curr2.next;
		}

		return new RandomListNode[]{res1, res2};
	}


}
