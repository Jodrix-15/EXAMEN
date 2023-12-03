package ExamenItA;

public class Campesino extends Vendedor {
	/*El campesino tiene hasta 5 ítems para vender 
	 * y al precio original le agrega un impuesto del 2%.
	 * Cuando un campesino agrega un ítem a su inventario este 
	 * se deteriora un
		15%. */
	
	public final static double IMPUESTO= 0.02;
	public final static double DETERIORO = 0.15;
	public final static int CAPACIDAD_INVENTARIO = 5;
	public final static int NUEVO_ITEM = 1;

	

	public Campesino(String nombre, String tipo) {
		super(nombre, tipo);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public double calcularPrecioConImpuesto(Item it) {
		// TODO Auto-generated method stub
		return it.getPrecio()*IMPUESTO +it.getPrecio();
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
		}
		
		super.inventario.add(it);
		
	}

	
	 

}
