package com.cheemsmart.strategy;

public class EspaniaStrategy extends PaisStrategy {

	@Override
	public void saludarUsuario() {
		System.out.println("¡Bienvenido a vuestra tienda preferida, " + clienteActual.getNombre() + "!");
	}

	@Override
	public void despedirseUsuario() {
		System.out.println("¡Hasta luego!");
	}

	@Override
	public void mostrarOpcionesIniciales() {
		System.out.println("¿Qué desea hacer?");
		System.out.println("1. Mirar el catálogo. \n2. Comprar productos. \n3. Cerrar sesión. \n4. Salir del programa.");
	}

	@Override
	public String mensajeErrorGenerico() {
		return "Ha introducido un valor inválido.";
	}

	@Override
	public void mostrarTicketCompra(double precio) {
		System.out.println("--- Cesta ---");
		carrito.forEach(System.out::println);
		System.out.println("Precio total: €" + precio);
		System.out.println("Vuestro saldo de cuenta actualizado: €" + clienteActual.getDineroDisponible());
	}

	@Override
	public void mostrarIndicacionesEntrega() {
		if (obtenerCarrito().size() < 1) {
			return;
		} else {
			System.out.println("Vuestro pedido será entregado el 29 de febrero a la siguiente dirección: " + clienteActual.getDireccion());
		}
	}

	@Override
	public void mostrarOpcionesCarrito() {
		System.out.println("¿Qué desea hacer? \n1. Coger algún producto. \n2. Terminar compra. \n3. Salir sin comprar y/o cancelar compra.");
	}

	@Override
	public void solicitarCodigoBarras() {
		System.out.println("Coja el producto que desea agregar introduciendo el código de barras correspondiente.");
	}

	@Override
	public void solicitarCuentaBancaria() {
		System.out.println("Por favor, introduzca su cuenta bancaria.");
	}

	@Override
	public void cancelarCompra() {
		System.out.println("Su orden ha sido cancelada.");
	}

	@Override
	public String mensajeErrorCuentaIncorrecta() {
		return "Ha ingresado una cuenta que no corresponde al usuario. Toda la aplicación será cerrada.";
	}

	@Override
	public String mensajeErrorDineroInsuficiente() {
		return "No tiene el monto suficiente para realizar la transacción.";
	}
}
