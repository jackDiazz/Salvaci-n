package com.cheemsmart.proxy;

/**
 * Esta clase representa un proxy de cliente que actúa como intermediario para realizar pagos en nombre del cliente real.
 */
public class ClienteProxy implements ICliente {

    private ICliente cliente;
    private int cuentaBancaria;

    /**
     * Constructor de la clase ClienteProxy.
     *
     * @param cliente Cliente real al que se harán las solicitudes de pago.
     */
    public ClienteProxy(ICliente cliente) {
        this.cliente = cliente;
        cuentaBancaria = cliente.getCuenta();
    }

    /**
     * Realiza un pago en nombre del cliente real si la cuenta bancaria coincide.
     *
     * @param cuentaBancaria Número de cuenta bancaria proporcionado para el pago.
     * @param precio         Precio del artículo o servicio que se va a pagar.
     * @throws IllegalArgumentException Si la cuenta bancaria no coincide con la del cliente real.
     */
    @Override
    public void pagar(int cuentaBancaria, double precio) {
        if (this.cuentaBancaria == cuentaBancaria) {
            cliente.pagar(cuentaBancaria, precio);
        } else {
            throw new IllegalArgumentException("La cuenta bancaria no coincide con la del cliente real.");
        }
    }

    /**
     * Obtiene el número de cuenta bancaria del cliente real.
     *
     * @return Número de cuenta bancaria del cliente real.
     */
    @Override
    public int getCuenta() {
        return cuentaBancaria;
    }
}
