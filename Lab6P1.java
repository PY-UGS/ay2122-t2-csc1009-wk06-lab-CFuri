import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Lab6P1 {
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		
		linkedList.add(1);
		linkedList.add(3);
		linkedList.add(5);
		linkedList.add(7);
		linkedList.add(9);
		linkedList.add(11);
		
		System.out.println("Before Change 1: " + linkedList);
		Random rand = new Random();

		addAndSort(linkedList, rand.nextInt(0,12));
		System.out.println("After Change 1: " + linkedList);

		swapValues(linkedList, 1, 5);
		System.out.println("After Change 2: " + linkedList);

		System.out.println("number found in position: " + randomLinkedList());
	}

	public static void addAndSort(LinkedList linkedList, int value) {
		int i = 0;
		while((int)linkedList.get(i) < value) {
			i++;
		}
		linkedList.add(i, value);
	}
	
	public static void swapValues(LinkedList linkedList, int index1, int index2) {
		int holder1 = (int)linkedList.get(index1);
		int holder2 = (int)linkedList.get(index2);
		linkedList.remove(index1);
		linkedList.add(index1,holder2);
		linkedList.remove(index2);
		linkedList.add(index2,holder1);
	}
	
	public static int randomLinkedList() {
		Random rand = new Random();
		LinkedList list = new LinkedList();
		int index = -1;
		for (int i = 0; i < 500; i++) {
			list.add(rand.nextInt(1000, 10000));
		}
		
		for (int i = 0; i < 500; i++) {
			if ((int)list.get(i) == rand.nextInt(1000,10000)) {
				index = i;
			}
		}
		return index;
	}
}
