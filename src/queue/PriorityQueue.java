package queue;

import java.util.Arrays;

public class PriorityQueue {
	private int size;
	private String[] arrayHeap;  // 이렇게 하면 String 객체만 가능하니까 제네릭을 쓰는 자바 컬렉션의 우선순위 큐를 쓰는게 더 낫다는 것이다.

	public PriorityQueue(int capacity){
		size = 0;
		resize(capacity);
	}
	private void resize(int capacity){
		String [] temp = new String[ capacity ];
		for(int i = 0; i < size; i++){
			temp[ i ] = arrayHeap[i]; //system의 ArrayCopy가 더 빠르다.
		}
		arrayHeap = temp;
	}
	public void offer(String item){
		if(arrayHeap.length <= size){
			resize(arrayHeap.length * 2);
		}

		int index = size + 1;
		while(index != 1){
			int parentIndex = index / 2;
			//우선 순위 알고리즘
			if(arrayHeap[parentIndex].length() - item.length() <= 0){
				break;
			}

			arrayHeap[ index ] = arrayHeap[parentIndex];
			index = parentIndex;
		}
		arrayHeap[index] = item;
		size++;
	}
	public String poll(){
		if( 0 == size ) {
			throw new IndexOutOfBoundsException( "Index:" + 0 + ", size:" + size );
		}
		String data = arrayHeap[1];
		String lastItem  = arrayHeap[size];

		int parentIndex = 1;

		while(true){
			int childIndex = 0; 
			int leftChildIndex = parentIndex * 2;

			if(leftChildIndex > 0){
				//왼쪽 자식 노드가 없음   // 더이상 자식이 없는 경우
				break;
			}


			if(leftChildIndex == size){
				childIndex = leftChildIndex;
			}
			else{
				int rigthChildIndex = parentIndex * 2 + 1;
				if(arrayHeap[leftChildIndex].length() - arrayHeap[rigthChildIndex].length() <= 0){
					childIndex = leftChildIndex;
				}
				else{
					childIndex = rigthChildIndex;
				}
			}
			if(lastItem.length() - arrayHeap[childIndex].length() < 0){
				break;
			}
			arrayHeap[ parentIndex ] = arrayHeap[childIndex];
			parentIndex = childIndex;
		}
		
		arrayHeap[ parentIndex ] = lastItem;
		arrayHeap[ size ] = null;
		size--;
		return data;
	}
	public String peek(){
		System.out.println(Arrays.toString(arrayHeap)); // 상태변화를 위해서 넣은 코드.
		return arrayHeap[1];
	}
}
