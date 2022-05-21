package binarytree;

import binarytree.utils.PrintBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author XuBowen
 * @date 2021/9/1 20:31
 */
public class RESC05_BinarySearchTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(5);
		root.right = new TreeNode(18);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(9);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(19);
		PrintBinaryTree.printTree(root);

		System.out.println(isBST_1(root));
		System.out.println(inOrderTraversal_2(root));
		System.out.println(isBST_3(root));

	}

	/**
	 * 判断一棵树是否是搜索二叉树
	 * 方法1：递归方法中序遍历 + 使用额外集合空间，将每个节点的值放入到一个集合中，然后遍历集合判断是否升序
	 */
	public static boolean isBST_1(TreeNode head){
		inOrderTraversal_1(head);
		int temp=Integer.MIN_VALUE;
		for (Integer integer : list) {
			if (integer<temp){
				return false;
			}
			temp=integer;
		}
		return true;
	}

	public static ArrayList<Integer> list = new ArrayList<>();

	public static void inOrderTraversal_1(TreeNode head){
		if (head==null){
			return;
		}
		inOrderTraversal_1(head.left);
		list.add(head.value);
		inOrderTraversal_1(head.right);
	}


	/**
	 * 方法2：递归方法中序遍历 + 不使用额外空间
	 */
	public static int preValue;
	public static boolean inOrderTraversal_2(TreeNode head){
		if (head==null){
			return true;
		}

		boolean isLeftBST = inOrderTraversal_2(head.left);
		if (!isLeftBST){
			return false;
		}
		if (head.value<preValue){
			return false;
		}else {
			preValue=head.value;
		}
		return inOrderTraversal_2(head.right);
	}

	/**
	 * 方法3：使用完全递归方法进行判断   递归框架非常重要，必须掌握
	 * 2021-10-02补充 这种思路几乎可以解决一切树形DP问题
	 */

	public static boolean isBST_3(TreeNode head){
		return  process(head).checkBST;
	}

	public static ReturnType process(TreeNode x){
		if (x==null){
			return null;
		}

		ReturnType leftData = process(x.left);
		ReturnType rightData = process(x.right);

		int minValue=x.value;
		int maxValue=x.value;
		boolean isBST=true;

		if (leftData!=null){
			minValue=Math.min(minValue,leftData.minValue);
			maxValue=Math.max(maxValue,leftData.maxValue);
		}

		if (rightData!=null){
			minValue=Math.min(minValue,rightData.minValue);
			maxValue=Math.max(maxValue,rightData.maxValue);
		}

		if (leftData!=null && (!leftData.checkBST || leftData.maxValue>=x.value)){
			isBST=false;
		}

		if (rightData!=null && (!rightData.checkBST || rightData.minValue <= x.value) ){
			isBST=false;
		}

		return new ReturnType(isBST,minValue,maxValue);

	}


	/**
	 * 方法4：非递归方法中序遍历
	 */

	public static boolean isBST_2(TreeNode head) {
		if (head != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			while (head.left != null) {
				queue.offer(head);
				head=head.left;
			}

		}
		return false;
	}



	public  static  class ReturnType{
		boolean checkBST;
		int minValue;
		int maxValue;

		public ReturnType(boolean checkBST, int minValue, int maxValue) {
			this.checkBST = checkBST;
			this.minValue = minValue;
			this.maxValue = maxValue;
		}
	}

}

