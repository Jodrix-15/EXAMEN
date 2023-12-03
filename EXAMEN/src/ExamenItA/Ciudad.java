package ExamenItA;

import java.util.ArrayList;
import java.util.Objects;

public class Ciudad {
	
	private String nombre;
	private ArrayList<Comprador> compradores;
	private ArrayList<Vendedor> vendedores;
	
	public Ciudad(String nombre) {
		this.nombre = nombre;
		this.compradores = new ArrayList<Comprador>();
		this.vendedores = new ArrayList<Vendedor>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Comprador> getCompradores() {
		return compradores;
	}

	public ArrayList<Vendedor> getVendedores() {
		return vendedores;
	}
	
	public void addComprador(Comprador c) {
		this.compradores.add(c);
		
	}
	
	public void addVendedor(Vendedor v) {
		this.vendedores.add(v);
	}

	
	

}
