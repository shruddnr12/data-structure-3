package queue;


public class PriorityTest02 {

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue(10);		// Queue<String> pq = new LinkedList<String>();  //일반적인 Queue를 사용하면 입력 순서대로 출력된다
		
		pq.offer("A");
		pq.peek();
		pq.offer("ABCDEF");
		pq.peek();
		pq.offer("ABC");
		pq.peek();
		pq.offer("ABCDEFGHI");
		pq.peek();
		pq.offer("ABCDE");
		pq.peek();
		pq.offer("AB");
		pq.peek();
		
		System.out.println(pq.poll());
		pq.peek();
		System.out.println(pq.poll());
		pq.peek();
		System.out.println(pq.poll());
		pq.peek();
		System.out.println(pq.poll());
		pq.peek();
		System.out.println(pq.poll());
		pq.peek();
		System.out.println(pq.poll());
		pq.peek();
		
		
		System.out.println(pq.poll());  // 다 빠져나온 상태라서 null만 출력
		
	}
}
