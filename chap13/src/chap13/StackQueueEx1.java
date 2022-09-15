package chap13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Stack 클래스 : LIFO (Last In First Out)
 *               Vector의 하위 클래스
 * 		push(Object) : Stack에 객체 저장
 * 		Object pop() : Stack에 객체 제거하고 반환
 * 		Object peek() : Stack에서 객체 반환
 * 		
 * Queue 인터페이스 : FIFO (First In First Out)
 * 			LinkedList가 구현 클래스
 * 		offer(Object) : Queue에 객체 저장
 * 		Object poll() : Queue에 객체 제거 및 반환
 * 		Object peek() : Queue에서 객체 조회 및 반환
 */
public class StackQueueEx1 {

	public static void main(String[] args) {
		String cars[] = {"소나타", "그랜저", "SM5", "K9"};
		Stack<String> stack = new Stack<>();
		for(String s: cars) stack.push(s);
		System.out.println("스택의 요소갯수"+stack.size());
		System.out.println(stack.peek());
		System.out.println("스택의 요소갯수:"+stack.size());
		System.out.println(stack.pop());
		System.out.println("스택의 요소갯수:"+stack.size());
		
		Queue<String> queue = new LinkedList<>();
		for(String s: cars) queue.offer(s);
		System.out.println("스택의 요소갯수"+queue.size());
		System.out.println(queue.peek());
		System.out.println("스택의 요소갯수:"+queue.size());
		System.out.println(queue.poll());
		System.out.println("스택의 요소갯수:"+queue.size());

	}

}
