/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package app.appumgalgoritmos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Se tomo el codigo de referencia de clase 5-10-2024 y se agregaron algunas modificaciones.
 * @author ErickHernandez
 */
public class ClientesApp {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
Scanner scan = new Scanner(System.in); //Este scanner que se creó en esta linea 28 se utilizará para almacenar las opciones que el usuario elija.
Scanner teclado = new Scanner(System.in); // Se crea para pedirle al usuario si desea realizar otra opcion dentro de la clase Clientes
String continuar; 
        
        int opcion = 0;
        
        File f = new File("Clientes.txt"); //Se define un archivo y su ruta relativa en este caso de Clientes
        do {
        System.out.println("1. Agregar registro");
        System.out.println("2. Leer registros");
        System.out.println("3. Actualizar registro");
        System.out.println("4. Eliminar registro");
        System.out.print("Seleccione operacion a realizar: ");
        opcion = scan.nextInt();
        Scanner scanCliente = new Scanner(System.in);
        Scanner idCliente = new Scanner(System.in);
      
        switch (opcion) {
            case 1: 
                    try {
                        FileWriter fw = new FileWriter(f,true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        System.out.println("Ingrese su DPI");
                        String dpiCliente = idCliente.nextLine();
                        System.out.println("Ingrese el nombre del cliente");
                        String nombreCliente = scanCliente.nextLine();
                        System.out.println("Ingrese el apellido del cliente");
                        String apellidoCliente = scanCliente.nextLine();
                        System.out.println("Ingrese M si es Masculino o F si es Femenino");
                        String edadCliente = scanCliente.nextLine();
                        System.out.println("Ingrese la edad del Cliente");
                        String generoCliente = scanCliente.nextLine();
                        System.out.println("Ingrese su Profesion");
                        String profesionCliente = scanCliente.nextLine();
                        
                        bw.write(dpiCliente + "|" + nombreCliente + "|" + apellidoCliente + "|" +generoCliente+"|"+ edadCliente + "|" + profesionCliente+ "\n" );
                        bw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ClientesApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            case 2: 
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr);
                        String linea = "";
                        while((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        } 
                        br.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ClientesApp.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(ClientesApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            case 3:
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr);
                        
                        File fc = new File("Clientes_copia.txt");
                        FileWriter fw = new FileWriter(fc);
                        BufferedWriter bw = new BufferedWriter(fw);
                        Scanner cambioDatos = new Scanner(System.in);
                        String linea = "";
                        System.out.println("Ingrese el DPI para encontrar el cliente: ");
                        String dpiCliente = cambioDatos.nextLine();
                        boolean clienteEncontrado = false;
                        
                        
                        while((linea = br.readLine()) != null) {
                            String [] datos = linea.split("\\|");
                            if (datos[0].compareTo(dpiCliente) == 0) {
                                clienteEncontrado = true;
                                Scanner tecladoCambio = new Scanner(System.in);
                                System.out.println("Que desea realizar");
                                System.out.println("1. Cambiar nombre");
                                System.out.println("2. Cambiar Apellido");
                                System.out.println("3. Cambiar Genero");
                                System.out.println("4. Cambiar Edad");
                                System.out.println("5. Cambiar Profesion");
                                int opcionCambio = tecladoCambio.nextInt();
                                switch (opcionCambio){
                                    case 1: 
                                        System.out.println("Ingrese el nuevo Nombre del Cliente: ");
                                        String nombreNuevoCliente = cambioDatos.nextLine();
                                        datos[1]= nombreNuevoCliente;
                                        break;
                                    case 2:
                                        System.out.println("Ingrese el nuevo Apellido del Cliente: ");
                                        String apellidoNuevoCliente = cambioDatos.nextLine();
                                        datos[2] = apellidoNuevoCliente;
                                        break;
                                    case 3:
                                        System.out.println("Ingrese el nuevo Genero del Cliente: ");
                                        String nuevoGeneroCliente = cambioDatos.nextLine();
                                        datos[3] = nuevoGeneroCliente;
                                        break;
                                    case 4 :
                                        System.out.println("Ingrese la nueva Edad del Cliente: ");
                                        String nuevaEdadCliente = cambioDatos.nextLine();
                                        datos[4] = nuevaEdadCliente;
                                        break;
                                    case 5 :
                                        System.out.println("Ingrese la nueva Profesion del Cliente: ");
                                        String nuevaProfesionCliente = cambioDatos.nextLine();
                                        datos[5] = nuevaProfesionCliente;
                                        break;
                                    default :
                                        System.out.println("Opcion invalida");
                                        break;
                                    }
                            
                            }
                        bw.write(String.join("|",datos) + "\n");   
                        }
                        bw.close();
                        br.close();
                        
                        
                        Files.move(fc.toPath(), f.toPath(), REPLACE_EXISTING);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ClientesApp.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(ClientesApp.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    break;
            case 4: 
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr);
                        
                        File fc = new File("Clientes_copia.txt");
                        FileWriter fw = new FileWriter(fc);
                        BufferedWriter bw = new BufferedWriter(fw);
                        Scanner EliminarDatos = new Scanner(System.in);
                        String linea = "";
                        System.out.println("Ingrese el DPI del usuario a eliminar");
                        String eliminaRegistro = EliminarDatos.nextLine();
                                           
                        
                        while((linea = br.readLine()) != null) {
                            String [] datos = linea.split("\\|");
                            if (datos[0].compareTo(eliminaRegistro) != 0) {
                                bw.write(linea+"\n");
                            }
                        } 
                        
                        bw.close();
                        br.close();
                        
                        Files.move(fc.toPath(), f.toPath(), REPLACE_EXISTING);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ClientesApp.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(ClientesApp.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    break;
            default: System.out.println("Ingrese una opción válida.");
        }
         System.out.print("¿Desea realizar otra operacion en la ventana clientes? (s/n): ");
            continuar = teclado.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        teclado.close();
        
    }
}
