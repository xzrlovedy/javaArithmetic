package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 示例:
 * 输入:
 * <p>
 *     1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	static List<String> res = new ArrayList<String>();
	
	TreeNode(int x){
		val = x;
	}
	
	public static List<String> method1(TreeNode root){
		if(root == null) {
			return res;
		}
		if(root.left == null&&root.right == null) {
			res.add(root.val+"");
		}
		if(root.left != null) {
            fun(root.left, root.val + "");
        }
        if(root.right != null) {
            fun(root.right, root.val + "");
        }
        return res;
	}
	/*
     * 递归判断当前节点是不是叶子节点
     * 参数 root 为当前节点，str 为该节点前的路径
     * 若遇到叶子节点，则加入res中；若非叶子节点，则继续往下走
     */
    public static void fun(TreeNode root, String str){
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
        	res.add(str + "->" + root.val);
        }
        if(root.left != null) {
            fun(root.left, str + "->" + root.val);
        }
        if(root.right != null) {
            fun(root.right, str + "->" + root.val);
        }
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		
		root.left = t2;
		root.right =t3;
		t2.right = t4;
		
		System.out.println(method1(root).toString());
	}
}
