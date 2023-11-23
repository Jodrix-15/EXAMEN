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
		
		
		int numItems = -1;
		do {
			try {
				numItems = getInt("Cuantos items quieres tener en la base de datos?: ");
				itemValido = true;
			}catch(InputMismatchException e) {
				System.out.println("ERROR. Debes escribir un número entero");
				itemValido = false;
			}
			
		}while(itemValido == false);
		
		if (numItems > 0) {
			for(int i = 0; i<numItems; i++) {
				crearItem(itemList);
			}
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
					try {
						aniadirItemVendedor(vendedores, itemList);
					}catch(CapacidadInventarioException e) {
						e.getMessage();
					}
					
					break;
				case 3:
					System.out.println("3");
					break;
				case 4:
					System.out.println("4");
					break;
				case 5:
					crearComprador(compradores);
					break;
				case 6:
					System.out.println("6");
					break;
				case 7:
					System.out.println("7");
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
		}else {
			System.out.println("Es necesario crear una base de datos para los items antes de ejecutar el programa\n");
		}
	
	}
	
	public static void menu() {
		System.out.println("Del siguiente menu: \n"
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
	
	public static void buscarItem() {}
	public static void buscarComprador() {}
	
	public static void realizarCompra() {
		
	}
	
	public static void aniadirItemVendedor(ArrayList<Vendedor> vendedores, ArrayList<Item> itemList) throws CapacidadInventarioException {
		System.out.println("De los siguientes items: \n");
		mostrarItems(itemList);
		int opcionItem = getInt("\nCual deseas aniadir al vendedor?: ");
		
		System.out.println("\nDe los siguientes vendedores: ");
		mostrarVendedores(vendedores);
		int opcionVendedor = getInt("A cual le quieres aniadir el item?: ");
		System.out.println();
		
		Item objeto = itemList.get(opcionItem-1);
		Vendedor vendedor = vendedores.get(opcionVendedor-1);
		
		if (vendedor.getTipo().equalsIgnoreCase("campesino")) {
			
			Campesino camp = (Campesino) vendedor;
			double nuevoPrecio = camp.calcularPrecioConImpuesto(objeto);
			double usabilidad = camp.deterioro(objeto);
			objeto.setPrecio(nuevoPrecio);
			objeto.setUsabilidad(usabilidad);
			
			if(camp.getInventario().size() > 5) {
				throw new CapacidadInventarioException("No puede tener más de 5 items");
			}else{
				camp.aniadirItem(objeto);
			}
			
			
		}else if(vendedor.getTipo().equalsIgnoreCase("mercader")) {
			Mercader merc = (Mercader) vendedor;
			double nuevoPrecio = merc.calcularPrecioConImpuesto(objeto);
			double usabilidad = merc.deterioro(objeto);
			objeto.setPrecio(nuevoPrecio);
			objeto.setUsabilidad(usabilidad);
			
			if(merc.getInventario().size() > 7) {
				throw new CapacidadInventarioException("No puede tener más de 7 items");
			}else{
				merc.aniadirItem(objeto);
			}
		}else if(vendedor.getTipo().equalsIgnoreCase("ladron")) {
			Ladron ldrn = (Ladron) vendedor;
			double nuevoPrecio = ldrn.calcularPrecioConImpuesto(objeto);
			double usabilidad = ldrn.deterioro(objeto);
			objeto.setPrecio(nuevoPrecio);
			objeto.setUsabilidad(usabilidad);
			
			if(ldrn.getInventario().size() > 3) {
				throw new CapacidadInventarioException("No puede tener más de 3 items");
			}else{
				ldrn.aniadirItem(objeto);
			}
		}
		
		
	}
	public static void crearComprador(ArrayList<Comprador> compradores) {
		Comprador compr = new Comprador(getString("Nombre: "), getString("Ciudad: "));
		compradores.add(compr);
		
	}
	
	public static void mostrarVendedores(ArrayList<Vendedor> vendedores) {
		int i = 1;
		for(Vendedor v : vendedores) {
			System.out.println(i+". "+ v.getNombre()+"\t"+v.getTipo());
		}
	}
	
	public static void mostrarItems(ArrayList<Item> itemList) {
		int i = 1;
		for(Item it : itemList) {
			System.out.println(i+". "+it.getNombre()+"\t"+it.getTipo()+"\t"+it.getPrecio());
			i++;
		}
		
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
