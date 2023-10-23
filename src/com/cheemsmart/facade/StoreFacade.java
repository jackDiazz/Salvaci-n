package com.cheemsmart.facade;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import com.cheemsmart.iterator.Catalogo;
import com.cheemsmart.proxy.Cliente;
import com.cheemsmart.proxy.ClienteProxy;
import com.cheemsmart.strategy.*;

public class StoreFacade {
    private ArrayList<Cliente> clientes;
    private PaisStrategy tienda;
    private Catalogo catalogo;
    private ClienteProxy cliente;

    public StoreFacade() {
        Cliente clienteMX = new Cliente("perrito12", "perrito12", "Francisco Javier Lopez", randomPhoneMX(),
                "Balderas 123, CDMX", 89403580, "Mexico", 200);
        Cliente clienteUS = new Cliente("powerDestroyer", "1234", "Bill Clinton", randomPhoneUS(),
                "Hollywood #123, Los Angeles", 57723187, "Estados Unidos", 9000000);
        Cliente clienteES = new Cliente("manolito14", "ManuelGomez29", "Manuel Gomez", randomPhoneES(),
                "Av. Nacional #213, Madrid", 49302922, "Spain", 5000000);
        clientes = new ArrayList<>();
        clientes.add(clienteMX);
        clientes.add(clienteES);
        clientes.add(clienteUS);
        catalogo = new Catalogo();
    }

    private static long randomPhoneMX() {
        Random r = new Random();
        return r.nextInt(199999999) + 5500000000L;
    }

    private static long randomPhoneUS() {
        Random r = new Random();
        return r.nextInt(9999999) + 4150000000L;
    }

    private static long randomPhoneES() {
        Random r = new Random();
        return r.nextInt(999999999) + 6000000000L;
    }

    public void ingresar(String usuario, String password) {
        boolean existe = clientes.stream().anyMatch(p -> p.obtenerNombreUsuario().equalsIgnoreCase(usuario));
        if (existe) {
            Cliente actual = clientes.stream().filter(p -> p.obtenerNombreUsuario().equalsIgnoreCase(usuario)).findFirst()
                    .get();
            if (actual.obtenerContraseña().equals(password)) {
                if (actual.obtenerPaisOrigen().equalsIgnoreCase("Spain")) {
                    tienda = new EspaniaStrategy();
                } else if (actual.obtenerPaisOrigen().equalsIgnoreCase("Mexico")) {
                    tienda = new MexicoStrategy();
                } else if (actual.obtenerPaisOrigen().equalsIgnoreCase("Estados Unidos")) {
                    tienda = new EUAStrategy();
                }
                cliente = new ClienteProxy(actual);
                tienda.setClienteActual(actual);
                tienda.saludarUsuario();
            } else {
                throw new IllegalArgumentException("The password that you've entered is incorrect.");
            }
        } else {
            throw new NoSuchElementException("The username you entered isn't connected to an account.");
        }
    }

    public void mostrarMenu() {
        catalogo.imprimeCatalogo();
    }
    
    public void menuPrincipal() {
        tienda.mostrarOpcionesIniciales();
    }
    
    public void opciones() {
        catalogo.imprimeCatalogo();
        tienda.mostrarOpcionesCarrito();
    }
    
    public void agregarProducto(int codigo) {
        Producto p = catalogo.entrega(codigo);

        if(p == null) {
            throw new NoSuchElementException(tienda.mensajeErrorGenerico());
        }
        tienda.agregarProductoAlCarrito(p);
    }
    
    public void terminarCompra(int cuenta) {
        double precioTotal = tienda.calcularPrecioTotal();            
        try {
            cliente.pagar(cuenta, precioTotal);                        
            tienda.mostrarTicketCompra(precioTotal);
            tienda.mostrarIndicacionesEntrega();
        } catch (IllegalArgumentException iae) {
            cuentaIncorrecta();
        } catch(NoSuchElementException nsee) {
            System.err.println(tienda.mensajeErrorDineroInsuficiente());
        }
    }
    
    public void cuentaIncorrecta() {
        System.err.println(tienda.mensajeErrorCuentaIncorrecta());
        System.exit(0);
    }
    
    public void request(int opcion) {
        if(opcion == 1) {
            tienda.solicitarCodigoBarras();
        } else if(opcion == 2) {
            tienda.solicitarCodigoBarras();
        } else if(opcion == 3) {
            tienda.cancelarCompra();
        }
    }

    public void cerrarSesion() {
        tienda.despedirseUsuario();
        tienda = null;
    }

    public void error() {
        System.err.println(tienda.mensajeErrorGenerico());
    }
}
