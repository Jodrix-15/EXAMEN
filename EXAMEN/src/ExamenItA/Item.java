package ExamenItA;

import java.util.Objects;

public class Item {
	
	private String nombre;
	private String tipo;
	private double precio;
	private double usabilidad;
	
	public Item(String nombre, String tipo, double precio) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.usabilidad = 100;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	

	public double getUsabilidad() {
		return usabilidad;
	}

	public void setUsabilidad(double usabilidad) {
		this.usabilidad = usabilidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	

}
