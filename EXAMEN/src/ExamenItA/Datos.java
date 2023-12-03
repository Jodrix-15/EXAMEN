package ExamenItA;

import java.util.ArrayList;
import java.util.TreeSet;

public class Datos {
	
	private ArrayList<Ciudad> ciudades;
	private ArrayList<Item> itemList;
	
	public Datos() {
		this.ciudades = new ArrayList<Ciudad>();
		this.itemList = new ArrayList<Item>();
	}
	public void loadItems() {
		itemList.add(new Item("Pocion         ", "Salud", 5));
		itemList.add(new Item("Cota Malla     ", "def.", 3));
		itemList.add(new Item("Guantalete   ", "def.", 2));
		itemList.add(new Item("Espadon mortal", "armas", 20));
		itemList.add(new Item("Cuchillas del caos", "armas", 30));
		itemList.add(new Item("Llave espada    ", "armas", 17));
		itemList.add(new Item("cinturon apretado", "def.", 2));
		itemList.add(new Item("pocion magica", "mana", 5));
		itemList.add(new Item("caramelo      ", "exp", 5));
	}
	
	public void loadCiudades() {
		ciudades.add(new Ciudad("Barcelona"));
		ciudades.add(new Ciudad("Madrid"));
		ciudades.add(new Ciudad("Valencia"));
		
	}
	
	public void loadVendedoresCompradores() {
		for(Ciudad c: ciudades) {
			if (c.getNombre().equalsIgnoreCase("Barcelona")){
				c.addVendedor(new Campesino("Jodrix", "Campesino"));
				c.addVendedor(new Ladron("Carlos", "Ladron"));
				c.addVendedor(new Mercader("Ana  ", "Mercader"));
				
				c.addComprador(new Comprador("Valentina"));
				c.addComprador(new Comprador("David"));
				c.addComprador(new Comprador("Maria"));
			}
			if (c.getNombre().equalsIgnoreCase("Madrid")){
				c.addVendedor(new Campesino("Lorena", "Campesino"));
				c.addVendedor(new Ladron("Kris  ", "Ladron"));
				c.addVendedor(new Mercader("Juan  ", "Mercader"));
				
				c.addComprador(new Comprador("Pedro"));
				c.addComprador(new Comprador("Sandra"));
				c.addComprador(new Comprador("Abril"));
			}
			if (c.getNombre().equalsIgnoreCase("Valencia")){
				c.addVendedor(new Campesino("Santi", "Campesino"));
				c.addVendedor(new Ladron("Alex  ", "Ladron"));
				c.addVendedor(new Mercader("Hector", "Mercader"));
				
				c.addComprador(new Comprador("Javi"));
				c.addComprador(new Comprador("Ivan"));
				c.addComprador(new Comprador("Jose"));
			}
		}
	}
	
	public void loadInventarioVendedoresCompradores() {
		for (Ciudad c:ciudades) {
			if (c.getNombre().equalsIgnoreCase("Barcelona")) {
				for (Vendedor v: c.getVendedores()) {
					try {
						v.aniadirItem(itemList.get(0));
						v.aniadirItem(itemList.get(1));
						v.aniadirItem(itemList.get(2));
							
					}catch(CapacidadInventarioException e) {
						System.out.println(e.getMessage());
					}
					
				}
				for (Comprador co: c.getCompradores()) {
					
					co.aniadirItem(itemList.get(0));
					co.aniadirItem(itemList.get(1));
					co.aniadirItem(itemList.get(2));		
				}
			}
			if (c.getNombre().equalsIgnoreCase("Madrid")) {
				for (Vendedor v: c.getVendedores()) {
					try {
						v.aniadirItem(itemList.get(3));
						v.aniadirItem(itemList.get(4));
						v.aniadirItem(itemList.get(5));
							
					}catch(CapacidadInventarioException e) {
						System.out.println(e.getMessage());
					}
					
				}
				for (Comprador co: c.getCompradores()) {
					
					co.aniadirItem(itemList.get(3));
					co.aniadirItem(itemList.get(4));
					co.aniadirItem(itemList.get(5));		
				}
			}
			if (c.getNombre().equalsIgnoreCase("Valencia")) {
				for (Vendedor v: c.getVendedores()) {
					try {
						v.aniadirItem(itemList.get(6));
						v.aniadirItem(itemList.get(7));
						v.aniadirItem(itemList.get(8));
							
					}catch(CapacidadInventarioException e) {
						System.out.println(e.getMessage());
					}
					
				}
				for (Comprador co: c.getCompradores()) {
					
					co.aniadirItem(itemList.get(6));
					co.aniadirItem(itemList.get(7));
					co.aniadirItem(itemList.get(8));		
				}
			}
		}
	}
	public ArrayList<Ciudad> getCiudades() {
		return ciudades;
	}
	public void setCiudades(ArrayList<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
	
	
	
	
	

}
