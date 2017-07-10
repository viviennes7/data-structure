package sort;

import java.util.List;

public class QuickSort implements Sort{

	@Override
	public List<Integer> execute(List<Integer> list) {
		quickSort(list, 0, list.size()- 1);
		return list;
	}
	
	public void quickSort(List<Integer> list, int left, int right){
		int i = 0;
		int j = 0;
		int pivot = 0;
		int temp = 0;
		
		if(left < right){
			i = left;
			j = right;
			pivot = list.get(left);
			
			while(i < j){
				while(list.get(j) > pivot){
					j--;
				}
				while(i < j && list.get(i) <= pivot){
					i++;
				}
				
				temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
			
			list.set(left, list.get(i));
			list.set(i, pivot);
			
			quickSort(list, left, i - 1);
			quickSort(list, i + 1, right);
		}
	}
}
