package sort;

import java.util.List;

public class InsertionSort implements Sort{

	@Override
	public List<Integer> execute(List<Integer> list) {
		int temp = 0;
		int j = 0;

		for (int i = 1; i < list.size() ; i++) {
			temp = list.get(i);
			for (j = i-1; j >= 0 && list.get(j)>temp ; j--) {
				list.set(j+1, list.get(j));
			}

			list.set(j+1, temp);
		}
		return list;
	}
}
