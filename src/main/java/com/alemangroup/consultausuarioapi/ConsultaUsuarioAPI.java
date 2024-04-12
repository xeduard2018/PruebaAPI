/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.alemangroup.consultausuarioapi;

/**
 *
 * @author Áleman Group
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ConsultaUsuarioAPI {

    public static void main(String[] args) {
        // Verificar si se proporcionó un nombre de usuario como argumento de línea de comandos
        if (args.length == 0) {
            System.out.println("No se ha proporcionado un nombre de usuario.");
            return;
        }
        
        String usuario = args[0];
        
        // Ruta al archivo de texto que contiene la lista de usuarios
        String archivoUsuarios = "usuarios.txt";
        
        // Leer el archivo de texto y verificar si el usuario está en la lista
        try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
            String linea;
            boolean autorizado = false;
            
            while ((linea = br.readLine()) != null) {
                if (linea.trim().equals(usuario)) {
                    autorizado = true;
                    break;
                }
            }
            
            // Devolver la respuesta
            if (autorizado) {
                System.out.println("El usuario " + usuario + " está autorizado.");
            } else {
                System.out.println("El usuario " + usuario + " no está autorizado.");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }
    }
}
