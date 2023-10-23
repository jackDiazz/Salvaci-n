package com.cheemsmart.proxy;

import java.util.NoSuchElementException;

public class Cliente implements ICliente {

    private static int id = 0;
    String nombreUsuario;
    String password;
    String nombre;
    long telefono;
    String direccion;
    int cuentaBancaria;
    String paisOrigen;
    double dineroDisponible;

    public Cliente(String nombreUsuario, String password, String nombre, long telefono, String direccion, int cuentaBancaria, String paisOrigen, double dineroDisponible) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuentaBancaria = cuentaBancaria;
        this.paisOrigen = paisOrigen;
        this.dineroDisponible = dineroDisponible;
        id = generarNuevoID();
    }

    private static int generarNuevoID() {
        id++;
        return id;
    }

    public static int obtenerID() {
        return id;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerNombreUsuario() {
        return nombreUsuario;
    }

    public String obtenerDireccion() {
        return direccion;
    }

    public int getCuenta() {
        return cuentaBancaria;
    }

    public String obtenerPaisOrigen() {
        return paisOrigen;
    }

    public double obtenerDineroDisponible() {
        return dineroDisponible;
    }

    public String obtenerContraseña() {
        return password;
    }

    public long obtenerTelefono() {
        return telefono;
    }

    public String obtenerNumeroTelefonoConFormato() {
        if (obtenerPaisOrigen().equalsIgnoreCase("Mexico")) {
            obtenerTelefono();
        } else if (obtenerPaisOrigen().equalsIgnoreCase("Spain")) {
            obtenerTelefono();
        } else if (obtenerPaisOrigen().equalsIgnoreCase("Estados Unidos")) {
            obtenerTelefono();
        }
        return null;
    }

    @Override
    public void pagar(int cuentaBancaria, double precio) {
        if (precio <= dineroDisponible) {
            dineroDisponible -= precio;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Usuario: ");
        s.append(obtenerNombreUsuario());
        s.append("\nNumero telefonico: ");
        if (obtenerPaisOrigen().equalsIgnoreCase("Mexico")) {
            obtenerTelefono();
        } else if (obtenerPaisOrigen().equalsIgnoreCase("Spain")) {
            obtenerTelefono();
        } else if (obtenerPaisOrigen().equalsIgnoreCase("Estados Unidos")) {
            obtenerTelefono();
        }
        s.append("\nDireccion: ");
        s.append(obtenerDireccion());
        s.append("\nPais de origen: ");
        s.append(obtenerPaisOrigen());

        return s.toString();
    }

}
