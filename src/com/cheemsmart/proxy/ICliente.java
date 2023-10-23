package com.cheemsmart.proxy;
/**
 * Esta interfaz representa un cliente genérico que puede realizar pagos.
 */
public interface ICliente {

    /**
     * Realiza un pago utilizando la cuenta bancaria especificada y el precio indicado.
     *
     * @param cuenta Cuenta bancaria desde la cual se realizará el pago.
     * @param precio Precio del artículo o servicio que se va a pagar.
     */
    void pagar(int cuenta, double precio);

    /**
     * Obtiene el número de cuenta bancaria del cliente.
     *
     * @return Número de cuenta bancaria del cliente.
     */
    int getCuenta();
}
