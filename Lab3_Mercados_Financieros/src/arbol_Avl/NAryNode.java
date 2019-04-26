package arbol_Avl;

import java.util.ArrayList;


public class NAryNode<K extends Comparable<K>, V> {


	private K key;
	private V value;
	private NAryNode<K,V> parent;
	private ArrayList<NAryNode<K,V>> children;

	public NAryNode(K key, V value) {
		this.key = key;
		this.value = value;
		this.parent = null;
		children = new ArrayList<>();

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

	public NAryNode<K,V> getParent() {
		return parent;
	}

	public void setParent(NAryNode<K,V> parent) {
		this.parent = parent;
	}

	public ArrayList<NAryNode<K, V>> getChildren() {
		return children;
	}

	public void insertChild(NAryNode<K, V> child) {
		this.children.add(child);
	}

	public boolean isLeaf() {
		return children.size() == 0;
	}

	public NAryNode<K, V> search(K key) {
		if(this.key.compareTo(key)==0) {
			return this;
		}
		else if (isLeaf()){
			return null;
		}
		else {
			for(int i=0;i<children.size();i++){
				NAryNode<K,V> temp = children.get(i).search(key);
				if(temp != null) {
					return temp;
				}
			}
			return null;
		}
	}

	public void insertElement(NAryNode<K,V> node) {
		node.setParent(this);
		children.add(node);
	}

	public void deleteElement(K key) throws Exception {
		for(int i=0;i<children.size();i++){
			NAryNode<K,V> temp = children.get(i);
			if(temp.getKey().compareTo(key)==0 && temp.isLeaf()) {
				children.remove(i);
			}
			else throw new Exception("Non removable");
		}
	}
}