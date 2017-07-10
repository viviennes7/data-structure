package tree;

public class BinarySearchTree {
	public Node root;
	
	public BinarySearchTree(){
		this.root = null;
	}
	
	public boolean find (int id){
		Node current = root;
		boolean result = false;
		System.out.println("======검색중======");
		while(current != null){
			System.out.print(current.getData() + " ");
			
			if(current.getData() == id){
				result = true;
				break;
			}else if(current.getData() > id){
				current = current.getLeft();
			}else{
				current = current.getRight();
			}
		}
		System.out.println("\n==================");
		return result;
	}
	
	public void insert(int id){
		Node newNode = new Node(id);
		
		if(root ==null){
			root = newNode;
			return;
		}
		
		Node current = root;
		Node parent = null;

		while(true){
			parent = current;
			if(id < current.getData()){
				current = current.getLeft();
				if(current == null){
					parent.setLeft(newNode);
					return;
				}
			}else{
				current = current.getRight();
				if(current == null){
					parent.setRight(newNode);
					return;
				}
			}
		}
	}
	
	public boolean delete(int id){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		
		while(current.getData() != id){
			parent = current;
			
			if(current.getData() > id){
				isLeftChild = true;
				current = current.getLeft();
			}else{
				isLeftChild = false;
				current = current.getRight();
			}
			
			if(current == null){
				return false;
			}
		}
			
		//자식노드가 없는 경우
		if(current.getLeft() == null && current.getRight() == null){
			if(current == root){
				root = null;
			}
			if(isLeftChild){
				parent.setLeft(null);
			}else{
				parent.setRight(null);
			}
		}
		//하나의 자식노드를 갖는 경우
		else if(current.getRight() == null){
			if(current == root){
				root = current.getLeft();
			}else if(isLeftChild){
				parent.setLeft(current.getLeft());
			}else{
				parent.setRight(current.getLeft());
			}
		}else if(current.getLeft() == null){
			if(current == root){
				root = current.getRight();
			}else if(isLeftChild){
				parent.setLeft(current.getRight());
			}else{
				parent.setRight(current.getRight());
			}
		}
		//두개의 자식노드를 갖는 경우
		else if(current.getLeft() != null && current.getRight() != null){
			Node successor = this.getSuccessor(current);
			
			if(current == root){
				root = successor;
			}else if(isLeftChild){
				parent.setLeft(successor);
			}else{
				parent.setRight(successor);
			}
			successor.setLeft(current.getLeft());
		}
	
		return true;
	}

	private Node getSuccessor(Node deleteNode) {
		Node successor = null;
		Node successorParent = null;
		Node current = deleteNode.getRight();
		
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.getLeft();
		}
		if(successor != deleteNode.getRight()){
			successorParent.setLeft(successor.getLeft());
			successor.setRight(deleteNode.getRight());
		}
		
		return successor;
	}
}