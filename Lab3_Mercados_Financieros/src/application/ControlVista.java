package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

public class ControlVista implements Initializable {

	 @FXML 
	private Button btnBuscar;
	 @FXML 
	private TextField direccion;
	 @FXML 
	private ToggleGroup tipoMercado;
	 @FXML 
		private RadioButton MercadoDivisa; 
	 @FXML 
		private RadioButton MercadoAccion;
	 @FXML 
		private DatePicker de; 
	 @FXML 
		private DatePicker hasta;
	 
	 @FXML 
		private Label pAlto;
	 @FXML 
		private Label pBajo;
	 @FXML 
		private Label PeriodoMC;
	 
	 @FXML 
		private Pane inicio;
	 @FXML 
		private Pane info;
	 
	 
	 private Main main;
	 
	 public ControlVista() {
		 main=new Main();
	 }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		   btnBuscar.setOnAction(event -> {
		        FileChooser fileChooser = new FileChooser();
		        fileChooser.setTitle("Buscar Archivo de Mercados");

		        // Agregar filtros para facilitar la busqueda
		        fileChooser.getExtensionFilters().addAll(
		                new FileChooser.ExtensionFilter("TXT", "*.txt")
		        );

		        // Obtener la imagen seleccionada
		        File f = fileChooser.showOpenDialog(null);

		        // Mostar la imagen
		        if (f != null) {
		          direccion.setText(f.getAbsolutePath()+"");
		        }
		       
		    });		
	}
	
	public void botonMostrarInformacion() {
	try {
			if(tipoMercado.getSelectedToggle().equals(MercadoDivisa)) {
		          main.agregarDatosAvl(direccion.getText());
		 	     System.out.println("entra 3");


			}
			if(tipoMercado.getSelectedToggle().equals(MercadoAccion)) {
				
				main.agregarDatos(direccion.getText());
			     System.out.println("entra 4");

			}	
		}
	
	catch(Exception e) {
		if(direccion.getText().equals(""))	{
			Alert a=new Alert(AlertType.ERROR);
			a.setContentText("Primero debe agregar los datos");
			a.showAndWait();
		}


	}
	
	}

	public void informacionDivisa() {
		try {
			System.out.println(tipoMercado.getSelectedToggle().toString());

			
			info.setVisible(true);
			inicio.setVisible(false);
			
		String desde=de.getValue().getDayOfMonth()+"/"
					+de.getValue().getMonthValue()+"/"
					+de.getValue().getYear();
		String hasta1=hasta.getValue().getDayOfMonth()+"/"
				+hasta.getValue().getMonthValue()+"/"
				+hasta.getValue().getYear();
		System.out.println(tipoMercado.getSelectedToggle().toString());
//		if(tipoMercado.getSelectedToggle().equals(MercadoDivisa)) {
//	     //main.getMercadofinanciero().getArbolDivisa().recorrerArbolRango(desde, hasta1);
//	     System.out.println("entra 1 nooo");
//		}
//		if(tipoMercado.getSelectedToggle().equals(MercadoAccion)) {
//			
			editarInformacion(desde, hasta1);
		     System.out.println("entra 2");

		
		
		
		}
		
		catch(Exception e) {
			
		}
		
		
	}
	
	
	public void editarInformacion(String i,String f) {
		System.out.println("Entro aca maldita sea");
		System.out.println(main.getMercadofinanciero().consultarPrecioMasBajoAccion(i,f));
		pAlto.setText("entraaa");
		pAlto.setText(main.getMercadofinanciero().consultarPrecioMasRangoFecha(i, f)+"");
		pBajo.setText(main.getMercadofinanciero().consultarPrecioMasBajoAccion(i, f)+"");
		System.out.println(main.getMercadofinanciero().consultarPrecioMasRangoFecha(i, f)+"");
	}
	
}
