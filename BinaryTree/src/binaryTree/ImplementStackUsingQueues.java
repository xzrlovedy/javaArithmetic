package binaryTree;

import java.util.ArrayDeque;

/**
 * ʹ�ö���ʵ��ջ�����в�����
 *
 * push(x) -- Ԫ�� x ��ջ
 * pop() -- �Ƴ�ջ��Ԫ��
 * top() -- ��ȡջ��Ԫ��
 * empty() -- ����ջ�Ƿ�Ϊ��
 */
public class ImplementStackUsingQueues {
	ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
	
	public void push(int x) {
		queue.add(x);
		for(int i=0;i<queue.size()-1;i++) {
			queue.add(queue.poll());
		}
	}
	
	public int pop() {
		return queue.poll();
	}
	
	public int top() {
		return queue.peek();
	}
	
	public boolean empty() {
		return queue.isEmpty();
	}
	
	public static void main(String[] args) {
		ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
		for(int i=1;i<10;i++) {
			stack.push(i);
		}
		System.out.println("ջ����"+stack.top());
		System.out.println("�Ƴ�ջ����"+stack.pop());
		System.out.println("��ջ����"+stack.top());
	}
}
