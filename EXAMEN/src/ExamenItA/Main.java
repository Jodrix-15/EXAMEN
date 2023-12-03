package ExamenItA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		ArrayList<Item> itemListCopy = new ArrayList<Item>();
		ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
		ArrayList<Comprador> compradores = new ArrayList<Comprador>();
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		Datos d = new Datos();
		
		d.loadItems();
		d.loadCiudades();
		d.loadVendedoresCompradores();
		d.loadInventarioVendedoresCompradores();
		
		ciudades = d.getCiudades();
		itemList = d.getItemList();
		itemListCopy = itemList;
		
		ciudades.forEach((ciu) -> ciu.getVendedores().forEach((vend) -> vendedores.add(vend)));
		ciudades.forEach((ciu) -> ciu.getCompradores().forEach((comp) -> compradores.add(comp)));
		inicio(compradores, vendedores, itemList, ciudades);

	}

	public static void menu() {
		System.out.println("\nDel siguiente menu: \n"
				+ "\n[1]. Crear Vendedor\n"
				+ "[2]. A�adir item al inventario del vendedor\n"
				+ "[3]. Mostrar el item mas barato de todos los vendedores de una ciudad\n"
				+ "[4]. Consultar los items de un vendedor\n"
				+ "[5]. Crear comprador\n"
				+ "[6]. Realiza la compra de un item\n"
				+ "[7]. Consultar los items de un Comprador\n"
				+ "[8]. Consultar todos los vendedores que hay en una ciudad\n"
				+ "[9]. Consultar todos los compradores que hay una ciudad\n"
				+ "[10]. Mostrar todos los items de un determinado tipo ordenados por precio (asc)\n"
				+ "[0]. Finalizar\n ");
	}
	
	public static void inicio(ArrayList<Comprador> compradores, ArrayList<Vendedor> vendedores, ArrayList<Item> itemList, ArrayList<Ciudad> ciudades) {
		int opcion=-1;
		boolean numValido = false;
		boolean itemValido = false;
		int opcionComprador;
		int opcionVendedor;
		int opcionCiudad;
		int opcionItem;
		Ciudad c;
		Vendedor vend;
		Comprador comp;
		Item it;
		
		while (opcion != 0){
			menu();
			
			do {
				try {
					opcion = getInt("Escoge una opcion: ");
					
					while (opcion < 0 || opcion > 10){
						opcion = getInt("Escoge una opcion. (Recuerda que debe ser un numero de entre las posibles opciones del menu): ");
					}
					numValido = true;
					
				}catch(InputMismatchException e) {
					System.out.println("ERROR. Debes escribir un n�mero entero");
					numValido = false;
				}
			}while (numValido == false);
				try {
					switch (opcion) {
					
						case 1:
							crearVendedor(vendedores);
							break;
						case 2:
							aniadirItemVendedor(vendedores, itemList);
							break;
						case 3:
							System.out.println("\nCiudades: ");
							for (int i= 0; i < ciudades.size(); i++) {
								System.out.println((i+1)+". "+ciudades.get(i).getNombre());
							}
							opcionCiudad = getInt("\nElige la ciudad para mostra los items mas baratos de los vendedores: ");
							c = ciudades.get(opcionCiudad-1);
							mostrarItemsMasBaratoVendedoresCiudad(c);
			
							break;
						case 4:
							mostrarVendedores("\nDe los siguientes vendedores: \n", vendedores);
							opcionVendedor = getInt("\nElige al vendedor cuyo inventario quieres consultar: ");
							vend = vendedores.get(opcionVendedor-1);
							vend.mostrarInventario(vend.getInventario());
							break;
						case 5:
							crearComprador(compradores);
							break;
						case 6:
							
							mostrarCompradores("\nQuien esta realizando la compra?: ", compradores);
							opcionComprador = getInt("Escoge el comprador: ");
							comp = compradores.get(opcionComprador-1);
							
							
							mostrarVendedores("\nA quien le esta comprando?: ", vendedores);
							opcionVendedor = getInt("Escoge al vendedor: ");
							vend = vendedores.get(opcionVendedor-1);
							realizarCompra(comp, vend);
							break;
						case 7:
							mostrarCompradores("\nDe los siguientes vendedores: \n", compradores);
							opcionComprador = getInt("\nElige al comprador cuyos items quieres consultar: ");
							comp = compradores.get(opcionComprador-1);
							comp.mostrarInventario(comp.getItemsComprados());
							break;
						case 8:
							System.out.println("\nCiudades: ");
							for (int i= 0; i < ciudades.size(); i++) {
								System.out.println((i+1)+". "+ciudades.get(i).getNombre());
							}
							opcionCiudad = getInt("\nElige la ciudad cuyos vendedores quieres consultar: ");
							c = ciudades.get(opcionCiudad-1);
							vendedoresCiudad(c);
							break;
						case 9:
							System.out.println("\nCiudades: ");
							for (int i= 0; i < ciudades.size(); i++) {
								System.out.println((i+1)+". "+ciudades.get(i).getNombre());
							}
							opcionComprador = getInt("\nElige la ciudad cuyos compradores quieres consultar: ");
							c = ciudades.get(opcionComprador-1);
							compradoresCiudad(c);
							break;
						case 10:
							filtrarTipoAsc(itemList);
							break;
					}
				}catch(IndexOutOfBoundsException e) {
					System.out.println("Opcion no valida");
				}
			}
		}
		public static void crearVendedor(ArrayList<Vendedor> vendedores) {
			String tipoVendedor = "";
			do {
				 tipoVendedor = getString("Que tipo de vendedor quieres crear [C]ampesino, [L]adron, [M]ercader?: ");
			}while(!tipoVendedor.equalsIgnoreCase("M") && !tipoVendedor.equalsIgnoreCase("C") && !tipoVendedor.equalsIgnoreCase("L"));
			
			switch(tipoVendedor) {
			case "M":
				Mercader merc = new Mercader(getString("Nombre Comprador: "), "Mercader");
				vendedores.add(merc);
				break;
			case "L":
				Ladron ldrn = new Ladron(getString("Nombre Comprador: "), "Ladron");
				vendedores.add(ldrn);
				break;
			case "C":
				Campesino camp = new Campesino(getString("Nombre Comprador: "), "Campesino");
				vendedores.add(camp);
				break;
			}
		
		

	}
	
	
	public static void aniadirItemVendedor(ArrayList<Vendedor> vendedores, ArrayList<Item> itemList)  {
		if(vendedores.size() > 0) {
			System.out.println("De los siguientes items: \n");
			mostrarItems(itemList);
			int opcionItem = getInt("\nCual deseas aniadir al vendedor?: ");
			Item objeto = itemList.get(opcionItem-1);
			
			
			mostrarVendedores("\nDe los siguientes vendedores: \n", vendedores);
			int opcionVendedor = getInt("\nA cual le quieres aniadir el item?: ");
			System.out.println();
			
			
			Vendedor vendedor = vendedores.get(opcionVendedor-1);
			
			
			if (vendedor.getTipo().equalsIgnoreCase("campesino")) {
				Campesino camp = (Campesino) vendedor;
				try {
					camp.aniadirItem(objeto);
				}catch (CapacidadInventarioException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Item anyadido correctamente\n");
			}
				
			else if(vendedor.getTipo().equalsIgnoreCase("mercader")) {
				Mercader merc = (Mercader) vendedor;
				try {
					merc.aniadirItem(objeto);
				}catch(CapacidadInventarioException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Item anyadido correctamente\n");
		
			}
	
			else if(vendedor.getTipo().equalsIgnoreCase("ladron")) {
				Ladron ldrn = (Ladron) vendedor;
				try {
					ldrn.aniadirItem(objeto);
				}catch(CapacidadInventarioException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Item anyadido correctamente\n");
			}
		}
		else {
			System.out.println("No se han anyadido vendedores");
		}

	}
	public static void vendedoresCiudad(Ciudad c) {
		ArrayList<Vendedor> vendedores = c.getVendedores();
		
		vendedores.forEach((v) -> System.out.println(v.getNombre()));
	}
	
	public static void compradoresCiudad(Ciudad c) {
		ArrayList<Comprador> compradores = c.getCompradores();
		
		compradores.forEach((ci) -> System.out.println(ci.getNombre()));
		
	}
	
	public static void crearComprador(ArrayList<Comprador> compradores) {
		Comprador compr = new Comprador(getString("Nombre: "));
		compradores.add(compr);
		
	}
	
	public static void mostrarVendedores(String frase, ArrayList<Vendedor> vendedores) {
		int i = 1;
		System.out.println(frase);
		for(Vendedor v : vendedores) {
			System.out.println(i+". "+ v.getNombre()+"\t"+v.getTipo());
			i++;
		}
	}
	
	public static void mostrarCompradores(String frase, ArrayList<Comprador> compradores) {
		int i = 1;
		System.out.println(frase);
		for(Comprador c : compradores) {
			System.out.println(i+". "+ c.getNombre());
			i++;
		}
	}
	
	public static void mostrarItems(ArrayList<Item> itemList) {
		int i = 1;
		for(Item it : itemList) {
			System.out.println(i+". "+it.getNombre()+"\t"+it.getTipo()+"\t"+it.getPrecio());
			i++;
		}
		
	}
	
	public static void mostrarItemsMasBaratoVendedoresCiudad(Ciudad c) {
		c.getVendedores().forEach((v) -> System.out.println(v.getInventario().stream().min((it1, it2) -> Double.compare(it1.getPrecio(), it2.getPrecio())).get().getNombre()));

	}
	
	public static void realizarCompra(Comprador comp, Vendedor vend) {
		Item it;
		boolean opcionValida = false;

		System.out.println(String.format("El vendedor %s tiene los siguientes items: ", vend.getNombre()));
		mostrarItems(vend.getInventario());
		while (opcionValida == false);
		try {
			int opcionItem = getInt("\nQue item quieres comprar?: ");
			it = vend.getInventario().get(opcionItem-1);
			vend.getInventario().remove(it);
			comp.aniadirItem(it);
			
			opcionValida = true;
		}catch(IndexOutOfBoundsException e) {
			System.out.println("\nOpcion no valida");
		}

		
	}
	
	public static void filtrarTipoAsc(ArrayList<Item> itemList) {
		ArrayList<String> tipos = new ArrayList<String>();
		
		System.out.println("\nTipos de items: ");
		for (int i= 0; i < itemList.size(); i++) {
			String tipo = itemList.get(i).getTipo();
			if (!tipos.contains(tipo)) {
				System.out.println("- "+tipo);
				tipos.add(tipo);
			}
		}
		final String tipoItem = getString("\nEscribe el tipo: ");
		
		List<Item> nuevaItemList = itemList.stream().filter(it -> it.getTipo().equalsIgnoreCase(tipoItem)).sorted(Comparator.comparing(Item::getPrecio)).collect(Collectors.toList());
		
		nuevaItemList.forEach(it -> System.out.println(it.getNombre()+ "   \t"+ it.getTipo()+"\t"+ it.getPrecio()+"\t"+it.getUsabilidad()));
	
	}
	
	public static void crearItem(ArrayList<Item> itemList) {
		Item item = new Item(getString("Nombre Item: "), getString("Tipo: "), getDouble("Precio: "));
		itemList.add(item);
	}
	
	public static Scanner input() {
		return new Scanner(System.in);
	}
	
	public static int getInt(String msj) {
		System.out.print(msj);
		Object obj = input().nextInt();
		int objInt = (int) obj;
		return objInt;

	}
	
	public static double getDouble(String msj) {
		System.out.print(msj);
		Object obj = input().nextDouble();
		double objInt = (double) obj;
		return objInt;
	}
	
	public static String getString(String msj) {
		System.out.print(msj);

		return input().nextLine();
	}

}
