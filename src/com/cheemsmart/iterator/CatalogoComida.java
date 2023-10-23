package com.cheemsmart.iterator;

import java.util.Iterator;
import java.util.HashSet;

import com.cheemsmart.facade.Producto;

/**
 * Clase que representa al catálogo de comida 
 */
public class CatalogoComida {
	private HashSet<Producto> catalogo;
	
	/**
	 * Método constructor
	 */
	public CatalogoComida() {
		catalogo = new HashSet<>();	

		catalogo.add(new Producto(1000, "Sopas Pastosas", "Sopita de letras, 200 gr", "Comida", 26.90));
		catalogo.add(new Producto(1100, "ElvisCochos", "Caja de bizcochos, 540gr", "Comida", 189.00));
		catalogo.add(new Producto(1110, "Thortillas de harina", "Hechas en Asgard, 1Kg", "Comida", 59.99));
		catalogo.add(new Producto(1111, "Paul Macarne", "Carnita para burguir, 1Kg", "Comida",199.99));
	}
	
	
	/**
     * Método para obtener el catálogo específico
	 * @return el iterador del catálogo
     */
	public Iterator<Producto> getIterator(){
		return catalogo.iterator();
	}

    
}
