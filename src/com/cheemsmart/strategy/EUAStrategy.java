/**
 * Clase concreta que implementa la estrategia específica para operaciones en Estados Unidos (EE. UU.).
 * Hereda de la clase abstracta PaisStrategy y proporciona la implementación de los métodos para este país.
 */
package com.cheemsmart.strategy;

public class EUAStrategy extends PaisStrategy {

    /**
     * Saluda al usuario estadounidense al iniciar la sesión.
     */
    @Override
    public void saludarUsuario() {
        System.out.println("Welcome, " + clienteActual.getNombre() + "!");
    }

    /**
     * Se despide del usuario estadounidense al cerrar la sesión.
     */
    @Override
    public void despedirseUsuario() {
        System.out.println("Goodbye!");
    }

    /**
     * Muestra las opciones iniciales disponibles para el usuario estadounidense.
     */
    @Override
    public void mostrarOpcionesIniciales() {
        System.out.println("What operation would you like to perform?");
        System.out.println("1. See the catalog. \n2. Buy. \n3. Log out. \n4. Exit.");
    }

    /**
     * Devuelve un mensaje de error genérico para el usuario estadounidense.
     *
     * @return Mensaje de error genérico.
     */
    @Override
    public String mensajeErrorGenerico() {
        return "You have entered an invalid value.";
    }

    /**
     * Muestra un ticket de compra para el usuario estadounidense, incluyendo los productos en el carrito y el precio total.
     *
     * @param precio Precio total de la compra.
     */
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

    /**
     * Muestra las indicaciones de entrega para el usuario estadounidense, si hay productos en el carrito.
     */
    @Override
    public void mostrarIndicacionesEntrega() {
        if (obtenerCarrito().size() < 1) {
            return;
        } else {
            System.out.println("Your order will be delivered on February 29 to the following address: " + clienteActual.getDireccion());
        }
    }

    /**
     * Muestra las opciones relacionadas con el carrito de compras para el usuario estadounidense.
     */
    /**
 * Muestra las opciones relacionadas con el carrito de compras para el usuario estadounidense.
 */
	@Override
	public void mostrarOpcionesCarrito() {
		System.out.println("What would you like to do today?");
		System.out.println("1. Add some magic to your cart.");
		System.out.println("2. Proceed to checkout.");
		System.out.println("3. Wave your wand to cancel or exit.");
	}


    /**
     * Solicita al usuario estadounidense ingresar un código de barras para agregar un producto al carrito.
     */
    @Override
    public void solicitarCodigoBarras() {
        System.out.println("Select the product you desire by entering its barcode, as if you're choosing a spell.");
    }

    /**
     * Solicita al usuario estadounidense ingresar su cuenta bancaria para realizar la transacción.
     */
    @Override
    public void solicitarCuentaBancaria() {
        System.out.println("Please share your enchanted bank account number, so we can make the magic happen.");
    }

    /**
     * Cancela la compra para el usuario estadounidense.
     */
    @Override
    public void cancelarCompra() {
        System.out.println("Your wizardly order has been canceled. No magic today.");
    }

    /**
     * Devuelve un mensaje de error para cuentas bancarias incorrectas del usuario estadounidense.
     *
     * @return Mensaje de error para cuentas bancarias incorrectas.
     */
    @Override
    public String mensajeErrorCuentaIncorrecta() {
        return "Oops! You've cast a spell with the wrong account number. The entire enchantment will be reversed.";
    }

    /**
     * Devuelve un mensaje de error para casos de dinero insuficiente del usuario estadounidense.
     *
     * @return Mensaje de error para dinero insuficiente.
     */
    @Override
    public String mensajeErrorDineroInsuficiente() {
        return "Oh no, your coin pouch seems to be running low on magical essence. Not enough magic in there!";
    }
}
