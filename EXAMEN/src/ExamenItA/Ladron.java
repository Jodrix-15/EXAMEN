package ExamenItA;

public class Ladron extends Vendedor {
	/*El ladron tiene hasta 3 ítems para vender 
	 * y al precio original le agrega un impuesto del 0%.
	 * Cuando un ladrón agrega un ítem a su inventario este 
	 * se deteriora un
		25%. */
	
	public final static double DETERIORO = 0.25;
	public final static int CAPACIDAD_INVENTARIO = 3;
	public final static int NUEVO_ITEM = 1;

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
		return it.getUsabilidad() - it.getUsabilidad()*DETERIORO;
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
		}else {
			super.inventario.add(it);
		}
		
		
		
	}
	
	

}
