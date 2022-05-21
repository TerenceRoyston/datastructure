package binarytree;


import binarytree.utils.PrintBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对二叉树逐行进行宽度遍历
 */
public class RESC03_WidthTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(8);
		root.right.left = new TreeNode(6);
		root.right.left.left = new TreeNode(9);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(10);
		root.right.right.right = new TreeNode(11);
		PrintBinaryTree.printTree(root);

		widthTraversal(root);
	}


	/**
	 * 构建一个队列，首先将根节点加入队列
	 * 然后每弹出一个节点，打印节点的值，并将其左节点和右节点加入到队列尾部
	 */
	public static void widthTraversal(TreeNode head) {
		if (head != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(head);
			while (!queue.isEmpty()) {
				head = queue.poll();
				System.out.print(head.value + "|");
				if (head.left != null) {
					queue.offer(head.left);
				}
				if (head.right != null) {
					queue.offer(head.right);
				}
			}
		}
	}
}