package linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 自己实现一个hashset
 * 知识点
 * 1. hash取余方法
 * 2. 迭代器的使用
 */
public class LC705_MyHashSet {
	public static void main(String[] args) {
		MyHashSet myHashSet = new MyHashSet();
		myHashSet.add(9);
		myHashSet.remove(19);
		myHashSet.add(14);
		myHashSet.remove(19);
		myHashSet.remove(9);
		myHashSet.add(0);
		myHashSet.add(3);
		myHashSet.add(4);
		myHashSet.add(0);
		myHashSet.remove(9);
		System.out.println(myHashSet.contains(3));
		//System.out.println(myHashSet);

	}


}

/**
 * 自己的想法与力扣解法有很大区别，我是使用一条单链表来实现hashset
 * 但力扣是使用数组+linkedlist的方式实现hashset，且直接调用了linkedlist的API
 * <p>
 * Initialize your data structure here.
 * <p>
 * Returns true if this set contains the specified element
 * <p>
 * Initialize your data structure here.
 * <p>
 * Returns true if this set contains the specified element
 */
/*class MyHashSet {
	ListNode temp;
	ListNode dummy = new ListNode();

	*//**
 * Initialize your data structure here.
 *//*
	public MyHashSet() {
		temp = dummy;
	}

	public void add(int key) {
		ListNode prev=dummy;
		ListNode cursor = dummy.next;
		while (cursor != null) {
			if (cursor.val == key) {
				return;
			}
			prev=cursor;
			cursor = cursor.next;
		}
		ListNode node = new ListNode(key);
		prev.next = node;
		//temp = temp.next;
	}

	public void remove(int key) {
		ListNode prev = dummy;
		ListNode curr = dummy.next;
		if (curr == null) {
			return;
		}
		while (curr != null && curr.next != null) {
			if (curr.val == key) {
				curr.val = curr.next.val;
				curr.next = curr.next.next;
			}
			prev = curr;
			curr = curr.next;
		}
		if (curr!=null&&curr.val == key) {
			prev.next = null;
		}
	}

	*//**
 * Returns true if this set contains the specified element
 *//*
	public boolean contains(int key) {
		ListNode cursor = dummy.next;
		while (cursor != null) {
			if (cursor.val == key) {
				return true;
			}
			cursor = cursor.next;
		}
		return false;
	}

	@Override
	public String toString() {
		return dummy.next.toString();
	}
}*/

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

class MyHashSet {
	private static final int BASE = 769;
	private LinkedList<Integer>[] data;

	/**
	 * Initialize your data structure here.
	 */
	public MyHashSet() {
		data = new LinkedList[BASE];
		for (int i = 0; i < BASE; i++) {
			data[i] = new LinkedList<Integer>();
		}
	}

	public void add(int key) {
		int h = hash(key);
		//构造一个迭代器，唉其实不需要用迭代的，增强型for循环也可以，例如下面remove方法里写得
		Iterator<Integer> iterator = data[h].iterator();
		while (iterator.hasNext()) {
			Integer element = iterator.next();
			if (element == key) {
				return;
			}
		}
		data[h].offerLast(key);
	}

	public void remove(int key) {
		int h = hash(key);
		for (Integer element : data[h]) {
			if (element == key) {
				data[h].remove(element);
				break;
			}
		}
	}

	/**
	 * Returns true if this set contains the specified element
	 */
	public boolean contains(int key) {
		int h = hash(key);
		for (Integer element : data[h]) {
			if (element == key) {
				return true;
			}
		}
		return false;
	}

	// 重写hashcode方法，设计一个简单的哈希函数：hash(x) = x mod base
	// 为啥要模除素数，因为数据源可能并非完全随机的，如果用素数的话可以保证不受规律数据源的影响。
	private static int hash(int key) {
		return key % BASE;
	}

	//用这种形式很难打印啊，因为是数组+链表的形式

}