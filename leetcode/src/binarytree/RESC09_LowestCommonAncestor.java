package binarytree;

import binarytree.utils.PrintBinaryTree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author XuBowen
 * @date 2021/10/2 15:37
 * <p>
 * 寻找两个节点的最低公共祖先
 */
public class RESC09_LowestCommonAncestor {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		root.left = node5;
		root.right = node1;
		TreeNode node6 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		node5.left = node6;
		node5.right = node2;
		TreeNode node7 = new TreeNode(7);
		TreeNode node4 = new TreeNode(4);
		node2.left = node7;
		node2.right = node4;
		PrintBinaryTree.printTree(root);


		TreeNode ancestor = getLowestCommonAncestor(root, node5, node4);
		System.out.println(ancestor.value);
		ancestor = getLowestCommonAncestor_2(root, node5, node4);
		System.out.println(ancestor.value);


	}

	/**
	 * 使用额外空间
	 * 思路：将二叉树所有节点对应父节点写入hashmap
	 * 然后将o1节点血缘关系放入hashset中
	 * 然后逐个摸排o2的血缘关系，最先出现在o1血缘关系中的即是公共祖先
	 */
	public static TreeNode getLowestCommonAncestor(TreeNode head, TreeNode o1, TreeNode o2) {
		HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
		fatherMap.put(head, head);
		process(head, fatherMap);
		HashSet<TreeNode> fatherSet = new HashSet<>();
		TreeNode curr = o1;
		while (curr != fatherMap.get(curr)) {
			fatherSet.add(curr);
			curr = fatherMap.get(curr);
		}

		fatherSet.add(head);


		curr = o2;
		while (curr != fatherMap.get(curr)) {
			if (fatherSet.contains(curr)) {
				return curr;
			}
			curr = fatherMap.get(curr);
		}

		return head;

	}

	public static void process(TreeNode head, HashMap<TreeNode, TreeNode> fatherMap) {
		if (head == null) {
			return;
		}

		if (head.left != null) {
			fatherMap.put(head.left, head);
		}

		if (head.right != null) {
			fatherMap.put(head.right, head);
		}

		process(head.left, fatherMap);
		process(head.right, fatherMap);
	}

	public static TreeNode getLowestCommonAncestor_2(TreeNode head, TreeNode o1, TreeNode o2) {
		if (head == null || head == o1 || head == o2) {
			return head;
		}

		TreeNode left = getLowestCommonAncestor_2(head.left, o1, o2);
		TreeNode right = getLowestCommonAncestor_2(head.right, o1, o2);
		if (left != null && right != null) {
			return head;
		}

		return left != null ? left : right;
	}

}
