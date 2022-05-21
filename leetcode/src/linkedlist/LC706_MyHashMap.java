package linkedlist;

import java.util.LinkedList;

/**
 * @author XuBowen
 * @date 2021/8/8 15:13
 */
public class LC706_MyHashMap {
	public static void main(String[] args) {
		MyHashMap myHashMap = new MyHashMap();
		myHashMap.put(1, 10);
		myHashMap.put(2, 20);
		System.out.println(myHashMap.get(2));
		myHashMap.remove(2);
		System.out.println(myHashMap.get(2));
	}


}

class MyHashMap {

	class Pair {
		int key;
		int value;

		public Pair(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private static final int BASE = 769;
	private LinkedList<Pair>[] data;

	/**
	 * Initialize your data structure here.
	 */
	public MyHashMap() {
		data = new LinkedList[BASE];
		for (int i = 0; i < BASE; i++) {
			data[i] = new LinkedList<>();
		}
	}

	/**
	 * value will always be non-negative.
	 */
	public void put(int key, int value) {
		int h = hash(key);
		for (Pair pair : data[h]) {
			if (pair.key == key) {
				pair.value = value;
				return;
			}
		}
		data[h].offerLast(new Pair(key, value));
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
	 */
	public int get(int key) {
		int h = hash(key);
		for (Pair pair : data[h]) {
			if (pair.key == key) {
				return pair.value;
			}
		}
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping for the key
	 */
	public void remove(int key) {
		int h = hash(key);
		//使用这种for循环在数据量大的情况下会报错
		/*for (Pair pair : data[h]) {
			if (pair.key==key){
				data[h].remove(pair);
			}
		}*/
		//注意这种写法，能够处理大数据量场合
		data[h].removeIf(pair -> pair.key == key);
	}

	public int hash(int key) {
		return key % BASE;
	}
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
