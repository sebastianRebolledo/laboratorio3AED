package arbol_Avl;

public interface IBTree<K extends Comparable<K>,V> {
	
	public V search(K key);
	public void insert(K key, V value);
	public void delete(K key);
	public void inorder_tree_walk();

}
