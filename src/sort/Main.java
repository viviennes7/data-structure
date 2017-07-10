package sort;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	
	private final static int START = 1;
	private final static int END = 100000;
	private final static Sort sort = new QuickSort();
	
	public static void main(String[] args) {
		List<Integer> noRange = IntStream
									.range(START, END)
									.boxed()
									.collect(Collectors.toList());
		Collections.shuffle(noRange);
		printAry(noRange);
		
		final long start = System.currentTimeMillis();
		List<Integer> range = sort.execute(noRange);
		final long end = System.currentTimeMillis();
		printAry(range);
		System.out.println("걸린시간(ms) ::: " + (end-start));
		
	}
	
	public static void printAry(List<Integer> list){
		String result  = list.stream()
						.map(String::valueOf)
						.collect(Collectors.joining(", "));
		System.out.println(result);
	}
}
