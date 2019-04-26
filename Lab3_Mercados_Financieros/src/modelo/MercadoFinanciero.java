package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import arbolRojoNegro.ArbolRojoNegro;
import arbol_Avl.BNode;
import arbol_Avl.BTree;

public class MercadoFinanciero {

	private ArbolRojoNegro<String,Mercado> arbolDivisa;
	private BTree<String,Mercado> avl;


	
	/**
	 * Constructor
	 */
	public MercadoFinanciero() {
		arbolDivisa = new ArbolRojoNegro<>();
		avl= new BTree<>();

	}
	
	

	
	public void agregarDatos(String url) {
		File f=new File(url);
		
		try {
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String linea="";
			
			while((linea=br.readLine())!=null) {
				String datos[]=linea.split(", ");
				String fecha[]=datos[1].split(" ");

				
				Mercado nuevo=new Mercado(datos[0], Double.parseDouble(datos[2]),fecha[0], fecha[1]);
				
				this.arbolDivisa.insertar(nuevo.getFecha(), nuevo);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public double precioAltoArboRyN(String de,String hasta) {
		this.arbolDivisa.recorrerArbolRango(de, hasta);
		return 0;
	}
	

	public ArbolRojoNegro getArbolDivisa() {
		System.out.println("Entra 2");
		return arbolDivisa;
	}


	public void setArbolDivisa(ArbolRojoNegro arbolDivisa) {
		this.arbolDivisa = arbolDivisa;
	}
	
	public void preorden() {
		arbolDivisa.darPreorden();
	}
	
	///----------------------------------arbol Avl---------------------------------------}


	

	

	public  void agregarDatosAVL(String direccion) {
		File f = new File (direccion);//Carga el archivo

		
		try {
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String linea="";
			while((linea=br.readLine())!=null) {
				String datos[]=linea.split(", ");
				String fechaHora[]=datos[1].split(" ");				
				String fecha=fechaHora[0];
				String hora=fechaHora[1];
				Mercado mercadito= new Mercado(datos[0],Double.parseDouble(datos[2]) , fecha, hora);
				
				
				
			this.avl.insert(mercadito.getFecha(), mercadito);	
			
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	public BTree<String, Mercado> getAvl() {
		return avl;
	}



	public void setAvl(BTree<String, Mercado> avl) {
		this.avl = avl;
	}




	public  double consultarPrecioMasRangoFecha(String fechaInicial,String fechaFinal) {
		String fechaInicial2[]=fechaInicial.split("/");
		String fechaFinal2[]=fechaFinal.split("/");
		int num1I=Integer.parseInt(fechaInicial2[0]);
		int num2I=Integer.parseInt(fechaInicial2[1]);
		int num3I=Integer.parseInt(fechaInicial2[2]);
		
		int num1F=Integer.parseInt(fechaFinal2[0]);
		int num2F=Integer.parseInt(fechaFinal2[1]);
		int num3F=Integer.parseInt(fechaFinal2[2]);
		
		
int fechaini=num1I+num2I+num3I;
int fechaFi=num1F+num2F+num3F;
		

	 	   ArrayList<Mercado> mercados= new ArrayList<>(); 

		
		 ArrayList<BNode> nodos= this.avl.inorder_tree_walk2();
	       for(int i=0;i<nodos.size();i++) {
	     	   Mercado mercad= (Mercado) nodos.get(i).getValue();
	     	   String miFecha[]=mercad.getFecha().split("/");
//	     	   String miFecha2=miFecha[0]+miFecha[1]+miFecha[2];
	     	  
	     		int num1f=Integer.parseInt(miFecha[0]);
	    		int num2f=Integer.parseInt(miFecha[1]);
	    		int num3f=Integer.parseInt(miFecha[2]);
	    		
	    		int miFecha2=num1f+num2f+num3f;

	     	   
	    		 if(miFecha2>=fechaini&&miFecha2<=fechaFi) {
		     		   System.out.println("Entro");
		     		   mercados.add(mercad);
		     	   }
	     	   
	       }
	       
	       BTree<Double, Mercado> avlAuxiliar2= new BTree<>();
	       for(int i=0;i<mercados.size();i++) {
	    	   avlAuxiliar2.insert(mercados.get(i).getValor(), mercados.get(i));
	       }
	       
	       double precioMayor=avlAuxiliar2.maximum(avlAuxiliar2.getRoot()).getKey();
	       
			
	return  precioMayor;	
	}

	
	
	
public double consultarPrecioMasBajoAccion(String fechaInicial,String fechaFinal) {
		
		String fechaInicial2[]=fechaInicial.split("/");
		String fechaFinal2[]=fechaFinal.split("/");
		int num1I=Integer.parseInt(fechaInicial2[0]);
		int num2I=Integer.parseInt(fechaInicial2[1]);
		int num3I=Integer.parseInt(fechaInicial2[2]);
		
		int num1F=Integer.parseInt(fechaFinal2[0]);
		int num2F=Integer.parseInt(fechaFinal2[1]);
		int num3F=Integer.parseInt(fechaFinal2[2]);
		
		
int fechaini=num1I+num2I+num3I;
int fechaFi=num1F+num2F+num3F;
		

	 	   ArrayList<Mercado> mercados= new ArrayList<>(); 

		
		 ArrayList<BNode> nodos= this.avl.inorder_tree_walk2();
	       for(int i=0;i<nodos.size();i++) {
	     	   Mercado mercad= (Mercado) nodos.get(i).getValue();
	     	   String miFecha[]=mercad.getFecha().split("/");	     	  
	     		int num1f=Integer.parseInt(miFecha[0]);
	    		int num2f=Integer.parseInt(miFecha[1]);
	    		int num3f=Integer.parseInt(miFecha[2]);
	    		
	    		int miFecha2=num1f+num2f+num3f;

	     	   
	    		 if(miFecha2>=fechaini&&miFecha2<=fechaFi) {
		     		   mercados.add(mercad);
		     	   }
	       }
	       
	       BTree<Double, Mercado> avlAuxiliar2= new BTree<>();
	       System.out.println(mercados.size()+"Total");
	       for(int i=0;i<mercados.size();i++) {
	    	   avlAuxiliar2.insert(mercados.get(i).getValor(), mercados.get(i));
	       }
	       
	       double precioMenor=avlAuxiliar2.minimum(avlAuxiliar2.getRoot()).getKey();
	       
			
	return  precioMenor;
		
	}
	
public ArrayList<Mercado> accionesSuperanValor(double valor, String fechaInicial,String fechaFinal) {
	

	
	String fechaInicial2[]=fechaInicial.split("/");
	String fechaFinal2[]=fechaFinal.split("/");
	int num1I=Integer.parseInt(fechaInicial2[0]);
	int num2I=Integer.parseInt(fechaInicial2[1]);
	int num3I=Integer.parseInt(fechaInicial2[2]);
	
	int num1F=Integer.parseInt(fechaFinal2[0]);
	int num2F=Integer.parseInt(fechaFinal2[1]);
	int num3F=Integer.parseInt(fechaFinal2[2]);
	
	
    int fechaini=num1I+num2I+num3I;
     int fechaFi=num1F+num2F+num3F;
 	   ArrayList<Mercado> mercados= new ArrayList<>(); 
 	  ArrayList<BNode> nodos= this.avl.inorder_tree_walk2();
       for(int i=0;i<nodos.size();i++) {
     	   Mercado mercad= (Mercado) nodos.get(i).getValue();
     	   String miFecha[]=mercad.getFecha().split("/");	     	  
     		int num1f=Integer.parseInt(miFecha[0]);
    		int num2f=Integer.parseInt(miFecha[1]);
    		int num3f=Integer.parseInt(miFecha[2]);
    		
    		int miFecha2=num1f+num2f+num3f;

     	   
    		 if(miFecha2>=fechaini&&miFecha2<=fechaFi) {
    			 if(mercad.getValor()>=valor) {
		     		   mercados.add(mercad);

    			 }
	     	   }
       }
       
       
       return mercados;
}


public ArrayList<Mercado> tresAccionesMayorCrecimiento(String fechaInicial,String fechaFinal) {
    Queue<Mercado> colaPriority = new PriorityQueue<Mercado>();

    String fechaInicial2[]=fechaInicial.split("/");
	String fechaFinal2[]=fechaFinal.split("/");
	int num1I=Integer.parseInt(fechaInicial2[0]);
	int num2I=Integer.parseInt(fechaInicial2[1]);
	int num3I=Integer.parseInt(fechaInicial2[2]);
	
	int num1F=Integer.parseInt(fechaFinal2[0]);
	int num2F=Integer.parseInt(fechaFinal2[1]);
	int num3F=Integer.parseInt(fechaFinal2[2]);
	
	
    int fechaini=num1I+num2I+num3I;
     int fechaFi=num1F+num2F+num3F;
     
		BTree<Double, Mercado> treeDouble= new BTree<>();
	 ArrayList<BNode> nodos= this.avl.inorder_tree_walk2();
       for(int i=0;i<nodos.size();i++) {
     	   Mercado mercad= (Mercado) nodos.get(i).getValue();
     	   String miFecha[]=mercad.getFecha().split("/");	     	  
     		int num1f=Integer.parseInt(miFecha[0]);
    		int num2f=Integer.parseInt(miFecha[1]);
    		int num3f=Integer.parseInt(miFecha[2]);
    		
    		int miFecha2=num1f+num2f+num3f;

     	   
    		 if(miFecha2>=fechaini&&miFecha2<=fechaFi) {
    			colaPriority.offer(mercad);
	     		   treeDouble.insert(mercad.getValor(), mercad);

	     	   }
       }
       ArrayList<BNode<Double, Mercado>> mercados= treeDouble.arrayMaximus(treeDouble.getRoot());
       for(int i=0;i<mercados.size();i++) {
    	  colaPriority.add(mercados.get(i).getValue());
       }
       
     
       System.out.println(colaPriority.size());
       ArrayList<Mercado> tresMercados= new ArrayList<>();
       int contador=0;
       while(contador<3) {
	     
			tresMercados.add(colaPriority.poll());
			contador++;
		   }

       
return tresMercados;

   	

}




}