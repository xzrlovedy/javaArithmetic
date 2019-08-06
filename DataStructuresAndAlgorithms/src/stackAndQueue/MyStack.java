package stackAndQueue;

import java.util.Arrays;

/**
 * ����ʵ��ջ
 * @author Administrator
 *
 */
public class MyStack<E> {
	private Object[] stack;
	private int size;//����洢Ԫ�ظ���
	
	public MyStack(){
		stack = new Object[10];
	}
	//�ж϶�ջ�Ƿ�Ϊ��
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
		ensureCapacity(size+1);//�������
		stack[size++] = item;
		return item;
	}
	//�ж������Ƿ�������������������������ռ�
	private void ensureCapacity(int size) {
		int len = stack.length;
		if(size>len) {//��������
			int newLen = 10;
			stack = Arrays.copyOf(stack, newLen);
		}
	}
	
	public static void main(String[] args) {
		MyStack<Integer> s = new MyStack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		
		System.out.println("ջ��Ԫ�صĸ���Ϊ��"+s.size);
		System.out.println("ջ��Ԫ�أ�"+s.pop());
		System.out.println("ջ��Ԫ�أ�"+s.pop());
	}
}
