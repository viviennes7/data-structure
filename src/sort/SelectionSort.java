package sort;

import java.util.List;

public class SelectionSort implements Sort{

	@Override
	public List<Integer> execute(List<Integer> list) {
		for(int i=0; i<list.size(); i++){
			for (int j = i+1; j < list.size(); j++) {
				
				int temp = 0;
				
				if(list.get(i) > list.get(j)){
					temp = list.get(i);
					list.set(i, list.get(j)) ;
					list.set(j, temp);
				}
			}
		}
		return list;
	}
}
