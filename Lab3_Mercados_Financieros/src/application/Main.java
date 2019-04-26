package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import modelo.Mercado;
import modelo.MercadoFinanciero;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static MercadoFinanciero mf= new MercadoFinanciero();

	public Main() {
//		mf=new MercadoFinanciero();
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Vista.fxml"));
			Scene scene = new Scene(root,327,357);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);

	//	mf.agregarDatos("archivos/prueba.txt");
	//	mf.preorden();
	//	mf.precioAltoArboRyN("1/03/2019", "5/03/2019");
		
//		mf.agregarDatosaVL();
//		ArrayList a=mf.getAvl().inorder_tree_walk2();
//		for (int i = 0; i < a.size(); i++) {
//		System.out.println(	a.get(i));
		
	}

	
	
	public void agregarDatos(String url) {
		mf.agregarDatos(url);
	}
	
	public void agregarDatosAvl(String url) {
		mf.agregarDatosAVL(url);
	}

	public MercadoFinanciero getMercadofinanciero() {
		return mf;
	}

	public void setMercadofinanciero(MercadoFinanciero mf) {
		this.mf = mf;
	}
	
	
	
}
