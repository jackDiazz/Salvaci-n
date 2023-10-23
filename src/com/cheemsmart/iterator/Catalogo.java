package com.cheemsmart.iterator;

import java.util.Iterator;

import com.cheemsmart.facade.Producto;

/**
 * Clase que contiene a todos los catálogos juntos como uno solo 
 * 
 */
public class Catalogo {
	private CatalogoComida catalogoComida;
	private CatalogoMascotas catalogoMascotas;
	private CatalogoElectronica catalogoElectronica;
	private CatalogoLimpieza catalogoLimpieza;

	//PERSONALIZACION DE LA TERMINAL
    public static final String NEG = "\u001b[1m";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001b[92m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001b[36m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String ORANGE = "\u001B[38;5;208m";
	public static final String BROWN = "\u001B[38;5;94m";

	/**
	 * Método constructor para crear los catálogos
	 */
	public Catalogo() {
		catalogoComida = new CatalogoComida();
		catalogoMascotas = new CatalogoMascotas();
		catalogoElectronica = new CatalogoElectronica();
		catalogoLimpieza= new CatalogoLimpieza();
	}
	

	public Catalogo(CatalogoComida catalogoComida, CatalogoMascotas catalogoMascotas, CatalogoElectronica catalogoElectronica, CatalogoLimpieza catalogoLimpieza) {
		this.catalogoComida = catalogoComida;
		this.catalogoMascotas = catalogoMascotas;
		this.catalogoElectronica = catalogoElectronica;
		this.catalogoLimpieza= catalogoLimpieza;
	}
	
	/**
	 * Método para imprimir todos los catálogos
	 */
	public void printCatalogoCompleto() {
		//Usamos un iterador para cada catalogo
		Iterator<Producto> iteradorCatalogoComida = catalogoComida.getIterator();
		Iterator<Producto> iteradorCatalogoMascotas = catalogoMascotas.getIterator();
		Iterator<Producto> iteradorCatalogoElectronica = catalogoElectronica.getIterator();
		Iterator<Producto> iteradorCatalogoLimpieza=catalogoLimpieza.getIterator();
		
		System.out.println(NEG+CYAN+"\n**MICHI 3B**\n"+RESET);
		System.out.println(NEG+YELLOW+"COMIDA"+RESET);
		imprimeCatalogo(iteradorCatalogoComida);
		System.out.println();
		System.out.println(NEG+BLUE+"ELECTRONICA"+RESET);
		imprimeCatalogo(iteradorCatalogoElectronica);
		System.out.println();
		System.out.println(NEG+ORANGE+"LIMPIEZA"+RESET);
		imprimeCatalogo(iteradorCatalogoLimpieza);
		System.out.println();
		System.out.println(NEG+BROWN+"MASCOTAS"+RESET);
		imprimeCatalogo(iteradorCatalogoMascotas);
	}
	
	/**
	 * Método para imprimir un catálogo a través de su iterador
	 * @param iterador
	 */
	public void imprimeCatalogo(Iterator<Producto> iterador) {
		while (iterador.hasNext()) {
			Producto p = iterador.next();
			System.out.println(p + "\n");
		}
	}

	/**
     * Método que obtiene el producto que el usuario pide mediante el código de barras
     * @param barras codigo de barras del producto
     * @return Producto que se va a entregar
     */
    public Producto getEntregaProducto(int barras) {

    	if(barras==1000||barras==1100||barras==1110||barras==1111) {
    		Iterator<Producto> iteradorCatalogoComida = catalogoComida.getIterator();
    		return buscaProducto(iteradorCatalogoComida, barras);
    	} else if(barras==2000||barras==2200||barras==2220||barras==2222) {
    		Iterator<Producto> iteradorCatalogoElectronica = catalogoElectronica.getIterator();
    		return buscaProducto(iteradorCatalogoElectronica, barras);
    	} else if(barras==3000||barras==3300||barras==3330||barras==3333) {
    		Iterator<Producto> iteradorCatalogoLimpieza = catalogoLimpieza.getIterator();
    		return buscaProducto(iteradorCatalogoLimpieza, barras);
    	}else if(barras==4000||barras==4400||barras==4440||barras==4444){
			Iterator<Producto> iteradorCatalogoMascotas= catalogoMascotas.getIterator();
			return buscaProducto(iteradorCatalogoMascotas, barras);
		}
    	return null;
    }
    /**
     * Método para buscar un producto mediante el iterador y el código de barras
     * @param iterador Iterador del catalogo donde se va a buscar.
     * @param barras codigo de barras del producto
     * @return producto buscado o si no existe es null
     */
    private Producto buscaProducto(Iterator<Producto> iterador, int barras) {
    	while(iterador.hasNext()) {
    		Producto producto = iterador.next();
    		if(producto.getCodigoBarras() == barras) {
    			return producto;
    		}
    	}
    	return null;
    }
}

