package duplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 중복제거 해시랑 리스트 비교
 * */
public class Main {
	private final static int START = 1;
	private final static int END = 1000;
	
	public static void main(String[] args) {
		List<Integer> a = IntStream
				.range(START, END * 100)
				.boxed()
				.collect(Collectors.toList());
		Collections.shuffle(a);
		
		List<Integer> b = IntStream
				.range(START, END)
				.boxed()
				.collect(Collectors.toList());
		Collections.shuffle(b);
		
		long hashStart = System.currentTimeMillis();
		List<Integer> hashResult = useHash(a, b);
		long hashEnd = System.currentTimeMillis();

		System.out.println("hash ::: " + (hashEnd - hashStart));
		System.out.println(hashResult);
		
		long listStart = System.currentTimeMillis();
		List<Integer> listResult = useList(a, b);
		long listEnd = System.currentTimeMillis();
		
		System.out.println("list::: " + (listEnd - listStart));
		System.out.println(listResult);
	}
	
	public static List<Integer> useHash(List<Integer> a, List<Integer> b){
		HashSet<Integer> hashSet = new HashSet<>();
		List<Integer> result = new ArrayList<>();
		hashSet.addAll(a);
		for(int i : b){
			if(hashSet.contains(i)){
				result.add(i);
			}
		}
		return result;
	}
	
	public static List<Integer> useList(List<Integer> a, List<Integer> b){
		List<Integer> result = new ArrayList<>();
		for(int i : b){
			if(a.contains(i)){
				result.add(i);
			}
		}
		return result;
	}
}
