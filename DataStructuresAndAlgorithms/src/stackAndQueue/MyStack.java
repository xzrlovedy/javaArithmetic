package stackAndQueue;

import java.util.Arrays;

/**
 * 数组实现栈
 * @author Administrator
 *
 */
public class MyStack<E> {
	private Object[] stack;
	private int size;//数组存储元素个数
	
	public MyStack(){
		stack = new Object[10];
	}
	//判断堆栈是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	public E peek() {
		if(isEmpty()) {
			return null;
		}
		return (E)stack[size-1];
	}
	public E pop() {
		E e = peek();
		stack[size-1] = null;
		size--;
		return e;
	}
	public E push(E item) {
		ensureCapacity(size+1);//检查容量
		stack[size++] = item;
		return item;
	}
	//判断数组是否已满，若已满，则扩充数组空间
	private void ensureCapacity(int size) {
		int len = stack.length;
		if(size>len) {//数组已满
			int newLen = 10;
			stack = Arrays.copyOf(stack, newLen);
		}
	}
	
	public static void main(String[] args) {
		MyStack<Integer> s = new MyStack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		
		System.out.println("栈中元素的个数为："+s.size);
		System.out.println("栈顶元素："+s.pop());
		System.out.println("栈顶元素："+s.pop());
	}
}
