package com.cheemsmart.strategy;

public class MexicoStrategy extends PaisStrategy {

	@Override
	public void saludarUsuario() {
		System.out.println("¡Bienvenido a tu tienda preferida, " + clienteActual.getNombre() + "!");
	}

	@Override
	public void despedirseUsuario() {
		System.out.println("¡Vuelva pronto!");
	}

	@Override
	public void mostrarOpcionesIniciales() {
		System.out.println("¿Qué desea hacer?");
		System.out.println("1. Ver el catálogo. \n2. Comprar productos. \n3. Cerrar sesión. \n4. Salir del programa.");
	}

	@Override
	public String mensajeErrorGenerico() {
		return "Ha ingresado una opción inválida.";
	}

	@Override
	public void mostrarTicketCompra(double precio) {
		if (precio == 0) {
			System.out.println("No ingresó ningún producto, por lo que no compró nada.");
			return;
		}
		System.out.println("--- Carrito de compra ---\n");
		carrito.forEach(System.out::println);
		System.out.println("\nPrecio total: $" + precio);
		System.out.println("\nDinero disponible en su cuenta después del cargo: $" + clienteActual.getDineroDisponible());
	}

	@Override
	public void mostrarIndicacionesEntrega() {
		if (obtenerCarrito().isEmpty()) {
			return;
	} else {
		System.out.println("Su orden será entregada el 29 de febrero a la siguiente dirección: " + clienteActual.getDireccion());
	}
}

	@Override
	public void mostrarOpcionesCarrito() {
		System.out.println("¿Qué acción desea realizar? \n1. Agregar un producto al carrito. \n2. Terminar compra. \n3. Salir sin comprar y/o cancelar compra.");
	}

	@Override
	public void solicitarCodigoBarras() {
		System.out.println("Seleccione el producto que desea agregar introduciendo el código de barras correspondiente.");
	}

	@Override
	public void solicitarCuentaBancaria() {
		System.out.println("Por favor, ingrese su cuenta bancaria.");
	}

	@Override
	public void cancelarCompra() {
		System.out.println("Su orden ha sido cancelada.");
	}

	@Override
	public String mensajeErrorCuentaIncorrecta() {
		return "Ha ingresado una cuenta que no corresponde al usuario. La aplicación se cerrará.";
	}

	@Override
	public String mensajeErrorDineroInsuficiente() {
		return "No tiene suficiente dinero para realizar la transacción.";
	}
}
