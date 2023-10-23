/**
 * Clase concreta que implementa la estrategia específica para operaciones en España.
 * Hereda de la clase abstracta PaisStrategy y proporciona la implementación de los métodos para este país.
 */
package com.cheemsmart.strategy;

public class EspaniaStrategy extends PaisStrategy {

    /**
     * Saluda al usuario español al iniciar la sesión.
     */
    @Override
    public void saludarUsuario() {
        System.out.println("¡Bienvenido a vuestra tienda preferida, " + clienteActual.obtenerNombre() + "!");
    }

    /**
     * Se despide del usuario español al cerrar la sesión.
     */
    @Override
    public void despedirseUsuario() {
        System.out.println("¡Hasta luego!");
    }

    /**
     * Muestra las opciones iniciales disponibles para el usuario español.
     */
   /**
 * Muestra las opciones iniciales disponibles para el usuario español.
 */
	@Override
	public void mostrarOpcionesIniciales() {
		System.out.println("¿Qué desea hacer?");
		System.out.println("1. Mirar el catálogo.");
		System.out.println("2. Comprar productos.");
		System.out.println("3. Cerrar sesión.");
		System.out.println("4. Salir del programa.");
	}


    /**
     * Devuelve un mensaje de error genérico para el usuario español.
     *
     * @return Mensaje de error genérico.
     */
    @Override
    public String mensajeErrorGenerico() {
        return "Ha introducido un valor inválido.";
    }

    /**
     * Muestra un ticket de compra para el usuario español, incluyendo los productos en el carrito y el precio total.
     *
     * @param precio Precio total de la compra.
     */
    @Override
    public void mostrarTicketCompra(double precio) {
        System.out.println("--- Cesta ---");
        carrito.forEach(System.out::println);
        System.out.println("Precio total: €" + precio);
        System.out.println("Vuestro saldo de cuenta actualizado: €" + clienteActual.obtenerDineroDisponible());
    }

    /**
     * Muestra las indicaciones de entrega para el usuario español, si hay productos en el carrito.
     */
    @Override
    public void mostrarIndicacionesEntrega() {
        if (obtenerCarrito().size() < 1) {
            return;
        } else {
            System.out.println("Vuestro pedido será entregado el 29 de febrero a la siguiente dirección: " + clienteActual.obtenerDireccion());
        }
    }

    /**
     * Muestra las opciones relacionadas con el carrito de compras para el usuario español.
     */
    @Override
    public void mostrarOpcionesCarrito() {
        System.out.println("¿Qué desea hacer? \n1. Coger algún producto. \n2. Terminar compra. \n3. Salir sin comprar y/o cancelar compra.");
    }

    /**
     * Solicita al usuario español ingresar un código de barras para agregar un producto al carrito.
     */
    @Override
    public void solicitarCodigoBarras() {
        System.out.println("Coja el producto que desea agregar introduciendo el código de barras correspondiente.");
    }

    /**
     * Solicita al usuario español ingresar su cuenta bancaria para realizar la transacción.
     */
    @Override
    public void solicitarCuentaBancaria() {
        System.out.println("Por favor, introduzca su cuenta bancaria.");
    }

    /**
     * Cancela la compra para el usuario español.
     */
    @Override
    public void cancelarCompra() {
        System.out.println("Su orden ha sido cancelada.");
    }

    /**
     * Devuelve un mensaje de error para cuentas bancarias incorrectas del usuario español.
     *
     * @return Mensaje de error para cuentas bancarias incorrectas.
     */
    @Override
    public String mensajeErrorCuentaIncorrecta() {
        return "Ha ingresado una cuenta que no corresponde al usuario. Toda la aplicación será cerrada.";
    }

    /**
     * Devuelve un mensaje de error para casos de dinero insuficiente del usuario español.
     *
     * @return Mensaje de error para dinero insuficiente.
     */
    @Override
    public String mensajeErrorDineroInsuficiente() {
        return "No tiene el monto suficiente para realizar la transacción.";
    }
}
