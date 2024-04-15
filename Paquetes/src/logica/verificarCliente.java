/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.regex.Pattern;
import clases.Cliente;
import clases.Direcciones;

/**
 *
 * @author omerb
 */
public class verificarCliente {

    public static boolean ValidaCedula(Cliente objCliente) {
        // Define la expresión regular para exactamente 10 números
        String regex = "\\d{10}"; // \d representa cualquier dígito, y {10} indica que debe repetirse 10 veces
        // Compila la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);
        // Usa el patrón para verificar si el String coincide con la expresión regular
        return pattern.matcher(objCliente.getCedula()).matches();
    }

    public static boolean validarDireccion(Direcciones direc) {
        // Expresión regular para validar la direccion
        return !direc.getCall1().equals(direc.getCall2());
    }

    public static boolean validarCorreo(Cliente objCliente) {
        // Expresión regular para validar correo electrónico
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.com|\\.[a-zA-Z0-9-]+\\.edu\\.ec)$";
        // Compila la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);
        // Usa el patrón para verificar si el correo coincide con la expresión regular
        return pattern.matcher(objCliente.getCorreo()).matches();
    }

   
}
