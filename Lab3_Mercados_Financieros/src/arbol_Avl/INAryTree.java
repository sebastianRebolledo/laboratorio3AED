package arbol_Avl;


public interface INAryTree<K extends Comparable<K>,V> {	
	public NAryNode<K,V> getRoot();
	public NAryNode<K,V> search(K key);
	public void insert(K keyE, V valueE, K keyP) throws Exception;
	public void delete(K key) throws Exception;
	public void preorder_tree_walk();
}
