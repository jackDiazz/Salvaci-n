package com.cheemsmart.facade;

/**
 * Clase que representa a un producto del catálogo
 */
public class Producto {
	private final int CODIGO_BARRAS;
	private String nombre;
	private String departamento;
	private double precio;
	private String descripcion;

	public static final String NEG = "\u001b[1m";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001b[92m";
	public static final String PINK = "\u001B[38;5;213m";
	
	
	/**
	 * Método constructor del producto
	 * @param CODIGO_BARRAS codigo de barras del producto
	 * @param nombre nombre del producto
	 * @param departamento deparatamento al que pertenece el producto
	 * @param precio precio que tiene el producto
	 */
	public Producto(int CODIGO_BARRAS, String nombre, String descripcion,String departamento, double precio) {
		this.CODIGO_BARRAS = CODIGO_BARRAS;
		this.nombre = nombre;
		this.departamento = departamento;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	/**
         * Método que regresa el id(el cuál es un código de barras) del producto
         * @return código de barras del producto
         */
        public int getCodigoBarras(){
            return this.CODIGO_BARRAS;
        }
        /**
         * Método para obtener el nombre del producto
         * @return nombre del producto
         */
        public String getNombre(){
            return this.nombre;
        }
        /**
         * Método para obtener la descripcion del producto
         * @return  descripción 
         */
        public String getDescripcion(){
            return this.descripcion;
        }
        /**
         * Método para obtener el departamento al que pertenece el producto
         * @return departamento del producto
         */
        public String getDepartamento(){
            return this.departamento;
        }
        /**
         * Método para obtener el precio del producto 
         * @return precio
         */
        public double getPrecio(){
            return this.precio;
        }
	
	@Override
	public String toString() {
		StringBuilder informacion = new StringBuilder();
		informacion.append("\nNombre: ");
		informacion.append(PINK+getNombre()+RESET);
		informacion.append("\nDeparamento: ");
		informacion.append(getDepartamento());
		informacion.append("\nDescripción: ");
		informacion.append(getDescripcion());
		informacion.append("\nPrecio: ");
		informacion.append(GREEN+"$"+getPrecio()+RESET);
		informacion.append("\nCodigo de Barras: ");
		informacion.append(RED+getCodigoBarras()+RESET);
		return informacion.toString();
	}
}
