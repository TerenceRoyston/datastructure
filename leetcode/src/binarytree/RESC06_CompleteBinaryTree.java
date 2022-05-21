package binarytree;

import binarytree.utils.PrintBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author XuBowen
 * @date 2021/9/6 21:50
 *
 * 如何判断一棵树是不是完全二叉树
 * 思路：
 * 在宽度方向上进行遍历，判断两个条件
 * (1) 一个节点左节点存在但右节点不存在，直接false
 * (2) 一个节点如果只存在左节点，那么从此以后的所有节点都必须是叶子节点，否则直接判错
 * 其余流程均按照正常宽度遍历方式出入队列
 *
 */
public class RESC06_CompleteBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
//		root.left.left.left = new TreeNode(8);
		root.right.left = new TreeNode(6);
//		root.right.left.left = new TreeNode(9);
		root.right.right = new TreeNode(7);
//		root.right.right.left = new TreeNode(10);
//		root.right.right.right = new TreeNode(11);

		PrintBinaryTree.printTree(root);
		System.out.println(isCompleteBinaryTree(root));
	}

	public static boolean isCompleteBinaryTree(TreeNode head) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(head);
		// 标记位，判断是否出现了"一个节点如果只存在左节点" 这种情况
		boolean flag = false;
		while (!queue.isEmpty()) {
			head = queue.poll();
			TreeNode left = head.left;
			TreeNode right = head.right;
			if (
					(flag && (left != null || right != null))
							||
					(left == null && right != null)) {
				return false;
			}
			if (left != null) {
				queue.offer(left);
			}
			if (right != null) {
				queue.offer(right);
			}
			if (left == null || right == null) {
				flag = true;
			}
		}
		return true;
	}
}
