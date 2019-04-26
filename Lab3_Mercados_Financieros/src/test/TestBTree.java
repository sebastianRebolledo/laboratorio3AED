package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import arbol_Avl.BNode;
import arbol_Avl.BTree;
import javafx.scene.Node;
import modelo.Mercado;

class TestBTree {

	BTree<Double, Mercado> treeAvl;
	
	public void scenOne() {
		treeAvl= new BTree<>();
	}
	@Test
	public void testInsert() {
		scenOne();
		Mercado marketOne= new Mercado("USB1", 25.0, "11/01/2019", "9:45");
		Mercado marketTwo= new Mercado("USB2", 21.0, "12/01/2019", "8:45");
		Mercado marketThree=new Mercado("USB3", 12.0, "10/01/2019", "8:35");
		Mercado marketFour=new Mercado("USB4", 16.0, "09/01/2019", "10:35");
		Mercado marketFive=new Mercado("USB5", 20.0, "01/01/2019", "3:35");
treeAvl.insert(marketOne.getValor(), marketOne);
treeAvl.insert(marketTwo.getValor(), marketTwo);
treeAvl.insert(marketThree.getValor(), marketThree);
treeAvl.insert(marketFour.getValor(), marketFour);
treeAvl.insert(marketFive.getValor(), marketFive);

int size=treeAvl.inorder_tree_walk2().size();
assertEquals(size, 5);
		
				
	}
	@Test
	public void testMaximium() {
		scenOne();
		Mercado marketOne= new Mercado("USB1", 18.0, "11/01/2019", "9:45");
		Mercado marketTwo= new Mercado("USB2", 21.0, "12/01/2019", "8:45");
		Mercado marketThree=new Mercado("USB3", 25.0, "10/01/2019", "8:35");
		Mercado marketFour=new Mercado("USB4", 16.0, "09/01/2019", "10:35");
		Mercado marketFive=new Mercado("USB5",15.0 , "01/01/2019", "3:35");
treeAvl.insert(marketOne.getValor(), marketOne);
treeAvl.insert(marketTwo.getValor(), marketTwo);
treeAvl.insert(marketThree.getValor(), marketThree);
treeAvl.insert(marketFour.getValor(), marketFour);
treeAvl.insert(marketFive.getValor(), marketFive);
BNode<Double, Mercado> nodeMaximum=treeAvl.maximum(treeAvl.getRoot());
assertEquals(nodeMaximum.getValue().getValor(),marketThree.getValor());


	}
//	
	@Test
	public void testMinimium() {
		scenOne();
		Mercado marketOne= new Mercado("USB1", 18.0, "11/01/2019", "9:45");
		Mercado marketTwo= new Mercado("USB2", 21.0, "12/01/2019", "8:45");
		Mercado marketThree=new Mercado("USB3", 25.0, "10/01/2019", "8:35");
		Mercado marketFour=new Mercado("USB4", 16.0, "09/01/2019", "10:35");
		Mercado marketFive=new Mercado("USB5",15.0 , "01/01/2019", "3:35");
treeAvl.insert(marketOne.getValor(), marketOne);
treeAvl.insert(marketTwo.getValor(), marketTwo);
treeAvl.insert(marketThree.getValor(), marketThree);
treeAvl.insert(marketFour.getValor(), marketFour);
treeAvl.insert(marketFive.getValor(), marketFive);
BNode<Double, Mercado> nodeMinimum=treeAvl.minimum(treeAvl.getRoot());
assertEquals(nodeMinimum.getValue().getValor(),marketFive.getValor());
	
	}
//	
	@Test
	public void testDelete() {
		scenOne();
		Mercado marketOne= new Mercado("USB1", 18.0, "11/01/2019", "9:45");
		Mercado marketTwo= new Mercado("USB2", 21.0, "12/01/2019", "8:45");
		Mercado marketThree=new Mercado("USB3", 25.0, "10/01/2019", "8:35");
		Mercado marketFour=new Mercado("USB4", 16.0, "09/01/2019", "10:35");
		Mercado marketFive=new Mercado("USB5",15.0 , "01/01/2019", "3:35");
treeAvl.insert(marketOne.getValor(), marketOne);
treeAvl.insert(marketTwo.getValor(), marketTwo);
treeAvl.insert(marketThree.getValor(), marketThree);
treeAvl.insert(marketFour.getValor(), marketFour);
treeAvl.insert(marketFive.getValor(), marketFive);

treeAvl.delete( 25.0);
assertEquals(treeAvl.getRoot().getRight().getValue().getValor(), marketTwo.getValor());
assertEquals(treeAvl.inorder_tree_walk2().size(), 4);

	}
//	
	@Test
	public void testSearch() {
		scenOne();
		Mercado marketOne= new Mercado("USB1", 18.0, "11/01/2019", "9:45");
		Mercado marketTwo= new Mercado("USB2", 21.0, "12/01/2019", "8:45");
		Mercado marketThree=new Mercado("USB3", 25.0, "10/01/2019", "8:35");
		Mercado marketFour=new Mercado("USB4", 16.0, "09/01/2019", "10:35");
		Mercado marketFive=new Mercado("USB5",15.0 , "01/01/2019", "3:35");
treeAvl.insert(marketOne.getValor(), marketOne);
treeAvl.insert(marketTwo.getValor(), marketTwo);
treeAvl.insert(marketThree.getValor(), marketThree);
treeAvl.insert(marketFour.getValor(), marketFour);
treeAvl.insert(marketFive.getValor(), marketFive);
double keySearch=16.0;
Mercado findMarket=treeAvl.search(keySearch);
double valor=findMarket.getValor();
//	assertEquals(valor, keySearch);
	
	}
	


}
