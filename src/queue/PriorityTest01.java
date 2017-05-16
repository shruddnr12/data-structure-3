package queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityTest01 {

	public static void main(String[] args) {
		Queue<String> pq = 
				new PriorityQueue<String>(10,new Comparator<String>() { // 이렇게 공간을 초기화 했다는건 내부가 동적 배열로 되어있다는 것이다. //힙은 동적 배열로 만들어야 한다. // Comparator는 인터페이스다.

					@Override //우선 순위 조건
					public int compare(String o1, String o2) {   // int형 반환값  앞>뒤 : 1  앞=뒤 0  앞<뒤 -1
						return o1.length() - o2.length();   //기본으로 MIN-HEAP이다. o2와 o1의 순서를 바꿔주면 MAX-HEAP이 된다.
					}		
		});
		// Queue<String> pq = new LinkedList<String>();  //일반적인 Queue를 사용하면 입력 순서대로 출력된다
		pq.offer("A");
		pq.offer("ABCDEF");
		pq.offer("ABC");
		pq.offer("ABCDEFGHI");
		pq.offer("ABCDE");
	
		while(pq.isEmpty() == false){
			System.out.println(pq.poll());
		}
	}
}
