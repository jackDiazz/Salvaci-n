package com.cheemsmart.iterator;

import java.util.Iterator;
import java.util.HashSet;

import com.cheemsmart.facade.Producto;


/**
 * Clase que respresenta al catálogo del departamento
 * de electrónica
 */
public class CatalogoElectronica {
	private HashSet<Producto> catalogo;
	
	/**
	 * Método constructor
	 */
	public CatalogoElectronica() {
		catalogo = new HashSet<>();	
		
		catalogo.add(new Producto(2000, "Pillofon", "Smartphone última generación (si jala el Pou).", "Electrónica", 8999.99));
        catalogo.add(new Producto(2200, "Perapots", "Audífonos para escuchar corridos tumbados", "Electrónica", 599.99));
        catalogo.add(new Producto(2220, "Ramona", "Bocina inteligente que se controla con la voz. Tu asistente lista para ayudar.", "Electrónica", 1200.00));
        catalogo.add(new Producto(2222, "Microhornito", "Un hornito, fin.", "Electrónica", 789.00));
    }
	
	
	/**
     * Método para obtener el catálogo específico
	 * @return el iterador del catálogo
     */
	public Iterator<Producto> getIterator(){
		return catalogo.iterator();
	}
}
