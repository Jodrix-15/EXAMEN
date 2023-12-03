package ExamenItA;
import java.util.ArrayList;

abstract class Vendedor {
	
	protected String nombre;
	protected String tipo;
	protected ArrayList<Item> inventario;
	
	public Vendedor(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.inventario = new ArrayList<Item>();
	}
	
	public abstract double calcularPrecioConImpuesto(Item it);
	public abstract double deterioro(Item it);
	public abstract void aniadirItem(Item it) throws CapacidadInventarioException;
	
	public void mostrarInventario(ArrayList<Item> inventario) {
		//con lambdas
		if (inventario.size() > 0) {
			inventario.forEach((item) ->System.out.println("- "+item.getNombre()));
		}else {
			System.out.println("\nInventario Vacio");
		}
		
	
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

	public ArrayList<Item> getInventario() {
		return inventario;
	}

	public void setInventario(ArrayList<Item> inventario) {
		this.inventario = inventario;
	}
	
	
	
	


}
