/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paquetes;

import clases.Cliente;
import clases.Direcciones;
import clases.Estado;
import clases.Paquete;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import static logica.verificarCliente.ValidaCedula;
import static logica.verificarCliente.validarCorreo;
import static logica.verificarCliente.validarDireccion;

/**
 *
 * @author omerb
 */
public class Ejecutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String opc;
        Cliente cli = new Cliente();
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;
        do {
            System.out.println("-----Menu-----");
            System.out.println("1) Ingresar Cliente");
            System.out.println("2) Ingresar un Paquete");
            System.out.println("3) Cambiar el estado del paquete");
            System.out.println("4) Ingresar Direccion");
            System.out.println("5) Listar");
            System.out.println("6) Salir");
            System.out.print("Ingrese un opcion: ");
            opc = sc.nextLine();
            switch (opc) {
                case "1" -> {
                    insertarCliente(cli);
                }
                case "2" -> {
                    insertarPaquete(cli);
                }
                case "3" -> {
                    cambiarEstado(cli);
                }
                case "4" -> {
                    insertarDirecion(cli);
                }
                case "5" -> {
                    listar(cli);
                }
                case "6" -> {
                    bandera = false;
                }
                default -> {
                    System.out.println("Opción no válida");
                }
            }
        } while (bandera);

    }

    private static void insertarCliente(Cliente cli) {

        String aux;
        Scanner sc = new Scanner(System.in);
        if (cli.getApe() != null && cli.getNom() != null) {
            System.out.println("Ya existe un cliente");
        } else {
            System.out.print("Ingrese su nombre: ");
            aux = sc.nextLine();
            cli.setNom(aux);
            System.out.print("Ingrese su apellido: ");
            aux = sc.nextLine();
            cli.setApe(aux);
            System.out.print("Ingrese su cedula: ");
            aux = sc.nextLine();
            cli.setCedula(aux);
            if (!ValidaCedula(cli)) {
                System.out.println("Cedula no valida");
                cli.setApe(null);
                cli.setNom(null);
            } else {
                cli.setId(1);
                System.out.print("Ingrese su correo: ");
                aux = sc.nextLine();
                cli.setCorreo(aux);
                if (!validarCorreo(cli)) {
                    System.out.println("Ingrese bien el correo");
                    cli.setApe(null);
                    cli.setNom(null);
                    cli.setCorreo(null);
                } else {
                    System.out.println("Cliente ingresado");

                }
            }
        }

    }

    private static void insertarDirecion(Cliente cli) {
        Direcciones direc = new Direcciones();
        String aux;
        Scanner sc = new Scanner(System.in);
        if (cli.getApe() != null && cli.getNom() != null) {
            System.out.println("Ingrese su Direccion ");
            System.out.print("Calle 1: ");
            aux = sc.nextLine();
            direc.setCall1(aux);
            System.out.print("Calle 2: ");
            aux = sc.nextLine();
            direc.setCall2(aux);
            System.out.println("Referencia: ");
            aux = sc.nextLine();
            direc.setReferencia(aux);
            direc.setActual(true);
            if (!validarDireccion(direc)) {
                System.out.println("Ingrese bien la direccion");
            } else {
                if (!cli.getDireccioneses().isEmpty()) {
                    cli.getDireccioneses().get(cli.getDireccioneses().size() - 1).setActual(false);
                    direc.setId(cli.getDireccioneses().size() + 1);
                    cli.getDireccioneses().add(direc);

                } else {
                    direc.setId(1);
                    System.out.println("Direccion agregada");
                    cli.getDireccioneses().add(direc);

                }
            }
        } else {
            System.out.println("Ingrese primero un cliente");
        }
    }

    private static void listar(Cliente cli) {
        if (cli.getApe() != null && cli.getNom() != null) {
            System.out.println(cli.getPaquetes());
        } else {
            System.out.println("Ingrese primero un cliente");
        }
    }

    private static void insertarPaquete(Cliente cli) {
        String aux;
        Scanner sc = new Scanner(System.in);
        Paquete paque = new Paquete();

        if (cli.getApe() != null && cli.getNom() != null && !cli.getDireccioneses().isEmpty() && cli.getPaquetes()==null) {
            System.out.println("Ingrese el Codigo del paquete:");
            aux = sc.nextLine();
            paque.setCodigo(aux);
            System.out.println("Ingrese la descripcion del paquete:");
            aux = sc.nextLine();
            paque.setDescripcion(aux);
            paque.setAncho(obtenerNumero("Ingrese el ancho del paquete: "));
            paque.setLargo(obtenerNumero("Ingrese el largo del paquete: "));
            paque.setPeso(obtenerNumero("Ingrese el peso del paquete: "));
            cli.setPaquetes(paque);

        } else {
            System.out.println("Ingrese un Cliente y su direccion o ya esciste un paquete");
        }
    }

    private static double obtenerNumero(String pregunta) {
        Scanner scanner = new Scanner(System.in);
        double numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(pregunta);
            String input = scanner.nextLine();

            try {
                numero = Double.parseDouble(input);
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese solo números.");
            }
        }

        return numero;
    }

    private static void cambiarEstado(Cliente cli) {

        String aux, opc;
        Scanner sc = new Scanner(System.in);
        if (cli.getPaquetes() != null) {
            if (cli.getPaquetes().getEstados().get(1).getFecha() == null || cli.getPaquetes().getEstados().get(2).getFecha() == null) {
                System.out.println("Seleccione el estado que desea agregar");
                System.out.println("1) Despachado");
                System.out.println("2) Entregado");
                opc = sc.nextLine();
                System.out.println("Ingrese la fecha: ");
                aux = sc.nextLine();
                switch (opc) {
                    case "1" -> {
                        System.out.println("Estado agregado");
                        cli.getPaquetes().getEstados().get(1).setFecha(aux);

                    }
                    case "2" -> {
                        System.out.println("Estado agregado");
                        cli.getPaquetes().getEstados().get(2).setFecha(aux);

                    }
                    default -> {
                        System.out.println("Opción no válida no se agrego ningun estado");
                    }
                }
            } else {
                System.out.println("El paquete ya tiene todos los estado posibles");
            }
        } else {
            System.out.println("Ingrese un paquete");
        }

    }
}
