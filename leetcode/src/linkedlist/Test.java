package linkedlist;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author XuBowen
 * @date 2021/7/27 0:11
 */
public class Test {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(1);
		linkedList.offerLast(10);
		linkedList.offer(6);
		System.out.println(linkedList);

		//System.out.println(linkedList.get(30));

		HashSet<Integer> hashSet = new HashSet<>();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);
		if (hashSet.add(10)){
			System.out.println("yes");
		}
		System.out.println(hashSet);
	}
}
