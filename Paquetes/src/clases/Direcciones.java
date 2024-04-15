/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author omerb
 */
public class Direcciones {

    private int id;
    private String call1;
    private String call2;
    private String referencia;
    private boolean actual;

    public Direcciones(int id, String call1, String call2, String referencia, boolean actual) {
        this.id = id;
        this.call1 = call1;
        this.call2 = call2;
        this.referencia = referencia;
        this.actual = actual;
    }

    public Direcciones() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCall1() {
        return call1;
    }

    public void setCall1(String call1) {
        this.call1 = call1;
    }

    public String getCall2() {
        return call2;
    }

    public void setCall2(String call2) {
        this.call2 = call2;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }

    @Override
    public String toString() {
        return "Direcciones{" + "call1=" + call1 + ", call2=" + call2 + ", referencia=" + referencia + ", actual=" + actual + '}';
    }
  

}
