package linkedlist;

import java.util.Stack;

/**
 * @author XuBowen
 * @date 2021/8/8 22:10
 * 解析：这题的解法很多，比如遍历链表的值放入数组，比如使用栈。但是如果非要强调O(1)的空间复杂度就比较复杂了。
 * 这里使用快慢指针法，将链表的后半部分反转
 */
public class LC234_IsPalindrome {
	public static void main(String[] args) {
		ListNode node5 = new ListNode(1, null);
		ListNode node4 = new ListNode(2, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);

		System.out.println(node1);
		System.out.println(isPalindrome(node1));
		System.out.println(node1);
	}

  /*public static boolean isPalindrome(ListNode head) {
     Stack<Integer> stack = new Stack<>();
     ListNode curr = head;
     while (curr != null) {
        stack.push(curr.val);
        curr = curr.next;
     }

     curr = head;
     while (curr != null) {
        Integer i = stack.pop();
        if (curr.val != i) {
           return false;
        }
        curr = curr.next;
     }
     return true;

  }*/

	/**
	 * 快慢指针法在这一题中综合了较多的知识点，如寻找中间节点，反转链表
	 * 这样写没问题，但是结构较乱。
	 * 参考力扣不同功能单独提出来作为一个函数
	 */
/*    public static boolean isPalindrome(ListNode head) {
       ListNode fast = head;
       ListNode slow = head;

       //寻找中间节点
       while (fast != null && fast.next != null) {
           fast = fast.next.next;
           slow = slow.next;
       }

       //开始反转链表
       ListNode prev = null;
       ListNode curr = slow;
       ListNode temp;
       ListNode end = null;

       //从中间链表开始反转后半部分链表
       while (curr != null) {
           //在末端安插一个指针
           if (curr.next == null) {
               end = curr;
           }
           temp = curr.next;
           curr.next = prev;
           prev = curr;
           curr = temp;
       }

       //到这里链表已经反转，并已在末端安插了一个指针
       //在前端安插一个指针
       ListNode front = head;
       //两个指针开始相向而行
       while (front != null && end != null) {
           if (front.val != end.val) {
               return false;
           }
           front = front.next;
           end = end.next;
       }
       return true;
   }*/

	/**
	 * 不同功能单独提出来作为一个函数
	 * 明确各功能的结构，这样代码就清晰多了
	 */
	public static boolean isPalindrome(ListNode head){
		// 找到前半部分链表的尾节点并反转后半部分链表
		ListNode firstHalfEnd = endOfFirstHalf(head);
		ListNode secondHalfStart = reverseList(firstHalfEnd.next);

		//开始判断是否为回文链表
		ListNode front=head;
		ListNode end=secondHalfStart;
		while (front != null && end != null) {
			if (front.val != end.val) {
				return false;
			}
			front = front.next;
			end = end.next;
		}

		//还要考虑恢复成原始链表的样子
		reverseList(secondHalfStart);

		return true;
	}

	/**
	 * 反转链表
	 * 返回原先的末端节点，翻转后的首节点
	 */
	public static ListNode reverseList(ListNode head){
		ListNode prev=null;
		ListNode curr=head;
		ListNode temp;
		while (curr!=null){
			temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
		}
		return prev;
	}

	/**
	 * 查找前半部分最后一个节点
	 */
	public static ListNode endOfFirstHalf(ListNode head){
		ListNode fast=head;
		ListNode slow=head;
		while (fast.next!=null&&fast.next.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	}
}