/**
 * Esta es una clase abstracta que representa una estrategia genérica para operaciones relacionadas con compras en un país.
 * Las clases concretas que heredan de esta clase implementan las operaciones específicas para un país particular.
 */
package com.cheemsmart.strategy;

import java.util.ArrayList;
import java.util.Random;

import com.cheemsmart.facade.Producto;
import com.cheemsmart.proxy.Cliente;

public abstract class PaisStrategy {

    // Atributos de la clase
    protected Cliente clienteActual;
    protected ArrayList<Producto> carrito;

    /**
     * Constructor de la clase. Inicializa el carrito de compras como una lista vacía.
     */
    public PaisStrategy() {
        this.carrito = new ArrayList<>();
    }

    // Métodos abstractos que deben implementarse en clases concretas

    /**
     * Saluda al usuario.
     */
    public abstract void saludarUsuario();

    /**
     * Se despide del usuario.
     */
    public abstract void despedirseUsuario();

    /**
     * Muestra las opciones iniciales disponibles para el usuario.
     */
    public abstract void mostrarOpcionesIniciales();

    /**
     * Muestra las opciones relacionadas con el carrito de compras.
     */
    public abstract void mostrarOpcionesCarrito();

    /**
     * Devuelve un mensaje genérico de error.
     *
     * @return Mensaje de error genérico.
     */
    public abstract String mensajeErrorGenerico();

    /**
     * Solicita al usuario ingresar un código de barras.
     */
    public abstract void solicitarCodigoBarras();

    /**
     * Solicita al usuario ingresar una cuenta bancaria.
     */
    public abstract void solicitarCuentaBancaria();

    /**
     * Cancela la compra actual.
     */
    public abstract void cancelarCompra();

    /**
     * Devuelve un mensaje de error para cuentas bancarias incorrectas.
     *
     * @return Mensaje de error para cuentas bancarias incorrectas.
     */
    public abstract String mensajeErrorCuentaIncorrecta();

    /**
     * Devuelve un mensaje de error para casos de dinero insuficiente.
     *
     * @return Mensaje de error para dinero insuficiente.
     */
    public abstract String mensajeErrorDineroInsuficiente();

    /**
     * Muestra un ticket de compra con el precio total.
     *
     * @param precio Precio total de la compra.
     */
    public abstract void mostrarTicketCompra(double precio);

    /**
     * Muestra las indicaciones de entrega al usuario.
     */
    public abstract void mostrarIndicacionesEntrega();

    // Métodos privados y de uso interno

    /**
     * Determina si se debe ofrecer una oferta al usuario.
     *
     * @return Verdadero si se debe ofrecer una oferta, falso en caso contrario.
     */
    private boolean ofrecerOferta() {
        Random r = new Random();
        double probabilidad = r.nextDouble();

        if (probabilidad < 0.077) {
            return true;
        }
        return false;
    }

    /**
     * Agrega un producto al carrito de compras.
     *
     * @param producto Producto a agregar al carrito.
     */
    public void agregarProductoAlCarrito(Producto producto) {
        carrito.add(producto);
    }

    /**
     * Calcula el descuento total basado en el país de origen del cliente y los códigos de barras de los productos en el carrito.
     *
     * @return Descuento total.
     */
    private double calcularDescuento() {
        String paisOrigen = clienteActual.getPaisOrigen();
        double descuentoTotal = 0.0;

        for (Producto producto : carrito) {
            int codigoBarras = producto.getCodigoBarras();

            if (paisOrigen.equals("Mexico") && codigoBarras >= 3000 && codigoBarras < 4000) {
                descuentoTotal += producto.getPrecio() * 0.20;
            } else if (paisOrigen.equals("Spain") && codigoBarras >= 5000 && codigoBarras < 6000) {
                descuentoTotal += producto.getPrecio() * 0.20;
            } else if (paisOrigen.equals("Estados Unidos") && codigoBarras >= 7000 && codigoBarras < 8000) {
                descuentoTotal += producto.getPrecio() * 0.20;
            }
        }

        return descuentoTotal;
    }

    /**
     * Calcula el precio total de la compra, teniendo en cuenta los productos en el carrito y los posibles descuentos ofrecidos.
     *
     * @return Precio total de la compra.
     */
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

    /**
     * Establece el cliente actual para la estrategia.
     *
     * @param clienteActual Cliente actual.
     */
    public void setClienteActual(Cliente clienteActual) {
        this.clienteActual = clienteActual;
    }

    /**
     * Obtiene el carrito de compras actual.
     *
     * @return Lista de productos en el carrito.
     */
    public ArrayList<Producto> obtenerCarrito() {
        return carrito;
    }
}
