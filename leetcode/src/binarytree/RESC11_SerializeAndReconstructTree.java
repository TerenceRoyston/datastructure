package binarytree;

import binarytree.utils.PrintBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author XuBowen
 * @date 2021/10/3 2:09
 *
 * 以某种方式序列化二叉树为字符串
 * 再根据字符串重建整棵树
 */
public class RESC11_SerializeAndReconstructTree {
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

		String serializedTree = serializedByPre(root);
		System.out.println(serializedTree);
		TreeNode deSerializedTree = reconstructByPreString(serializedTree);
		PrintBinaryTree.printTree(deSerializedTree);
	}

	/**
	 * 以先序方式序列化二叉树
	 */
	public static String serializedByPre(TreeNode head){
		if (head == null){
			return "#_";
		}

		String res=head.value+"_";
		res+=serializedByPre(head.left);
		res+=serializedByPre(head.right);
		return res;
	}

	/**
	 * 从字符串中重建这棵树
	 */
	public static TreeNode reconstructByPreString(String treeStr){
		String[] arr = treeStr.split("_");
		Queue<String> queue=new LinkedList<String>();
		for (String s : arr) {
			queue.offer(s);
		}
		return process(queue);

	}

	public static TreeNode process(Queue<String> queue){
		String value = queue.poll();
		if (value.equals("#")){
			return null;
		}

		TreeNode node=new TreeNode(Integer.parseInt(value));
		node.left=process(queue);
		node.right=process(queue);
		return node;
	}
}
