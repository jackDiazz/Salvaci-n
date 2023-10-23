package com.cheemsmart.strategy;

import java.util.ArrayList;
import java.util.Random;

import com.cheemsmart.facade.Producto;
import com.cheemsmart.proxy.Cliente;

public abstract class PaisStrategy {

	protected Cliente clienteActual;
	protected ArrayList<Producto> carrito;

	public PaisStrategy() {
		this.carrito = new ArrayList<>();
	}

	public abstract void saludarUsuario();

	public abstract void despedirseUsuario();

	public abstract void mostrarOpcionesIniciales();

	public abstract void mostrarOpcionesCarrito();

	public abstract String mensajeErrorGenerico();

	public abstract void solicitarCodigoBarras();

	public abstract void solicitarCuentaBancaria();

	public abstract void cancelarCompra();

	public abstract String mensajeErrorCuentaIncorrecta();

	public abstract String mensajeErrorDineroInsuficiente();

	public abstract void mostrarTicketCompra(double precio);

	public abstract void mostrarIndicacionesEntrega();

	private boolean ofrecerOferta() {
		Random r = new Random();
		double probabilidad = r.nextDouble();

		if (probabilidad < 0.077) {
			return true;
		}
		return false;
	}

	public void agregarProductoAlCarrito(Producto producto) {
		carrito.add(producto);
	}

	private double calcularDescuento() {
		String paisOrigen = clienteActual.getPaisOrigen();
		double descuentoTotal = 0.0;

		for (Producto producto : carrito) {
			int codigoBarras = producto.getCodigoBarras();

			if (paisOrigen.equals("Mexico") && codigoBarras >= 3000 && codigoBarras < 4000) {
				descuentoTotal += producto.getPrecio() * 0.20;
			} else if (paisOrigen.equals("Spain") && codigoBarras >= 5000 && codigoBarras < 6000) {
				descuentoTotal += producto.getPrecio() * 0.20;
			} else if (paisOrigen.equals("EUA") && codigoBarras >= 7000 && codigoBarras < 8000) {
				descuentoTotal += producto.getPrecio() * 0.20;
			}
		}

		return descuentoTotal;
	}

	public double calcularPrecioTotal() {
		double suma = 0.0;

		for (Producto producto : carrito) {
			suma += producto.getPrecio();
		}

		if (ofrecerOferta()) {
			double descuento = calcularDescuento();
			System.out.println("\nDESCUENTO: $" + descuento + "\n");
			suma -= descuento;
		}

		return suma;
	}

	public void setClienteActual(Cliente clienteActual) {
		this.clienteActual = clienteActual;
	}

	public ArrayList<Producto> obtenerCarrito() {
		return carrito;
	}
}
