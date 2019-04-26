package arbol_Avl;



public class NAryTree<K extends Comparable<K>,V> implements INAryTree<K,V> {

	NAryNode<K,V> root;

	public NAryTree() {
		root = null;
	}

	public NAryNode<K,V> getRoot() {
		return this.root;
	}

	public NAryNode<K,V> search(K key) {
		if(root == null)
			return null;
		else
			return root.search(key);
	}


	public void insert(K keyE, V valueE, K keyP) throws Exception {
		NAryNode<K,V> toInsert = new NAryNode<K,V>(keyE,valueE);
		if(root == null) {
			root = toInsert;
		}
		else {
			NAryNode<K,V> temp = search(keyP);
			if(temp == null) {
				throw new Exception("Parent does not exist");
			}
			else {
				temp.insertElement(toInsert);
			}
		}
	}

	public void delete(K key) throws Exception {
		if(root == null) {
			throw new Exception("Tree is empty");
		}
		else if(root.getKey().compareTo(key) == 0) {
			if(root.isLeaf()) {
				root = null;
			}
			else {
				throw new Exception("Impossible to remove");
			}
		}
		else {
			NAryNode<K,V> temp = search(key).getParent();
			if(temp == null) {
				throw new Exception("Invalid node");
			}
			else {
				temp.deleteElement(key);
			}
		}
	}

	public void preorder_tree_walk() {
		preorder_tree_walk(root);
	}

	private void preorder_tree_walk(NAryNode<K,V> x) {
		if(x!=null) {
			System.out.println("("+x.getKey()+","+x.getValue()+")");
			for(int i=0;i<x.getChildren().size();i++) {
				NAryNode<K,V> temp = x.getChildren().get(i);
				preorder_tree_walk(temp);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		INAryTree<Integer,Integer> tree = new NAryTree<>();
		tree.insert(1,1,0);
		tree.insert(2,2,1);
		tree.insert(3,3,1);
		tree.preorder_tree_walk();
		tree.delete(2);
		tree.preorder_tree_walk();
		tree.insert(4,4,3);
		tree.preorder_tree_walk();
		tree.insert(5,5,1);
		tree.delete(4);
		tree.preorder_tree_walk();
	}
	
}
