package ExamenItA;

public class Ladron extends Vendedor {
	/*El ladron tiene hasta 3 ítems para vender 
	 * y al precio original le agrega un impuesto del 0%.
	 * Cuando un ladrón agrega un ítem a su inventario este 
	 * se deteriora un
		25%. */

	public Ladron(String nombre, String tipo) {
		super(nombre, tipo);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public double calcularPrecioConImpuesto(Item it) {
		// TODO Auto-generated method stub
		return it.getPrecio();
		
	}

	@Override
	public double deterioro(Item it) {
		// TODO Auto-generated method stub
		return it.getUsabilidad() - it.getUsabilidad()*0.25;
	}

}
