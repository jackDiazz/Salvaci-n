package com.cheemsmart.proxy;

public class ClienteProxy implements ICliente {

	private ICliente cliente;
	private int cuentaBancaria;

	public ClienteProxy(ICliente cliente) {
		this.cliente = cliente;
		cuentaBancaria = cliente.getCuenta();
	}
	
	@Override
	public void pagar(int cuentaBancaria, double precio) {
		if(this.cuentaBancaria == cuentaBancaria) {
			cliente.pagar(cuentaBancaria, precio);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public int getCuenta() {
		return cuentaBancaria;
	}

}
