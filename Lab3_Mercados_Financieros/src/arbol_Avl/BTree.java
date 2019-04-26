package arbol_Avl;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BTree<K extends Comparable<K>, V> implements IBTree<K,V> {
	
	BNode<K,V> root;
	
	public BTree() {
		root = null;
	}
	
	
	public ArrayList<BNode<K,V> > arrayMaximus(BNode<K,V> z){
		ArrayList<BNode<K,V> > array= new ArrayList<>();
		BNode<K,V> x = z;
		while(x.getRight()!=null) {
			array.add(x.getRight());
			x = x.getRight();
		}
		return array;
	}
	
	private BNode<K,V> search1(K key) {
		if(root == null)
			return null;
		else
			return root.search(key);
	}
	
	public V search(K key) {
		if(root == null)
			return null;
		else
			return root.search(key).getValue();
	}
	
	public void insert(K key, V value) {
		BNode<K,V> toInsert = new BNode<>(key,value);
		insert(toInsert);
	}
	
	private void insert(BNode<K,V> node) {
		BNode<K,V> y = null;
		BNode<K,V> x = root;
		while(x!=null) {
			y = x;
			if(node.getKey().compareTo(x.getKey()) < 0)
				x = x.getLeft();
			else
				x = x.getRight();
		}
		node.setParent(y);
		if(y==null) {
			root = node;
		}
		else if(node.getKey().compareTo(y.getKey()) < 0) {
			y.setLeft(node);
		}
		else {
			y.setRight(node);
		}
	}
	
	public BNode<K,V> minimum(BNode<K,V> z) {
		BNode<K,V> x = z;
		while(x.getLeft()!=null) {
			x = x.getLeft();
		}
		return x;
	}
	
	public BNode<K,V> maximum(BNode<K,V> z) {
		BNode<K,V> x = z;
		while(x.getRight()!=null) {
			x = x.getRight();
		}
		return x;
	}
	
	public BNode<K,V> successor(BNode<K,V> x) {
		if(x.getRight()!=null) {
			return minimum(x.getRight());
		}
		BNode<K,V> y = x.getParent();
		while(y!=null && x == y.getRight()) {
			x = y;
			y = y.getParent();
		}
		return y;
	}
	
	private BNode<K,V> predecessor(BNode<K,V> x) {
		if(x.getLeft()!=null) {
			return maximum(x.getRight());
		}
		BNode<K,V> y = x.getParent();
		while(y!=null && x == y.getLeft()) {
			x = y;
			y = y.getParent();
		}
		return y;
	}
	
	public void delete(K key) {
		BNode<K,V> toDelete = search1(key);
		delete(toDelete);
	}
	
	private void delete(BNode<K,V> z) {
		BNode<K,V> y,x;
		if(z.getLeft()==null || z.getRight()==null){
			y = z;
		}
		else {
			y = successor(z);
		}
		if(y.getLeft()!=null) {
			x = y.getLeft();
		}
		else {
			x = y.getRight();
		}
		if(x!=null) {
			x.setParent(y.getParent());
		}
		if(y.getParent()==null) {
			root = x;
		}
		else {
			if(y==y.getParent().getLeft()) {
				y.getParent().setLeft(x);
			}
			else {
				y.getParent().setRight(x);
			}
		}
		if(y!=z) {
			z.setKey(y.getKey());
			z.setValue(y.getValue());
		}
	}
	
	public void inorder_tree_walk() {
		inorder_tree_walk(root);
	}
	
	public ArrayList<BNode> inorder_tree_walk2(){
		ArrayList<BNode> nodos= new ArrayList<>();
		inorder2(root,nodos);
		return nodos;
	}
	private void inorder2(BNode<K,V> x,ArrayList<BNode> nodos ){
		if(x!=null) {
			inorder2(x.getLeft(),nodos);
			nodos.add( (BNode) x);
			inorder2(x.getRight(),nodos);
		}
	}
	
	
	private void inorder_tree_walk(BNode<K,V> x) {
		if(x!=null) {
			inorder_tree_walk(x.getLeft());
			System.out.println("("+x.getKey()+","+x.getValue()+")");
			inorder_tree_walk(x.getRight());
		}
	}
	
	public static void main(String[] args) {
		IBTree<Integer,Integer> tree = new BTree<>();
		tree.insert(1,1);
		tree.insert(2,2);
		tree.insert(3,3);
		tree.inorder_tree_walk();
		tree.delete(2);
		tree.inorder_tree_walk();
		tree.delete(1);
		tree.inorder_tree_walk();
	}

	public BNode<K, V> getRoot() {
		return root;
	}

	public void setRoot(BNode<K, V> root) {
		this.root = root;
	}
	
	
}