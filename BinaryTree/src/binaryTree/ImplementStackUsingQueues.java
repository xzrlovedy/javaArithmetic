package binaryTree;

import java.util.ArrayDeque;

/**
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
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
		System.out.println("栈顶："+stack.top());
		System.out.println("移除栈顶："+stack.pop());
		System.out.println("新栈顶："+stack.top());
	}
}
