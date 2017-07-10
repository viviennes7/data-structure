package tree;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		BinarySearchTree binaryTree = new BinarySearchTree();
		
		List<Integer> list = IntStream
								.range(1, 101)
								.boxed()
								.collect(Collectors.toList());
		Collections.shuffle(list);

		for(int i : list){
			binaryTree.insert(i);
		}
		
		System.out.println("검색 ::: " + binaryTree.find(5)+"\n");
		System.out.println("삭제 ::: " + binaryTree.delete(5)+"\n");
		System.out.println("검색 ::: " + binaryTree.find(5));
	}
}
