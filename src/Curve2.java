
import java.util.*;

public class Curve2 {

	public static void main(String[] args) throws InterruptedException {
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
		ArrayList<Integer>[] incrCurv = getCurve(lst, size);
		Collections.reverse(lst);
		ArrayList<Integer>[] decrCurv = getCurve(lst, size);

		int max = 0;
		int maxIndex = -1;
		int maxIndexj = -1;
		for (int i = 0, j = size - 1; i < size; i++, j--) {
			if (incrCurv[i].size() + decrCurv[j].size() - 1 > max) {
				max = incrCurv[i].size() + decrCurv[j].size() - 1;
				maxIndex = i;
				maxIndexj = j;
			}
		}
		System.out.println(maxIndex + "max" + max);

		incrCurv[maxIndex].remove(incrCurv[maxIndex].size() - 1);
		Collections.reverse(decrCurv[maxIndexj]);
		incrCurv[maxIndex].addAll(decrCurv[maxIndexj]);
		for (int i = 0; i < incrCurv[maxIndex].size(); i++)
			System.out.print(incrCurv[maxIndex].get(i) + " ");

		System.out.println();
	}

	private static ArrayList<Integer>[] getCurve(List<Integer> lst, int size) {

		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] lSeq = new ArrayList[size];

		for (int i = 0; i < size; i++)
			lSeq[i] = new ArrayList<>();

		lSeq[0].add(lst.get(0));

		for (int i = 1; i < size; i++) {

			for (int j = 0; j < i; j++) {

				if ((lst.get(i) > lst.get(j)) && lSeq[j].size() > lSeq[i].size()) {
					for (int k : lSeq[j])
						if (!lSeq[i].contains(k))
							lSeq[i].add(k);
				}
			}
			lSeq[i].add(lst.get(i));
		}
		return lSeq;
	}

}
