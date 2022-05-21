package linkedlist;

import java.util.HashSet;

/**
 * @author XuBowen
 * @date 2021/8/11 21:42
 *
 * 解析：
 * 此题有两种解法：
 * 1. 哈希表法
 * 第一种解法比较容易想，每遍历一个节点放入hashset中，如果有一个节点无法放入，则说明重复了，有环。
 * 与力扣官方解法一致
 *
 * 2. 快慢指针法
 * 如果要求空间复杂度为O(1)的话，就不能有额外开销了
 * 假想「乌龟」和「兔子」在链表上移动，「兔子」跑得快，「乌龟」跑得慢。
 * 当「乌龟」和「兔子」从链表上的同一个节点开始移动时，如果该链表中没有环，那么「兔子」将一直处于「乌龟」的前方；
 * 如果该链表中有环，那么「兔子」会先于「乌龟」进入环，并且一直在环内移动。
 * 等到「乌龟」进入环时，由于「兔子」的速度快，它一定会在某个时刻与乌龟相遇，即套了「乌龟」若干圈。
 *
 */

import java.util.HashSet;

/**
 * @author XuBowen
 * @date 2021/8/11 21:42
 *
 * 解析：
 * 此题有两种解法：
 * 1. 哈希表法
 * 第一种解法比较容易想，每遍历一个节点放入hashset中，如果有一个节点无法放入，则说明重复了，有环。
 * 与力扣官方解法一致
 *
 * 2. 快慢指针法
 * 如果要求空间复杂度为O(1)的话，就不能有额外开销了
 * 假想「乌龟」和「兔子」在链表上移动，「兔子」跑得快，「乌龟」跑得慢。
 * 当「乌龟」和「兔子」从链表上的同一个节点开始移动时，如果该链表中没有环，那么「兔子」将一直处于「乌龟」的前方；
 * 如果该链表中有环，那么「兔子」会先于「乌龟」进入环，并且一直在环内移动。
 * 等到「乌龟」进入环时，由于「兔子」的速度快，它一定会在某个时刻与乌龟相遇，即套了「乌龟」若干圈。
 *
 */
public class LC141_HasCycle {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(5, null);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);

	}

	/**
	 * 哈希表法，需要额外的空间复杂度
	 */
/*    public static boolean hasCycle(ListNode head) {
       HashSet<ListNode> hashSet = new HashSet<>();
       ListNode curr=head;
       while (curr!=null){
           if (!hashSet.add(curr)) {
               return true;
           }
           curr=curr.next;
       }
       return false;
   }*/

	/**
	 * 快慢指针法
	 */

	public static boolean hasCycle(ListNode head){
		if (head==null|| head.next==null){
			return false;
		}
		// 这里还必须要把fast放在head.next位置，否则slow和fast相等，连循环都无法进入
		ListNode fast=head.next;
		ListNode slow =head;

/*      //实际上这个判断条件有问题，如果方法体内fast正好走出了链表，那么再判断就会出错
       while (fast.next!=null){
           if (fast==slow){
               return true;
           }
           fast=fast.next.next;
           slow=slow.next;
       }*/

		// 现在换一种判断思路
		while (fast!=slow){
			if (fast==null || fast.next==null){
				return false;
			}
			fast=fast.next.next;
			slow=slow.next;
		}
		return true;
	}
}