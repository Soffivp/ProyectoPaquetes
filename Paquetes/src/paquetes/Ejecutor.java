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
import java.util.ArrayList;
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
        ArrayList<Cliente> clientes = new ArrayList<>();
        String opc;
        int a;
        Cliente cli = new Cliente();
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;
        do {
            System.out.println("-----Menu-----");
            System.out.println("1) Ingresar Cliente");
            System.out.println("2) Ingresar un Paquete");
            System.out.println("3) Ingresar Direccion");
            System.out.println("4) Listar");
            System.out.println("5) Salir");
            System.out.print("Ingrese un opcion: ");
            opc = sc.nextLine();
            switch (opc) {
                case "1" -> {
                    insertarCliente(clientes);
                }
                case "2" -> {
                    System.out.println("Ingrese la cedula del cliente");
                    opc = sc.nextLine();
                    cli.setCedula(opc);
                    a = buscarCliente(clientes, cli);
                    if (a == -1) {
                        System.out.println("No existe el cliente");
                    } else {
                        cli = clientes.get(a);
                        insertarPaquete(cli);
                        clientes.add(a, cli);
                    }
                }
                case "3" -> {
                    System.out.println("Ingrese la cedula del cliente");
                    opc = sc.nextLine();
                    cli.setCedula(opc);
                    a = buscarCliente(clientes, cli);
                    if (a == -1) {
                        System.out.println("No existe el cliente");
                    } else {
                        cli = clientes.get(a);
                        insertarDirecion(cli);
                        clientes.add(a, cli);
                    }
                }
                case "4" -> {
                    listar(clientes);
                }
                case "5" -> {
                    bandera = false;
                }
                default -> {
                    System.out.println("Opción no válida");
                }
            }
        } while (bandera);

    }

    private static void insertarCliente(ArrayList<Cliente> clientes) {
        Cliente cli = new Cliente();
        String aux;
        Scanner sc = new Scanner(System.in);
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
        } else {
            cli.setId(1);
            System.out.print("Ingrese su correo: ");
            aux = sc.nextLine();
            cli.setCorreo(aux);
            if (!validarCorreo(cli)) {
                System.out.println("Ingrese bien el correo");
            } else {
                cli.setId(clientes.size() + 1);
                clientes.add(cli);
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
                    cli.getDireccioneses().add(direc);
                    direc.setId(1);
                }
            }
        } else {
            System.out.println("Ingrese primero un cliente");
        }
    }

    private static void listar(ArrayList<Cliente> clientes) {
        if (!clientes.isEmpty()) {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        } else {
            System.out.println("Ingrese primero un cliente");
        }
    }

    private static void insertarPaquete(Cliente cli) {
        String aux;
        Scanner sc = new Scanner(System.in);
        Paquete paque = new Paquete();
        Estado estado1 = new Estado(1, "Creado", fechaActual());
        Estado estado2 = new Estado(2, "Despachado", fechaActual());
        Estado estado3 = new Estado(3, "Entregado", fechaActual());
        if (cli.getApe() != null && cli.getNom() != null && !cli.getDireccioneses().isEmpty()) {
            System.out.println("Ingrese el Codigo del paquete:");
            aux = sc.nextLine();
            paque.setCodigo(aux);
            System.out.println("Ingrese la descripcion del paquete:");
            aux = sc.nextLine();
            paque.setDescripcion(aux);
            paque.setAncho(obtenerNumero("Ingrese el ancho del paquete: "));
            paque.setLargo(obtenerNumero("Ingrese el largo del paquete: "));
            paque.setPeso(obtenerNumero("Ingrese el peso del paquete: "));
            paque.getEstados().add(estado1);
            paque.getEstados().add(estado2);
            paque.getEstados().add(estado3);
            if (!cli.getPaquetes().isEmpty()) {
                paque.setId(cli.getPaquetes().size() + 1);
                cli.getPaquetes().add(paque);
            } else {
                paque.setId(1);
                cli.getPaquetes().add(paque);
            }

        } else {
            System.out.println("Ingrese un Cliente y su direccion");
        }
    }

    private static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
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

    private static int buscarCliente(ArrayList<Cliente> clientes, Cliente cli) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCedula().equals(cli.getCedula())) {
                return i;
            }
        }
        return -1;
    }
}
