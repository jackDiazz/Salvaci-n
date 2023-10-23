package com.cheemsmart.facade;

import java.util.ArrayList;
import java.util.NoSuchElementException;


import com.cheemsmart.iterator.Catalogo;
import com.cheemsmart.proxy.Cliente;
import com.cheemsmart.proxy.ClienteProxy;
import com.cheemsmart.strategy.*;

/**
 * Clase fachada en la que el usuario interactua con el programa
 */
public class TiendaFecade {
	private ArrayList<Cliente> clientes;
	private PaisStrategy tienda;
	private Catalogo catalogo;
	private ClienteProxy cliente;

	/**
	 * Método constructor por defecto
	 */
	public TiendaFecade() {
		Cliente oscarEvil_MX = new Cliente("OscarEvil", "Oscar123", "Oscar",5535465768L ,
				"Trajineras Xochimilco, CDMX", 22446688, "México",932.51);
		Cliente leGringoLoco_US = new Cliente("LeGringoLoco", "ILoveGuns", "Steve",5551234567L ,
				"Albuquerque, Nuevo México", 92648701, "Estados Unidos", 854000);
		Cliente samuel777_ES = new Cliente("Samuel777", "Eyymuibuenasatoosguaapisimoss", "Samuel ",931234567L ,
				"Fátima, Córdoba", 67208479, "Spain", 700000);
		clientes = new ArrayList<>();
		clientes.add(oscarEvil_MX);
		clientes.add(leGringoLoco_US);
		clientes.add(samuel777_ES);
		catalogo = new Catalogo();
	}

	/**
	 * Método para que el usuario ingrese al sistema mediante su usuario y contraseña
	 * @param usuario nombre de usuario
	 * @param password contraseña del usuario
	 */
	public void ingresar(String usuario, String password) {
		boolean existe = clientes.stream().anyMatch(p -> p.getNombreUsuario().equalsIgnoreCase(usuario));
		if (existe) {
			Cliente actual = clientes.stream().filter(p -> p.getNombreUsuario().equalsIgnoreCase(usuario)).findFirst()
					.get();
			if (actual.getPassword().equals(password)) {
				if (actual.getPaisOrigen().equalsIgnoreCase("Spain")) {
					tienda = new EspaniaStrategy();
				} else if (actual.getPaisOrigen().equalsIgnoreCase("Mexico")) {
					tienda = new MexicoStrategy();
				} else if (actual.getPaisOrigen().equalsIgnoreCase("Estados Unidos")) {
					tienda = new EUAStrategy();
				}
				cliente = new ClienteProxy(actual);
				tienda.setClienteActual(actual);
				tienda.saludarUsuario();
			} else {
				throw new IllegalArgumentException("The password that you've entered is incorrect.");
			}
		} else {
			throw new NoSuchElementException("The username you entered isn't connected to an account.");
		}
	}

	/**
	 * Método que muestra el catalogo de la tienda
	 */
	public void mostrarMenu() {
		catalogo.printCatalogoCompleto();
	}
	
	/**
	 * Método que muestra las opciones principales del cliente
	 */
	public void menuPrincipal() {
		tienda.mostrarOpcionesIniciales();
	}
	
	/**
	 * Método para mostrarle al usuario el catálogo y que seleccione una opcion
	 */
	public void opciones() {
		catalogo.printCatalogoCompleto();
		tienda.mostrarOpcionesCarrito();
	}
	
	/**
	 * Método para agregar productos a la compra
	 * @param codigo codigo de barras del producto que
	 * se desea comprar
	 */
	public void agregarProducto(int codigo) {
		Producto p = catalogo.getEntregaProducto(codigo);

		if(p == null) {
			throw new NoSuchElementException(tienda.mensajeErrorGenerico());
		}
		tienda.agregarProductoAlCarrito(p);
	}
	
	/**
	 * Método para que el usuario termine y realice su compra
	 * @param cuenta cuenta bancaria del usuario
	 */
	public void realizarCompra(int cuenta) {
		double precioTotal = tienda.calcularPrecioTotal();			
		try {
			cliente.pagarProducto(cuenta, precioTotal);						
			tienda.mostrarTicketCompra(precioTotal);
			tienda.mostrarIndicacionesEntrega();
		} catch (IllegalArgumentException e) {
			cuentaIncorrecta();
		} catch(NoSuchElementException a) {
			System.err.println(tienda.mensajeErrorDineroInsuficiente());
		}
	}
	
	/**
	 * Método para cerrar el programa si el usuario se equivoca
	 * al meter su cuenta bancaria
	 */
	public void cuentaIncorrecta() {
		System.err.println(tienda.mensajeErrorCuentaIncorrecta());
		System.exit(0);
	}
	
	/**
	 * Método que le pide al usuario información para realizar acciones
	 * @param opcion Información que se necesita del usuario
	 */
	public void request(int opcion) {
		if(opcion == 1) {
			tienda.solicitarCodigoBarras();
		} else if(opcion == 2) {
			tienda.solicitarCodigoBarras();
		} else if(opcion == 3) {
			tienda.cancelarCompra();
		}
	}

	/**
	 * Método para despedir al usuario cuando cierra sesión
	 */
	public void cerrarSesion() {
		tienda.despedirseUsuario();
		tienda = null;
	}

	/**
	 * Método para regresar un error genérico.
	 */
	public void error() {
		System.err.println(tienda.mensajeErrorGenerico());
	}
}
