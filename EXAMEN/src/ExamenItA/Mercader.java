package ExamenItA;

public class Mercader extends Vendedor {
	/*El mercader tiene hasta 7 ítems para vender 
	 * y al precio original le agrega un impuesto del 4%.
	 * Cuando un mercader agrega un ítem a su inventario este 
	 * no se deteriora */
	
	public final static double impuesto = 0.04;
	public final static int CAPACIDAD_INVENTARIO = 7;
	public final static int NUEVO_ITEM = 1;

	public Mercader(String nombre, String tipo) {
		super(nombre, tipo);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public double calcularPrecioConImpuesto(Item it) {
		// TODO Auto-generated method stub
		return it.getPrecio()*impuesto +it.getPrecio();
		
	}

	@Override
	public double deterioro(Item it) {
		// TODO Auto-generated method stub
		return it.getUsabilidad();
	}


	@Override
	public void aniadirItem(Item it) throws CapacidadInventarioException{
		// TODO Auto-generated method stub
		
		double nuevoPrecio = calcularPrecioConImpuesto(it);
		double usabilidad = deterioro(it);
		if(usabilidad < 0) {
			usabilidad = 0;
		}
		
		it.setPrecio(nuevoPrecio);
		it.setUsabilidad(usabilidad);
		
		if (super.getInventario().size() + NUEVO_ITEM > CAPACIDAD_INVENTARIO) {
			throw new CapacidadInventarioException("Inventario lleno. No se pueden aniadir mas items");
		}
		
		super.inventario.add(it);
		
	}

}
