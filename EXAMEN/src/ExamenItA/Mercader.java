package ExamenItA;

public class Mercader extends Vendedor {
	/*El mercader tiene hasta 7 ítems para vender 
	 * y al precio original le agrega un impuesto del 4%.
	 * Cuando un mercader agrega un ítem a su inventario este 
	 * no se deteriora */

	public Mercader(String nombre, String tipo) {
		super(nombre, tipo);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public double calcularPrecioConImpuesto(Item it) {
		// TODO Auto-generated method stub
		return it.getPrecio()*0.04 +it.getPrecio();
		
	}

	@Override
	public double deterioro(Item it) {
		// TODO Auto-generated method stub
		return it.getUsabilidad();
	}
	
	

}
