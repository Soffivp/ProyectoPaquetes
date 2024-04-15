/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author omerb
 */
public class Cliente {
    
    private int id;
    private String cedula;
    private String nom;
    private String ape;
    private String correo;
    private ArrayList<Direcciones> direccioneses;
    private ArrayList<Paquete> paquetes;

    public Cliente(int id, String cedula, String nom, String ape, String correo, ArrayList<Direcciones> direccioneses, ArrayList<Paquete> paquetes) {
        this.id = id;
        this.cedula = cedula;
        this.nom = nom;
        this.ape = ape;
        this.correo = correo;
        this.direccioneses = direccioneses;
        this.paquetes = paquetes;
    }

    public Cliente() {
        this.direccioneses= new ArrayList<>();
        this.paquetes=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList<Direcciones> getDireccioneses() {
        return direccioneses;
    }

    public void setDireccioneses(ArrayList<Direcciones> direccioneses) {
        this.direccioneses = direccioneses;
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(ArrayList<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    @Override
    public String toString() {
        String cadena = String.format("Cliente\n"
                + "Nombre: %s \n"
                + "Apellido: %s \n"
                + "Cedula: %s\n"
                + "Email: %s\n",
                getNom(),
                getApe(),
                getCedula(),
                getCorreo());
        for (Direcciones direccionese : direccioneses) {
            cadena=cadena+direccionese+"\n";
        }
        for (Paquete paquete : paquetes) {
             cadena=cadena+paquete+"\n";
        }
        return cadena;
       
    }
 
}
