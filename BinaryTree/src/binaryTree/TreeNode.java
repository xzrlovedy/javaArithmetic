package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�����������������дӸ��ڵ㵽Ҷ�ӽڵ��·����
 *
 * ʾ��:
 * ����:
 * <p>
 *     1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * ���: ["1->2->5", "1->3"]
 * ����: ���и��ڵ㵽Ҷ�ӽڵ��·��Ϊ: 1->2->5, 1->3
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
     * �ݹ��жϵ�ǰ�ڵ��ǲ���Ҷ�ӽڵ�
     * ���� root Ϊ��ǰ�ڵ㣬str Ϊ�ýڵ�ǰ��·��
     * ������Ҷ�ӽڵ㣬�����res�У�����Ҷ�ӽڵ㣬�����������
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
