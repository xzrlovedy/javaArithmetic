package stackAndQueue;

import java.util.LinkedList;

/**
 * ʹ�����鷽ʽʵ�ֶ��У���Ӷ��̰߳�ȫ
 * @author Administrator
 *
 */
public class MyQueue2<E> {
	private LinkedList<E> list = new LinkedList<E>();
	private int size = 0;
	
	public synchronized void put(E e) {
		list.addLast(e);
		size++;
	}
	
	public synchronized E pop() {
		size--;
		return list.removeFirst();
	}
	
	public synchronized boolean empty() {
		return size == 0;
	}
	
	public synchronized int size() {
		return size;
	}
	
	public static void main(String[] args) {
		MyQueue2<Integer> q = new MyQueue2<Integer>();
		q.put(1);
		q.put(2);
		q.put(3);
		
		System.out.println("���г��ȣ�"+q.size());
		System.out.println("������Ԫ�أ�"+q.pop());
		System.out.println("������Ԫ�أ�"+q.pop());
	}
}
