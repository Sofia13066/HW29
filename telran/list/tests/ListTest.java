package telran.list.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.list.interfaces.IList;
import telran.list.model.MyArrayList;

class ListTest {

	@Test
	void test() {
		IList<Integer> list = new MyArrayList<>();
		System.out.println(list.size());
		list.add(2);
		list.add(7);
		list.add(3);
		list.add(5);
		list.add(null);
		list.add(7);
		System.out.println(list.size());
		// System.out.println(list.get(1));
		// System.out.println(list.get(4));
		// System.out.println(list.indexOf(7));
		// System.out.println(list.lastIndexOf(7));
		// System.out.println(list.indexOf(null));
		// System.out.println(list.contains(11));
		// System.out.println(list.isEmpty());
		// list.remove((Integer)3);
		// System.out.println(list.contains(3));
		// System.out.println(list.contains(5));
		// Integer x = list.set(3, 11);
		// System.out.println(x);
		// System.out.println(list.get(3));
        list.add(1, 8);
        System.out.println(list.size());
        for (Integer num : list) {
            System.out.print(num+"\t");
        }
        list.clear();
        System.out.println(list.isEmpty());
		
	}

}
