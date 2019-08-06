package stackAndQueue;
/**
 * ʹ��O(1)ʱ�临�Ӷ���ջ����СԪ��
 * @author Administrator
 *
 */
public class MyStack3 {
	MyStack<Integer> elem;
	MyStack<Integer> min;
	
	public MyStack3() {
		elem = new MyStack<Integer>();
		min = new MyStack<Integer>();
	}
	
	public void push(int data) {
		elem.push(data);
		if(min.isEmpty()) {
			min.push(data);
		}else {
			if(data<min.peek()) {
				min.push(data);
			}
		}
	}
	
	public int pop() {
		int topData = elem.peek();
		elem.pop();
		if(topData==this.min()) {
			min.pop();
		}
		return topData;
	}
	
	public int min() {
		if(min.isEmpty()) {
			return Integer.MAX_VALUE;
		}else {
			return min.peek();
		}
	}
	
	public static void main(String[] args) {
		MyStack3 s = new MyStack3();
		s.push(2);
		s.push(1);
		s.push(3);
		
		System.out.println("��ջ����СԪ�أ�"+s.min());
	}
}
