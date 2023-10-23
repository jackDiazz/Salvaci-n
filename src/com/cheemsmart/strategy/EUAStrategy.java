package com.cheemsmart.strategy;

public class EUAStrategy extends PaisStrategy {

	@Override
	public void saludarUsuario() {
		System.out.println("Welcome, " + clienteActual.getNombre() + "!");
	}

	@Override
	public void despedirseUsuario() {
		System.out.println("Goodbye!");
	}

	@Override
	public void mostrarOpcionesIniciales() {
		System.out.println("What operation would you like to perform?");
		System.out.println("1. See the catalog. \n2. Buy. \n3. Log out. \n4. Exit.");
	}

	@Override
	public String mensajeErrorGenerico() {
		return "You have entered an invalid value.";
	}

	@Override
	public void mostrarTicketCompra(double precio) {
		if (precio == 0) {
			System.out.println("You didn't purchase any product.");
			return;
		}
		System.out.println("--- Shopping cart ---\n");
		carrito.forEach(System.out::println);
		System.out.println("\nOrder total: $" + precio);
		System.out.println("\nUpdated account balance: $" + clienteActual.getDineroDisponible());

	}

	@Override
	public void mostrarIndicacionesEntrega() {
		if (obtenerCarrito().size() < 1) {
			return;
		} else {
			System.out.println("Your order will be delivered on February 29 to the following address: " + clienteActual.getDireccion());
		}
	}

	@Override
	public void mostrarOpcionesCarrito() {
		System.out.println("What would you like to do today? \n1. Add some magic to your cart. \n2. Proceed to checkout. \n3. Wave your wand to cancel or exit.");
	}

	@Override
	public void solicitarCodigoBarras() {
		System.out.println("Select the product you desire by entering its barcode, as if you're choosing a spell.");
	}

	@Override
	public void solicitarCuentaBancaria() {
		System.out.println("Please share your enchanted bank account number, so we can make the magic happen.");
	}

	@Override
	public void cancelarCompra() {
		System.out.println("Your wizardly order has been canceled. No magic today.");
	}

	@Override
	public String mensajeErrorCuentaIncorrecta() {
		return "Oops! You've cast a spell with the wrong account number. The entire enchantment will be reversed.";
	}

	@Override
	public String mensajeErrorDineroInsuficiente() {
		return "Oh no, your coin pouch seems to be running low on magical essence. Not enough magic in there!";
	}
}
