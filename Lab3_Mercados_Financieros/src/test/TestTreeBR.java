package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import arbolRojoNegro.ArbolRojoNegro;
import modelo.Mercado;

class TestTreeBR {
	 ArbolRojoNegro<Double, Mercado> treeRB;

	public void sceneOne() {
		treeRB= new ArbolRojoNegro<>();
	}
	
	@Test
	public void testInsert() {
		sceneOne();
		Mercado marketOne= new Mercado("USB1", 25.0, "11/01/2019", "9:45");
		Mercado marketTwo= new Mercado("USB2", 21.0, "12/01/2019", "8:45");
		Mercado marketThree=new Mercado("USB3", 12.0, "10/01/2019", "8:35");
		Mercado marketFour=new Mercado("USB4", 16.0, "09/01/2019", "10:35");
		Mercado marketFive=new Mercado("USB5", 20.0, "01/01/2019", "3:35");
        treeRB.insertar(marketOne.getValor(), marketOne);
        treeRB.insertar(marketTwo.getValor(), marketOne);
        treeRB.insertar(marketThree.getValor(), marketOne);
        treeRB.insertar(marketFour.getValor(), marketOne);
        treeRB.insertar(marketFive.getValor(), marketOne);
 int size=5;
assertEquals(size, treeRB.darPeso());				
	}
	
	
	@Test
	public void testDelete() {
		sceneOne();
		Mercado marketOne= new Mercado("USB1", 25.0, "11/01/2019", "9:45");
		Mercado marketTwo= new Mercado ("USB2", 21.0, "12/01/2019", "8:45");
		Mercado  marketThree=new Mercado("USB3", 12.0, "10/01/2019", "8:35");
		Mercado  marketFour=new Mercado("USB4", 16.0, "09/01/2019", "10:35");
		Mercado marketFive=new Mercado("USB5", 20.0, "01/01/2019", "3:35");
        treeRB.insertar(marketOne.getValor(), marketOne);
        treeRB.insertar(marketTwo.getValor(), marketTwo);
        treeRB.insertar(marketThree.getValor(), marketThree);
        treeRB.insertar(marketFour.getValor(), marketFour);
        treeRB.insertar(marketFive.getValor(), marketFive);
        double keyDelete=16.0;
        treeRB.eliminar(keyDelete);
        assertEquals(treeRB.darPeso(), 4);
        
	}
	
	@Test
	public void testSearch() {
		sceneOne();
		Mercado marketOne= new Mercado("USB1", 25.0, "11/01/2019", "9:45");
		Mercado marketTwo= new Mercado("USB2", 21.0, "12/01/2019", "8:45");
		Mercado marketThree=new Mercado("USB3", 12.0, "10/01/2019", "8:35");
		Mercado marketFour=new Mercado("USB4", 16.0, "09/01/2019", "10:35");
		Mercado marketFive=new Mercado("USB5", 20.0, "01/01/2019", "3:35");
        treeRB.insertar(marketOne.getValor(), marketOne);
        treeRB.insertar(marketTwo.getValor(), marketTwo);
        treeRB.insertar(marketThree.getValor(), marketThree);
        treeRB.insertar(marketFour.getValor(), marketFour);
        treeRB.insertar(marketFive.getValor(), marketFive);
        double keySearch=21.0;
        Mercado findNodeKey=treeRB.buscar(keySearch);
        assertEquals(findNodeKey.getValor(), keySearch);
		
	}
//	
//	
//	@Test
	public void testGetMaximum() {
		sceneOne();
		Mercado marketOne= new Mercado("USB1", 25.0, "11/01/2019", "9:45");
		Mercado marketTwo= new Mercado("USB2", 21.0, "12/01/2019", "8:45");
		Mercado marketThree=new Mercado("USB3", 12.0, "10/01/2019", "8:35");
		Mercado marketFour=new Mercado("USB4", 16.0, "09/01/2019", "10:35");
		Mercado marketFive=new Mercado("USB5", 20.0, "01/01/2019", "3:35");
        treeRB.insertar(marketOne.getValor(), marketOne);
        treeRB.insertar(marketTwo.getValor(), marketTwo);
        treeRB.insertar(marketThree.getValor(), marketThree); 
        treeRB.insertar(marketFour.getValor(), marketFour);
        treeRB.insertar(marketFive.getValor(), marketFive);
        double keySearch=25.0;
        Mercado maximium=treeRB.darMayor();
        
        assertEquals(maximium.getValor(), keySearch);
        
		
	}
//	
	@Test
	public void testGetMinimium() {
		sceneOne();
		Mercado marketOne= new Mercado("USB1", 25.0, "11/01/2019", "9:45");
		Mercado marketTwo= new Mercado("USB2", 21.0, "12/01/2019", "8:45");
		Mercado marketThree=new Mercado("USB3", 12.0, "10/01/2019", "8:35");
		Mercado marketFour=new Mercado("USB4", 16.0, "09/01/2019", "10:35");
		Mercado marketFive=new Mercado("USB5", 20.0, "01/01/2019", "3:35");
        treeRB.insertar(marketOne.getValor(), marketOne);
        treeRB.insertar(marketTwo.getValor(), marketTwo);
        treeRB.insertar(marketThree.getValor(), marketThree);
        treeRB.insertar(marketFour.getValor(), marketFour);
        treeRB.insertar(marketFive.getValor(), marketFive);
        double keySearch=12.0;
        Mercado minimium=treeRB.darMinimo();
        
        assertEquals(minimium.getValor(), keySearch);
        
		
	}
//	
	

}
