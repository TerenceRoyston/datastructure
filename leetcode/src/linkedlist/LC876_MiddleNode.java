package linkedlist;

/**
 * @author XuBowen
 * @date 2021/7/31 21:37
 *
 * 解析：
 * 典型的快慢指针问题  TODO 总结快慢指针使用场景
 * 知识点：
 * 1. 在比较两个对象内容是否相等时，使用equals()方法，但前提是类中必须重写equals方法
 * 否则等同于==，比较内存地址是否相等
 * 2. 深浅拷贝问题
 * 已整理至语雀文档
 */
public class LC876_MiddleNode {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(5, null);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);

		System.out.println(middleNode(node1));
	}


	/**
	 * 常规方法，首先遍历获得链表长度，然后再重头出发走到目标节点
	 */
/*    public static ListNode middleNode(ListNode head) {
       ListNode curr = new ListNode();
       curr=head;
       int num=0;
       while (curr!=null){
           curr=curr.next;
           num++;
       }
       curr=head;
       int pos=num/2+1;
       while (pos!=1){
           curr=curr.next;
           pos--;
       }

       return curr;
   }*/

	/**
	 *	1.快慢指针解法。快指针走两步，慢指针走一步。快指针到重终点时，慢指针刚好走到一半。
	 *	但是本题有太多空指针场景需要考虑
	 *	2. 在偶数个节点场景时，题目需要返回第二个中间节点，如果需要返回第一个中间节点，循环判断条件就要改成
	 *	while (fast.next != null && fast.next.next != null)，同样需要考虑规避空指针问题
	 */
	public static ListNode middleNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

}