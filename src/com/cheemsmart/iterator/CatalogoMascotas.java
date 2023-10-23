package com.cheemsmart.iterator;

import java.util.Iterator;
import java.util.HashSet;

import com.cheemsmart.facade.Producto;

/**
 * Clase que representa al catálogo del departamento de Mascotas
 */
public class CatalogoMascotas {
	private HashSet<Producto> catalogo;
	
	/**
	 * Método constructor
	 */
	public CatalogoMascotas() {
		catalogo= new HashSet<>();
		catalogo.add(new Producto(4000, "Furry Ventures", "Transportadora para mascotas con camita", "Mascotas",2999.99));
        catalogo.add(new Producto(4400, "Arenero de michis", "caja de arena para gato mediano", "Mascotas", 550.00));
        catalogo.add(new Producto(4440, "Bandanas", "Viste a la moda a tu mascota con este set de 3 bandanas", "Mascotas", 532.00));
        catalogo.add(new Producto(4444, "Disfraz calabaza", "Disfraz de calabaza para mascotas pequeñas", "Mascotas", 1555.00));
	}
	
	/**
     * Método para obtener el catálogo específico
	 * @return el iterador del catálogo
     */
	public Iterator<Producto> getIterator(){
		return catalogo.iterator();
	}
}
