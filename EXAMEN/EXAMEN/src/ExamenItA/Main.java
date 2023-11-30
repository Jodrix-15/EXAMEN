package ExamenItA;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcion=-1;
		boolean numValido = false;
		boolean itemValido = false;
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		ArrayList<Comprador> compradores = new ArrayList<Comprador>();
		
		itemList.add(new Item("Pocion         ", "Salud", 5));
		itemList.add(new Item("Cota Malla     ", "def.", 3));
		itemList.add(new Item("Guantalete   ", "def.", 2));
		itemList.add(new Item("Espadon mortal", "armas", 20));
		itemList.add(new Item("Cuchillas del caos", "armas", 30));
		itemList.add(new Item("Llave espada    ", "armas", 17));
		itemList.add(new Item("cinturon apretado", "def.", 2));
		itemList.add(new Item("pocion magica", "mana", 5));
		itemList.add(new Item("caramelo      ", "exp", 5));
			
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
					System.out.println("ERROR. Debes escribir un número entero");
					numValido = false;
				}
			}while (numValido == false);
			
			switch (opcion) {
			case 1:
				crearVendedor(vendedores);
				break;
			case 2:
				aniadirItemVendedor(vendedores, itemList);
				break;
			case 3:
				System.out.println("3");
				break;
			case 4:
				mostrarVendedores("\nDe los siguientes vendedores: \n", vendedores);
				int opcionVendedor = getInt("\nElige al vendedor cuyo inventario quieres consultar: ");
				Vendedor vend = vendedores.get(opcionVendedor-1);
				vend.mostrarInventario(vend.getInventario());
				break;
			case 5:
				crearComprador(compradores);
				break;
			case 6:
				System.out.println("6");
				break;
			case 7:
				mostrarCompradores("\nDe los siguientes vendedores: \n", compradores);
				int opcionComprador = getInt("\nElige al comprador cuyos items quieres consultar: ");
				Comprador comp = compradores.get(opcionComprador-1);
				comp.mostrarInventario(comp.getItemsComprados());
				break;
			case 8:
				System.out.println("8");
				break;
			case 9:
				System.out.println("9");
				break;
			case 10:
				System.out.println("10");
				break;
			}
		}

	}

	
	public static void menu() {
		System.out.println("\nDel siguiente menu: \n"
				+ "\n[1]. Crear Vendedor\n"
				+ "[2]. Añadir item al inventario del vendedor\n"
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
	
	public static void crearComprador(ArrayList<Comprador> compradores) {
		Comprador compr = new Comprador(getString("Nombre: "), getString("Ciudad: "));
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
			System.out.println(i+". "+ c.getNombre()+"\t"+c.getCiudad()  );
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
	
	public static void realizarCompra(ArrayList<Vendedor> vendedores, ArrayList<Comprador> compradores) {
		
		mostrarCompradores("De los siguientes compradores: ", compradores);
		int opcionComprador = getInt("Quien esta realizando la compra?: ");
		Comprador comp = compradores.get(opcionComprador-1);
		
		mostrarVendedores("A qué vendedor le quieres comprar?: ", vendedores);
		int opcionVendedor = getInt("Escoge una opcion: ");
		Vendedor vend = vendedores.get(opcionVendedor-1);
		
		System.out.println(String.format("El vendedor %s tiene los siguientes items: ", vend.getNombre()));
		mostrarItems(vend.getInventario());
		
		
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
