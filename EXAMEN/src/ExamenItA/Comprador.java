package ExamenItA;

import java.util.ArrayList;

public class Comprador {
	
	private String nombre;
	private String ciudad;
	private ArrayList<Item> itemsComprados;
	
	public Comprador(String nombre, String ciudad) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.itemsComprados = new ArrayList<Item>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public ArrayList<Item> getItemsComprados() {
		return itemsComprados;
	}

	public void setItemsComprados(ArrayList<Item> itemsComprados) {
		this.itemsComprados = itemsComprados;
	}
	
	
	
	

}
