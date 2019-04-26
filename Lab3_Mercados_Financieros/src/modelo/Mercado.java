package modelo;

public class Mercado implements Comparable<Mercado>{

	public final static String DIVISA="Mercado de Divisa";
	public final static String CAPITAL="Mercado de Capital";

	
	private String nombre;
	private double valor;
	private String fecha;
	private String hora;
	
	////////////////sss///
	///&///
	
	public Mercado(String nombre, double precio, String fecha, String hora) {
		super();
		this.nombre = nombre;
		this.valor = precio;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double precio) {
		this.valor = precio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}




	@Override
	public int compareTo(Mercado o) {
		if(this.valor>o.getValor()) {
			return 1;
		}else if(this.valor<o.getValor()){
			return -1;
		}else {
			return 0;
		}
		// TODO Auto-generated method stu
	}
	


}
