package abyat;
import java.util.*;

public class Curve {

	public static void main(String[] args) {
		Integer[] arr = { 0, 0, 0, 1, 1, 2, 1, 0, 0 };

		List<Integer> l1 = new ArrayList<Integer>();
		Collections.addAll(l1, arr);
		findCurve(l1);

		Integer[] arr2 = { 0, 1, 2, 3, 1, 0, 1, 2, 4, 2, 0 };

		List<Integer> l2 = new ArrayList<Integer>();
		Collections.addAll(l2, arr2);
		findCurve(l2);

		Integer[] arr3 = { 0, 1, 2, 4, 1, 1, 0, 2, 3, 4, 3, 2, 0 };

		List<Integer> l3 = new ArrayList<Integer>();
		Collections.addAll(l3, arr3);
		findCurve(l3);
	}

	static void findCurve(List<Integer> lst) {
		int size = lst.size();
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] incrCurv = new ArrayList[size];

		for (int i = 0; i < size; i++)
			incrCurv[i] = new ArrayList<>();

		incrCurv[0].add(lst.get(0));

		for (int i = 1; i < size; i++) {

			for (int j = 0; j < i; j++) {

				if ((lst.get(i) > lst.get(j)) && incrCurv[j].size() > incrCurv[i].size()) {
					for (int k : incrCurv[j])
						if (!incrCurv[i].contains(k))
							incrCurv[i].add(k);
				}
			}
			incrCurv[i].add(lst.get(i));
		}

		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] decrCurv = new ArrayList[size];

		for (int i = 0; i < size; i++)
			decrCurv[i] = new ArrayList<>();

		decrCurv[size - 1].add(lst.get(size - 1));

		for (int i = size - 2; i >= 0; i--) {

			for (int j = size - 1; j > i; j--) {
				if (lst.get(j) < lst.get(i) && decrCurv[j].size() > decrCurv[i].size())
					for (int k : decrCurv[j])
						if (!decrCurv[i].contains(k))
							decrCurv[i].add(k);
			}
			decrCurv[i].add(lst.get(i));
		}

		for (int i = 0; i < size; i++)
			Collections.reverse(decrCurv[i]);
		int max = 0;
		int maxIndex = -1;
		for (int i = 0; i < size; i++) {
			if (incrCurv[i].size() + decrCurv[i].size() - 1 > max) {
				max = incrCurv[i].size() + decrCurv[i].size() - 1;
				maxIndex = i;
			}
		}

		for (int i = 0; i < incrCurv[maxIndex].size() - 1; i++)
			System.out.print(incrCurv[maxIndex].get(i) + " ");

		for (int i = 0; i < decrCurv[maxIndex].size(); i++)
			System.out.print(decrCurv[maxIndex].get(i) + " ");
		System.out.println();
	}

//				Input A[] = [0, 0, 0, 1, 1, 2, 1, 0, 0], n = 9
//				Output: [0, 1, 2, 1, 0]
//				Input A[] = [0, 1, 2, 3, 1, 0, 1, 2, 4, 2, 0], n = 11
//				Output: [0, 1, 2, 3, 4, 2, 0]
//				Input A[] = [0, 1, 2, 4, 1, 1, 0, 2, 3, 4, 3, 2, 0], n = 13
//				Output: [0, 1, 2, 4, 3, 2, 0]

}
