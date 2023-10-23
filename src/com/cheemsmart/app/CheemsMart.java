package com.cheemsmart.app;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.cheemsmart.facade.TiendaFecade;

public class CheemsMart {
    // Colores ANSI
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BOLD = "\u001B[1m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TiendaFecade cliente = new TiendaFecade();
        int opcion = 0;
        while (true) {
            while (true) {
                System.out.println(ANSI_CYAN + "Bienvenido a CheemsMart" + ANSI_RESET);
                System.out.println(ANSI_BOLD + "User: " + ANSI_RESET);
                String usuario = sc.nextLine();
                System.out.println(ANSI_BOLD + "Password: " + ANSI_RESET);
                String password = sc.nextLine();
                try {
                    cliente.ingresar(usuario, password);
                    break;
                } catch (Exception e) {
                    System.err.println(ANSI_RED + e.getMessage() + ANSI_RESET);
                    System.out.println();
                }
            }
            opcion = mostrarMenuPrincipal(sc, cliente);
            if (opcion == 4) {
                cliente.cerrarSesion();
                sc.close();
                System.exit(0);
            }
        }
    }

    /**
     * Muestra el menú principal y maneja la interacción del usuario.
     *
     * @param sc      El objeto Scanner para entrada de usuario.
     * @param cliente El objeto TiendaFecade para interactuar con la tienda.
     * @return La opción seleccionada por el usuario.
     */
    public static int mostrarMenuPrincipal(Scanner sc, TiendaFecade cliente) {
        int opcion;
        do {
            cliente.menuPrincipal();
            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        cliente.mostrarMenu();
                        break;
                    case 2:
                        int option = 0;
                        while (option != 3) {
                            cliente.opciones();
                            try {
                                option = sc.nextInt();
                            } catch (InputMismatchException ime) {
                                cliente.error();
                                sc.nextLine();
                                continue;
                            }
                            switch (option) {
                                case 1:
                                    while (true) {
                                        cliente.request(option);
                                        try {
                                            int codigo = sc.nextInt();
                                            cliente.agregarProducto(codigo);
                                            break;
                                        } catch (InputMismatchException ime) {
                                            cliente.error();
                                            System.out.println();
                                            sc.nextLine();
                                            continue;
                                        } catch (NoSuchElementException nsee) {
                                            System.err.println(ANSI_RED + nsee.getMessage() + ANSI_RESET);
                                            System.out.println();
                                            sc.nextLine();
                                            continue;
                                        }
                                    }
                                    break;
                                case 2:
                                    while (true) {
                                        cliente.request(option);
                                        try {
                                            int cuenta = sc.nextInt();
                                            cliente.realizarCompra(cuenta);
                                            option = 3;
                                            break;
                                        } catch (InputMismatchException ime) {
                                            cliente.cuentaIncorrecta();
                                        }
                                    }
                                    break;
                                case 3:
                                    cliente.request(option);
                                    break;
                                default:
                                    cliente.error();
                                    option = -1;
                            }
                            sc.nextLine();
                        }
                        break;
                    case 3:
                        cliente.cerrarSesion();
                        break;
					case 4:
                            cliente.cerrarSesion();
                            sc.close();
                            System.exit(0);
                    default:
                        cliente.error();
                        System.out.println();
                        opcion = -1;
                }
            } catch (Exception e) {
                cliente.error();
                System.out.println();
                opcion = -1;
            }
        } while (opcion != 0);
        return opcion;
    }
}
