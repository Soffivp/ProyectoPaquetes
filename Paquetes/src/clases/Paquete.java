/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author omerb
 */
public class Paquete {

    private int id;
    private String codigo;
    private String descripcion;
    private double peso;
    private double largo;
    private double ancho;
    private ArrayList<Estado> estados;

    public Paquete(int id, String codigo, String descripcion, double peso, double largo, double ancho, ArrayList<Estado> estados) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.largo = largo;
        this.ancho = ancho;
        this.estados = estados;
    }

    public Paquete() {
        this.estados = new ArrayList<>();
        Estado estado1 = new Estado(1, "Creado", fechaActual());
        Estado es2 = new Estado(2, "Despachado", null);
        Estado es3 = new Estado(3, "Entregado", null);
        estados.add(estado1);
        estados.add(es2);
        estados.add(es3);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }

    private static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }

    @Override
    public String toString() {
        String cadena = String.format("Paquete\n"
                + "Codigo: %s \n"
                + "Descripcion: %s \n"
                + "Peso: %.2f\n"
                + "Largo: %.2f\n"
                + "Ancho: %.2f\n"
                + "Estados:\n",
                getCodigo(),
                getDescripcion(),
                getPeso(),
                getLargo(),
                getAncho());
        for (Estado es : estados) {
            cadena = cadena + es + "\n";
        }

        return cadena;
    }

}
