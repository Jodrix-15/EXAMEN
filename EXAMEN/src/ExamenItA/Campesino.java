package ExamenItA;

public class Campesino extends Vendedor {
	/*El campesino tiene hasta 5 ítems para vender 
	 * y al precio original le agrega un impuesto del 2%.
	 * Cuando un campesino agrega un ítem a su inventario este 
	 * se deteriora un
		15%. */

	public Campesino(String nombre, String tipo) {
		super(nombre, tipo);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public double calcularPrecioConImpuesto(Item it) {
		// TODO Auto-generated method stub
		return it.getPrecio()*0.02 +it.getPrecio();
	}

	@Override
	public double deterioro(Item it) {
		// TODO Auto-generated method stub
		return it.getUsabilidad() - it.getUsabilidad()*0.15;
		
	}
	
	
	 

}
