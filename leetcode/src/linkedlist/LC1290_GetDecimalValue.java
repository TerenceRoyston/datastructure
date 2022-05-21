package linkedlist;

/**
 * @author XuBowen
 * @date 2021/8/1 18:55
 *
 * 解析：
 * 通常我们将二进制数转为十进制是从低位开始逐个累加
 * 但是这里我们是从链表的头结点也就是相当于二进制数的高位开始累加，我们无法预先获知链表的长度，也就无法确定每个数对应的指数
 * 我们是不是有必要一定要先知道链表的长度，才可以确定指数呢？答案是不必要的。
 * ①每读取链表的一个节点值，可以认为读到的节点值是当前二进制数的最低位；
 * ②当读到下一个节点值的时候，需要将已经读到的结果乘以 22，再将新读到的节点值当作当前二进制数的最低位；
 * ③如此进行下去，直到读到了链表的末尾。
 * 很巧妙的解法，这样我们无论是从高位还是低位都可进行进制转换
 *
 */
public class LC1290_GetDecimalValue {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(0, null);
		ListNode node4 = new ListNode(1, node5);
		ListNode node3 = new ListNode(1, node4);
		ListNode node2 = new ListNode(0, node3);
		ListNode node1 = new ListNode(1, node2);

		System.out.println(getDecimalValue(node1));
	}

	public static int getDecimalValue(ListNode head) {
		int sum=0;

		while (head!=null){

			//这里换成位运算也可以  sum=sum<<1+head.val;
			sum=sum*2+head.val;
			head=head.next;
		}
		return sum;
	}
}
