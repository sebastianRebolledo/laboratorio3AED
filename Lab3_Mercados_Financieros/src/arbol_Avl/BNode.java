package arbol_Avl;



public class BNode<K extends Comparable<K>, V> {

	private K key;
	private V value;
	private BNode<K, V> parent;
	private BNode<K, V> left;
	private BNode<K, V> right;

	public BNode(K key, V value) {
		this.key = key;
		this.value = value;
		left = null;
		right = null;
		parent = null;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public BNode<K, V> getParent() {
		return parent;
	}

	public void setParent(BNode<K, V> parent) {
		this.parent = parent;
	}

	public BNode<K, V> getLeft() {
		return left;
	}

	public void setLeft(BNode<K, V> left) {
		this.left = left;
	}

	public BNode<K, V> getRight() {
		return right;
	}

	public void setRight(BNode<K, V> right) {
		this.right = right;
	}

	public boolean isLeaf() {
		return (left == null && right == null);
	}
	
	public BNode<K,V> search(K key) {
			if(key.compareTo(this.getKey()) == 0) {
				return this;
			}
			else {
				if(key.compareTo(this.getKey())>0) {
					return this.getRight().search(key);
				}
				else
					return this.getLeft().search(key);
			}
	}
	
	
}

