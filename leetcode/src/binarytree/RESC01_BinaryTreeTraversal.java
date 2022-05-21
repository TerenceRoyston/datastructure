package binarytree;

import binarytree.utils.PrintBinaryTree;

import java.util.Stack;

/**
 * @author XuBowen
 * @date 2021/8/29 16:06
 * 二叉树的遍历问题
 */
public class RESC01_BinaryTreeTraversal {
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

		System.out.println("递归前序遍历");
		preOrderTraversal(root);
		System.out.println();
		System.out.println("递归中序遍历");
		inOrderTraversal(root);
		System.out.println();
		System.out.println("递归后序遍历");
		postOrderTraversal(root);
		System.out.println();
		System.out.println("非递归前序遍历");
		preOrderTraversalUnRecur(root);
		System.out.println();
		System.out.println("非递归中序遍历");
		inOrderTraversalUnRecur(root);
		System.out.println();
		System.out.println("非递归后序遍历");
		posOrderTraversalUnRecur(root);
	}


	/**
	 * 递归前序遍历
	 * 在第一次到达这个节点时进行处理
	 * 这里要强调一下：二叉树的深度优先遍历就是前序遍历
	 *
	 * 2021-10-02补充
	 * 这个方法就是使用递归框架思维解决问题
	 * 向左子树要信息，向右子树要信息，返回信息
	 */
	public static void preOrderTraversal(TreeNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + "|");
		preOrderTraversal(head.left);
		preOrderTraversal(head.right);
	}


	/**
	 * 递归中序遍历
	 * 在第二次到达这个节点时进行处理
	 */
	public static void inOrderTraversal(TreeNode head) {
		if (head == null) {
			return;
		}
		inOrderTraversal(head.left);
		System.out.print(head.value + "|");
		inOrderTraversal(head.right);
	}

	/**
	 * 递归后序遍历
	 * 在第三次到达这个节点时进行处理
	 */
	public static void postOrderTraversal(TreeNode head) {
		if (head == null) {
			return;
		}
		postOrderTraversal(head.left);
		postOrderTraversal(head.right);
		System.out.print(head.value + "|");
	}

	/**
	 * 非递归先序遍历
	 * 首先构造一个栈，并先将根节点压栈
	 * 然后开始遍历栈，每弹出一个节点，打印节点的值，并依次将右节点和左节点压栈（如果有的话）
	 */
	public static void preOrderTraversalUnRecur(TreeNode head) {
		if (head != null) {
			Stack<TreeNode> stack = new Stack<>();
			stack.add(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.value + "|");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
	}

	/**
	 * 非递归中序遍历
	 * 这中序遍历思路值得注意
	 * 依次将当前节点的左节点全部压栈
	 * 然后开始弹栈，每弹出一个节点就将其右节点压入栈中，在下一次循环中将右节点的全部左子节点全部压入栈中
	 * 循环往复
	 */
	public static void inOrderTraversalUnRecur(TreeNode head) {
		if (head != null) {
			Stack<TreeNode> stack = new Stack<>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.print(head.value + "|");
					head = head.right;
				}
			}
		}
	}

	/**
	 * 非递归后序遍历
	 * 构造两个栈：主栈和辅助栈，并先将根节点压入主栈中
	 * 然后开始遍历主栈，每弹出一个节点，将其压入辅助栈中，然后依次将该节点的左节点和右节点分别压入主栈中
	 * 主栈弹空后，依次弹出辅助栈中的节点并打印节点值即可
	 */
	public static void posOrderTraversalUnRecur(TreeNode head) {
		if (head != null) {
			Stack<TreeNode> mainStack = new Stack<>();
			Stack<TreeNode> assistStack = new Stack<>();
			mainStack.push(head);
			TreeNode tempNode;
			while (!mainStack.isEmpty()) {
				tempNode = mainStack.pop();
				assistStack.push(tempNode);
				if (tempNode.left != null) {
					mainStack.push(tempNode.left);
				}
				if (tempNode.right != null) {
					mainStack.push(tempNode.right);
				}
			}
			while (!assistStack.isEmpty()) {
				System.out.print(assistStack.pop().value + "|");
			}
		}
	}


}
