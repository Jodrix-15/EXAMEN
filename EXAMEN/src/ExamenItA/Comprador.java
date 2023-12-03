package ExamenItA;

import java.util.ArrayList;

public class Comprador {
	
	private String nombre;
	private ArrayList<Item> itemsComprados;
	
	public Comprador(String nombre) {
		this.nombre = nombre;
		this.itemsComprados = new ArrayList<Item>();
	}
	
	public void mostrarInventario(ArrayList<Item> itemsComprados) {
		//con lambdas
		if (itemsComprados.size() > 0) {
			itemsComprados.forEach((item) ->System.out.println("- "+item.getNombre()));
		}else {
			System.out.println("\nInventario Vacio");
		}
		
	
	}
	public void aniadirItem(Item it){
		// TODO Auto-generated method stub
		this.itemsComprados.add(it);
		
		
	}

	public String getNombre() {
		return nombre;
	}


	public ArrayList<Item> getItemsComprados() {
		return itemsComprados;
	}

	
	
	
	
	

}
