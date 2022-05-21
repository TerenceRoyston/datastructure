package binarytree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author XuBowen
 * @date 2021/8/29 20:20
 */
public class Test {
	public static void main(String[] args) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(1,2);
		hashMap.put(3,4);
		System.out.println(hashMap.keySet());

		for (Integer key : hashMap.keySet()) {
			System.out.println(key +" => "+hashMap.get(key));
		}

		String str="1_2_3_";
		String[] split = str.split("_");
		System.out.println(Arrays.toString(split));
	}
}



