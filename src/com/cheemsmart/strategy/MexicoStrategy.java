/**
 * Clase concreta que implementa la estrategia específica para operaciones en México.
 * Hereda de la clase abstracta PaisStrategy y proporciona la implementación de los métodos para este país.
 */
package com.cheemsmart.strategy;

public class MexicoStrategy extends PaisStrategy {

    /**
     * Saluda al usuario mexicano al iniciar la sesión.
     */
    @Override
    public void saludarUsuario() {
        System.out.println("¡Bienvenido a tu tienda preferida, " + clienteActual.obtenerNombre() + "!");
    }

    /**
     * Se despide del usuario mexicano al cerrar la sesión.
     */
    @Override
    public void despedirseUsuario() {
        System.out.println("¡Vuelva pronto!");
    }

    /**
	 * Muestra las opciones iniciales disponibles para el usuario mexicano.
	 */
	@Override
	public void mostrarOpcionesIniciales() {
		System.out.println("¿Qué desea hacer wey?");
		System.out.println("1. Ver el catálogo.");
		System.out.println("2. Comprar productos.");
		System.out.println("3. Cerrar sesión.");
		System.out.println("4. Salir del programa.");
	}


    /**
     * Devuelve un mensaje de error genérico para el usuario mexicano.
     *
     * @return Mensaje de error genérico.
     */
    @Override
    public String mensajeErrorGenerico() {
        return "Ha ingresado una opción inválida.";
    }

    /**
     * Muestra un ticket de compra para el usuario mexicano, incluyendo los productos en el carrito y el precio total.
     *
     * @param precio Precio total de la compra.
     */
    @Override
    public void mostrarTicketCompra(double precio) {
        if (precio == 0) {
            System.out.println("No ingresó ningún producto, por lo que no compró nada.");
            return;
        }
        System.out.println("--- Carrito de compra ---\n");
        carrito.forEach(System.out::println);
        System.out.println("\nPrecio total: $" + precio);
        System.out.println("\nDinero disponible en su cuenta después del cargo: $" + clienteActual.obtenerDineroDisponible());
    }

    /**
     * Muestra las indicaciones de entrega para el usuario mexicano, si hay productos en el carrito.
     */
    @Override
    public void mostrarIndicacionesEntrega() {
        if (obtenerCarrito().isEmpty()) {
            return;
        } else {
            System.out.println("Su orden será entregada el 29 de febrero a la siguiente dirección: " + clienteActual.obtenerDireccion());
        }
    }

    /**
     * Muestra las opciones relacionadas con el carrito de compras para el usuario mexicano.
     */
    @Override
    public void mostrarOpcionesCarrito() {
        System.out.println("¿Qué acción desea realizar? \n1. Agregar un producto al carrito. \n2. Terminar compra. \n3. Salir sin comprar y/o cancelar compra.");
    }

    /**
     * Solicita al usuario mexicano ingresar un código de barras para agregar un producto al carrito.
     */
    @Override
    public void solicitarCodigoBarras() {
        System.out.println("Seleccione el producto que desea agregar introduciendo el código de barras correspondiente.");
    }

    /**
     * Solicita al usuario mexicano ingresar su cuenta bancaria para realizar la transacción.
     */
    @Override
    public void solicitarCuentaBancaria() {
        System.out.println("Por favor, ingrese su cuenta bancaria.");
    }

    /**
     * Cancela la compra para el usuario mexicano.
     */
    @Override
    public void cancelarCompra() {
        System.out.println("Su orden ha sido cancelada.");
    }

    /**
     * Devuelve un mensaje de error para cuentas bancarias incorrectas del usuario mexicano.
     *
     * @return Mensaje de error para cuentas bancarias incorrectas.
     */
    @Override
    public String mensajeErrorCuentaIncorrecta() {
        return "Ha ingresado una cuenta que no corresponde al usuario. La aplicación se cerrará.";
    }

    /**
     * Devuelve un mensaje de error para casos de dinero insuficiente del usuario mexicano.
     *
     * @return Mensaje de error para dinero insuficiente.
     */
    @Override
    public String mensajeErrorDineroInsuficiente() {
        return "No tiene suficiente dinero para realizar la transacción.";
    }
}
