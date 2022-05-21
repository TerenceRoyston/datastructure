package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author XuBowen
 * @date 2021/9/4 12:07
 */
public class LC94_InorderTraversal {
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
		inorderTraversal_1(root);
		inorderTraversal_2(root);
		inorderTraversal_3(root);
	}

	/**
	 * 递归方法遍历
	 */
    public static List<Integer> inorderTraversal_1(TreeNode root) {
       ArrayList<Integer> list = new ArrayList<>();
       process(root,list);
       System.out.println(list);
       return list;
   }

   public static void process(TreeNode head,List<Integer> list){
       if (head==null){
           return;
       }
       process(head.left,list);
       list.add(head.value);
       process(head.right,list);
   }


	/**
	 * 非递归方法进行遍历
	 */
	public static List<Integer> inorderTraversal_2(TreeNode root){
		ArrayList<Integer> list = new ArrayList<>();
		if (root!=null){
			Stack<TreeNode> stack = new Stack<>();
			while (!stack.isEmpty() || root !=null){
				if (root!=null){
					stack.push(root);
					root=root.left;
				}else {
					root = stack.pop();
					list.add(root.value);
					root=root.right;
				}
			}
		}
		System.out.println(list);
		return list;
	}

	/**
	 * 颜色标记法
	 * 在树的深度优先遍历中（包括前序、中序、后序遍历），递归方法最为直观易懂，但考虑到效率，我们通常不推荐使用递归。
	 * 栈迭代方法虽然提高了效率，但其嵌套循环却非常烧脑，不易理解，容易造成“一看就懂，一写就废”的窘况。而且对于不同的遍历顺序（前序、中序、后序），循环结构差异很大，更增加了记忆负担。
	 * 因此，我在这里介绍一种“颜色标记法”，兼具栈迭代方法的高效，又像递归方法一样简洁易懂，更重要的是，这种方法对于前序、中序、后序遍历，能够写出完全一致的代码。
	 */
	public static List<Integer> inorderTraversal_3(TreeNode root){
		ArrayList<Integer> list = new ArrayList<>();
		if (root !=null){
			Stack<ColorTreeNode> stack = new Stack<>();
			stack.push(new ColorTreeNode(root,"white"));
			while (!stack.isEmpty()){
				ColorTreeNode item = stack.pop();
				if (item.node == null){
					continue;
				}
				if (item.color.equals("white")){
					stack.push(new ColorTreeNode(item.node.right,"white"));
					stack.push(new ColorTreeNode(item.node,"gray"));
					stack.push(new ColorTreeNode(item.node.left,"white"));
				}else {
					list.add(item.node.value);
				}
			}
		}
		System.out.println(list);
		return list;
	}
}

class ColorTreeNode{
	TreeNode node;
	String color;

	public ColorTreeNode(TreeNode node, String color) {
		this.node = node;
		this.color = color;
	}
}