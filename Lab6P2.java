import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.*;
import java.lang.*;

public class Lab6P2 {

	public static void main(String[] args) {
		HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
		hashmap.put(0,1);
		hashmap.put(1,3);
		hashmap.put(2,5);
		hashmap.put(3,7);
		hashmap.put(4,9);
		hashmap.put(5,11);
		
		System.out.println("Before Change 1: " + hashmap);
		Random rand = new Random();
		hashmap = addAndSort(hashmap, rand.nextInt(0,12));
		System.out.println("After Change 1: " + hashmap);
		swapValues(hashmap, 1, 5);
		System.out.println("After Change 2: " + hashmap);
		System.out.println("Number found in index: " + randomHashMap());
		
	}
	
	public static HashMap<Integer,Integer> addAndSort(HashMap hashmap, int value) {
		int key = hashmap.size();
		hashmap.put(key, value);
		HashMap<Integer, Integer> hashmap1 = sortByValue(hashmap);
		
		return hashmap1;
	}
	
    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm)
    {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
		
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

	public static void swapValues(HashMap map, int num1, int num2) {
		int temp1 = (int)map.get(num1);
		int temp2 = (int)map.get(num2);
		
		map.remove(num1);
		map.put(num1, temp2);
		map.remove(num2);
		map.put(num2, temp1);
	} 
	
	public static int randomHashMap() {
		Random rand = new Random();
		HashMap map = new HashMap();
		int index = -1;
		
		for (int i = 0; i < 500; i++) {
			map.put(i, rand.nextInt(1000, 10000));
		}
		
		
		for (int i = 0; i < 500; i++) {
			if ((int)map.get(i) == rand.nextInt(1000,10000)) {
				index = i;
			}
		}
		
		return index;
	}
}
	
