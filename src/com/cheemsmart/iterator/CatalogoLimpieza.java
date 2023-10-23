package com.cheemsmart.iterator;
import com.cheemsmart.facade.Producto;

import java.util.HashSet;
import java.util.Iterator;


/**
 * Clase que respresenta al catálogo del departamento
 * de electrónica
 */
public class CatalogoLimpieza {
	private HashSet<Producto> catalogo;
	
	/**
	 * Método constructor
	 */
	public CatalogoLimpieza() {
		catalogo = new HashSet<>();	
		
		catalogo.add(new Producto(3000, "Don limpio", "Jabón multiusos, 500 kg", "Limpieza", 32.00));
        catalogo.add(new Producto(3300, "Escoba 15 pro max", "Escoba premium", "Limpieza", 340.00));
        catalogo.add(new Producto(3330, "Aromatizante", "Spray automático aromatizante", "Limpieza", 521.00));
        catalogo.add(new Producto(3333, "Fantabuloso", "Limpiador de pisos, 1L", "Limpieza", 122.00));
    }
	
	
	/**
     * Método para obtener el catálogo específico
	 * @return el iterador del catálogo
     */
	public Iterator<Producto> getIterator(){
		return catalogo.iterator();
	}
}
