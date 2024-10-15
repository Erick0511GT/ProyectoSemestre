/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 * @author Erick Hernandez
 */
/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
*/

package app.appumgproyecto;

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

public class AppUmgProyecto {

   public static void main(String[] args) throws IOException {
       
//        System.out.println("Hello World!");
    Scanner scan = new Scanner(System.in); //Este scanner que se creó en esta linea 28 se utilizará para almacenar las opciones que el usuario elija.
    Scanner teclado = new Scanner(System.in); // Se crea para pedirle al usuario si desea realizar otra opcion dentro de la clase Clientes
    Scanner menu = new Scanner(System.in);// Se crea este scanner para el menu de Modulos
    String continuar; 
    String continuarMenu;
    do {
        System.out.println("BIENVENIDO AL SISTEMA DE INVENTARIOS UMG"); 
       int opcionMenu;
       System.out.println("Seleccione el modulo al que desea ingresar");
       System.out.println("1. Clientes");
       System.out.println("2. Proveedores");
       System.out.println("3. Productos");
       System.out.println("4. Compras");
       System.out.println("5. Ventas");
       System.out.println("6. Usuarios");
       System.out.println("Seleccione el modulo al que desea ingresar: ");
       opcionMenu = scan.nextInt();
       switch (opcionMenu){
            case 1: // Se inicia el modulo de Clientes
               System.out.println("Bienvenidos al modulo de Clientes");        
               int opcionCliente;  
               File f = new File("Clientes.txt"); //Se define un archivo y su ruta relativa en este caso de Clientes
               do { //Se inicia solicitando que accion realizará el usuario en el modulo de clientes
                    System.out.println("1. Agregar registro");
                    System.out.println("2. Leer registros");
                    System.out.println("3. Actualizar registro");
                    System.out.println("4. Eliminar registro");
                    System.out.println("5. Descargar reporte a CSV");
                    System.out.print("Seleccione operacion a realizar: ");
                    opcionCliente = scan.nextInt();
                    Scanner scanCliente = new Scanner(System.in);
                    Scanner scanidCliente = new Scanner(System.in);
     
                    switch (opcionCliente) {
                        case 1 -> { 
                            try { /*En este case 1 se pide que el usuario ingrese los datos del cliente*/
                                FileWriter fw = new FileWriter(f,true);
                                BufferedWriter bw = new BufferedWriter(fw);
                                System.out.println("Ingrese su DPI");
                                String dpiCliente = scanidCliente.nextLine();
                                System.out.println("Ingrese el nombre del cliente");
                                String nombreCliente = scanCliente.nextLine();
                                System.out.println("Ingrese el apellido del cliente");
                                String apellidoCliente = scanCliente.nextLine();
                                System.out.println("Ingrese M si es Masculino o F si es Femenino");
                                String generoCliente = scanCliente.nextLine();
                                System.out.println("Ingrese la edad del Cliente");
                                String edadCliente = scanCliente.nextLine();
                                System.out.println("Ingrese su Profesion");
                                String profesionCliente = scanCliente.nextLine();
                                bw.write(dpiCliente + "|" + nombreCliente + "|" + apellidoCliente + "|" +generoCliente+"|"+ edadCliente + "|" + profesionCliente+ "\n" );
                                bw.close();

                            } catch (IOException ex) {
                                Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        case 2 -> { //Aqui se manda a llamar los datos del archivo.
                            try {
                                FileReader fr = new FileReader(f);
                                BufferedReader br = new BufferedReader(fr);
                                String linea = "";
                                while((linea = br.readLine()) != null) {
                                    System.out.println(linea);
                                } 
                                br.close();
                                fr.close();
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        case 3 -> { // Se realiza la modificacion por el dato que elija el usuario
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
                                        System.out.println(linea);
                                        
                                        clienteEncontrado = true;
                                        Scanner tecladoCambio = new Scanner(System.in);
                                        System.out.println("Que desea realizar");
                                        System.out.println("1. Cambiar nombre");
                                        System.out.println("2. Cambiar Apellido");
                                        System.out.println("3. Cambiar Genero");
                                        System.out.println("4. Cambiar Edad");
                                        System.out.println("5. Cambiar Profesion");
                                        int opcionCambioCliente = tecladoCambio.nextInt();
                                        switch (opcionCambioCliente){
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
                                Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                            }
               }
                        case 4 -> { // Se le pide al usuario que ingrese el DPI del cliente y se confirma si desea eliminar el cliente
                            try {
                                FileReader fr = new FileReader(f);
                                BufferedReader br = new BufferedReader(fr);
                                File fc = new File("Clientes_copia.txt");
                                FileWriter fw = new FileWriter(fc);
                                BufferedWriter bw = new BufferedWriter(fw);
                                Scanner eliminaDatos = new Scanner(System.in);
                                String linea = "";
                                System.out.println("Ingrese el DPI del cliente a eliminar");
                                String eliminaRegistro = eliminaDatos.nextLine();
                                while((linea = br.readLine()) != null) {
                                    String [] datos = linea.split("\\|");
                                    if (datos[0].compareTo(eliminaRegistro) != 0) {
                                        bw.write(linea+"\n");
                                    }
                                }
                                bw.close();
                                br.close();
                                //En este bloque del se pide una confirmacion para eliminar el cliente
                                System.out.println("Esta seguro que de quiere eliminar el cliente  s/n");
                                String confirmar = eliminaDatos.nextLine();
                                if (confirmar.equalsIgnoreCase("s")){
                                Files.move(fc.toPath(), f.toPath(), REPLACE_EXISTING);
                                }else
                                 break;
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                              }
                        }
                        case 5 -> { // Se realiza el reporte de CSV
                            try {
                                FileReader fr = new FileReader(f);
                                BufferedReader br = new BufferedReader(fr);
                                File fc = new File("Clientes_Reporte.csv");
                                FileWriter fw = new FileWriter(fc);
                                BufferedWriter bw = new BufferedWriter(fw);
                                String lineaEncabezado = "DPI|Nombre|Apellido|Genero|Edad|Profesion";
                                String linea = "";
                                bw.write(lineaEncabezado+"\n");
                                while((linea = br.readLine()) != null) {
                                    String [] datos = linea.split("\\|");
                                    if (datos != null) {
                                    bw.write(linea+"\n");
                                    }
                                }
                                bw.close();
                                br.close();

                                Files.copy(fc.toPath(), fc.toPath(),REPLACE_EXISTING);
                                System.out.println("El reporte fue realizado con éxito. Por favor validar");
                                
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                              }
                        }
                        default -> { // En caso no coloque los numeros indicados
                            System.out.println("Opción incorrecta. Ingrese una opción válida.");
                            
                        }
                    }
                    System.out.print("¿Desea realizar otra operacion en la ventana clientes? (s/n): ");
                    continuar = teclado.nextLine();
                   
                } while (continuar.equalsIgnoreCase("s"));
                if (!continuar.equalsIgnoreCase("s")){
                    break;
                } // se cierra el ciclo de clientes
               
            case 2: // Se inicia el modulo de Proveedores
               System.out.println("Bienvenidos al modulo de Proveedores");        
               int opcionProveedor;
               File p = new File("Proveedores.txt"); //Se define un archivo y su ruta relativa en este caso de Proveedores
               do{
                //Se inicia solicitando las acciones que realizar el usuario
                System.out.println("1. Agregar registro");
                System.out.println("2. Leer registros");
                System.out.println("3. Actualizar registro");
                System.out.println("4. Eliminar registro");
                System.out.println("5. Descargar reporte CSV");
                System.out.print("Seleccione operacion a realizar: ");
                opcionProveedor = scan.nextInt();
                Scanner scanProveedor = new Scanner(System.in);
                Scanner scanidProveedor = new Scanner(System.in);
                switch (opcionProveedor) {
                    case 1 -> {
                        //Se llenan los datos del Proveedor
                        try {
                            FileWriter fw = new FileWriter(p,true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            System.out.println("Ingrese el codigo de Proveedor");
                            String codigoProveedor = scanidProveedor.nextLine();
                            System.out.println("Ingrese el Nombre o Razon Social del proveedor");
                            String nombreProveedor = scanProveedor.nextLine();
                            System.out.println("Ingrese la Direccion del proveedor");
                            String direccionProveedor = scanProveedor.nextLine();
                            System.out.println("Ingrese L si es Local o E si es Extranjero");
                            String tipoProveedor = scanProveedor.nextLine();
                            System.out.println("Ingrese el telefono del Proveedor");
                            String telefonoProveedor = scanProveedor.nextLine();
                            bw.write(codigoProveedor + "|" + nombreProveedor + "|" + direccionProveedor + "|" +tipoProveedor+"|"+ telefonoProveedor  + "\n" );
                            bw.close();
                        } catch (IOException ex) {
                            Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    case 2 -> {
                        // Se llaman todos los datos del archivo
                        try {
                            FileReader fr = new FileReader(p);
                            BufferedReader br = new BufferedReader(fr);
                            String linea = "";
                            while((linea = br.readLine()) != null) {
                                System.out.println(linea);
                            }
                            br.close();
                            fr.close();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    case 3 -> {
                        // Se solicita cambiar segun la opción que elija el usuario
                        try {
                            FileReader fr = new FileReader(p);
                            BufferedReader br = new BufferedReader(fr);
                            File fp = new File("Proveedores_copia.txt");
                            FileWriter fw = new FileWriter(fp);
                            BufferedWriter bw = new BufferedWriter(fw);
                            Scanner cambioDatos = new Scanner(System.in);
                            String linea = "";
                            System.out.println("Ingrese el codigo de Proveedor para encontrarlo en la base: ");
                            String codigoProveedor = cambioDatos.nextLine();
                            while((linea = br.readLine()) != null) {
                                String [] datos = linea.split("\\|");
                                if (datos[0].compareTo(codigoProveedor) == 0) {
                                    System.out.println(linea);
                                    Scanner tecladoCambio = new Scanner(System.in);
                                    System.out.println("Que desea realizar");
                                    System.out.println("1. Cambiar Nombre o Razon Social");
                                    System.out.println("2. Cambiar Direccion");
                                    System.out.println("3. Cambiar Si es Local o Extranjero");
                                    System.out.println("4. Cambiar Telefono");
                                    int opcionCambioProveedor = tecladoCambio.nextInt();
                                    switch (opcionCambioProveedor){
                                        case 1 -> {
                                            System.out.println("Ingrese el nuevo Nombre del Proveedor: ");
                                            String nombreNuevoProveedor = cambioDatos.nextLine();
                                            datos[1]= nombreNuevoProveedor;
                                        }
                                        case 2 -> {
                                            System.out.println("Ingrese la nueva Direccion del Proveedor: ");
                                            String nuevaDireccionProveedor = cambioDatos.nextLine();
                                            datos[2] = nuevaDireccionProveedor;
                                        }
                                        case 3 -> {
                                            System.out.println("Ingrese L si será Local o E si será Extranjero : ");
                                            String nuevoTipoProveedor = cambioDatos.nextLine();
                                            datos[3] = nuevoTipoProveedor;
                                        }
                                        case 4 -> {
                                            System.out.println("Ingrese el nuevo Telefono del Proveedor: ");
                                            String nuevoTelefono = cambioDatos.nextLine();
                                            datos[4] = nuevoTelefono;
                                        }
                                        default -> System.out.println("Opcion invalida");
                                    }
                                }
                                bw.write(String.join("|",datos) + "\n");
                            }
                            bw.close();
                            br.close();
                            Files.move(fp.toPath(), p.toPath(), REPLACE_EXISTING);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    case 4 -> {
                        // Se realiza la eliminacion del proveedor
                        try {
                            FileReader fr = new FileReader(p);
                            BufferedReader br = new BufferedReader(fr);
                            File fp = new File("Proveedores_copia.txt");
                            FileWriter fw = new FileWriter(fp);
                            BufferedWriter bw = new BufferedWriter(fw);
                            Scanner eliminaDatos = new Scanner(System.in);
                            String linea = "";
                            System.out.println("Ingrese el codigo del proveedor a eliminar");
                            String eliminaRegistro = eliminaDatos.nextLine();
                            while((linea = br.readLine()) != null) {
                                String [] datos = linea.split("\\|");
                                if (datos[0].compareTo(eliminaRegistro) == 0) {
                                    System.out.println(linea);
                                }
                                if (datos[0].compareTo(eliminaRegistro) != 0) {
                                    bw.write(linea+"\n");
                                }
                            }
                            bw.close();
                            br.close();
                            System.out.println("Esta seguro de que quiere eliminar el proveedor! s/n");
                            String confirmar = eliminaDatos.nextLine();
                            if (confirmar.equalsIgnoreCase("s")){
                                Files.move(fp.toPath(), p.toPath(), REPLACE_EXISTING);
                            } else
                                break;
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    case 5 -> { // Se realiza el reporte de CSV
                            try {
                                FileReader fr = new FileReader(p);
                                BufferedReader br = new BufferedReader(fr);
                                File fp = new File("Proveedores_Reporte.csv");
                                FileWriter fw = new FileWriter(fp);
                                BufferedWriter bw = new BufferedWriter(fw);
                                String lineaEncabezado = "codigo|NombreProveedor|Direccion|Tipo|Telefono";
                                String linea = "";
                                bw.write(lineaEncabezado+"\n");
                                while((linea = br.readLine()) != null) {
                                    String [] datos = linea.split("\\|");
                                    if (datos != null) {
                                    bw.write(linea+"\n");
                                    }
                                }
                                
                                bw.close();
                                br.close();

                                Files.copy(fp.toPath(), fp.toPath(),REPLACE_EXISTING);
                                System.out.println("El reporte fue realizado con éxito. Por favor validar");
                                
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(AppUmgProyecto.class.getName()).log(Level.SEVERE, null, ex);
                              }
                        }
                    default -> {//se envia una impresion de que el dato ingresado no es valido
                        System.out.println("Opción incorrecta. Ingrese una opción válida");
                    }        
                }
                System.out.print("¿Desea realizar otra operacion en la vista de Proveedores? (s/n): ");
                continuar = teclado.nextLine();

               }while (continuar.equalsIgnoreCase("s"));
                if (!continuar.equalsIgnoreCase("s")){
                break;
                }
            case 3: // Se inicia el modulo de Productos
                System.out.println("Bienvenidos al modulo de Productos!!!!");
                int opcionProducto;
                File pR = new File("Productos.txt");
                File cF = new File("Categorias.txt");
                do{        
                   System.out.println("1. Agregar registro");
                   System.out.println("2. Leer registros");
                   System.out.println("3. Actualizar registro");
                   System.out.println("4. Eliminar registro");
                   System.out.println("5. Ir a Categorias");
                   System.out.print("Seleccione operacion a realizar: ");
                    opcionProducto = scan.nextInt();
                    Scanner scanProducto = new Scanner(System.in);
                    Scanner scanIdProducto = new Scanner(System.in);
                    switch (opcionProducto){
                        case 1 -> {
                            FileWriter fw = new FileWriter(pR,true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            System.out.println("Ingrese el codigo de Categoria para crear el producto");
                            String codigoCatogoria = scanIdProducto.nextLine();
                            System.out.println("Ingrese el nombre del Producto");
                            String nombreProducto = scanProducto.nextLine();
                            bw.close();
                            fw.close();
                        }
                        case 5 -> { 
                                   do{
                                    Scanner scancategoria = new Scanner(System.in);
                                    System.out.println("Bienvenido a las categorias!!!!!");
                                    System.out.println("1. Agregar registro");
                                    System.out.println("2. Leer registros");
                                    System.out.println("3. Actualizar registro");
                                    System.out.println("4. Eliminar registro");
                                    System.out.println("5. Descargar archivo CSV");
                                    int opcionCategoria;
                                    System.out.println("Escriba el numero de opcion que desea elegir: ");
                                    opcionCategoria = scan.nextInt();
                                    switch (opcionCategoria) {
                                        case 1 -> {
                                            try (FileWriter fw = new FileWriter(cF,true); 
                                                BufferedWriter bw = new BufferedWriter(fw)) {
                                                System.out.println("Ingrese el codigo de Categoria");
                                                String codigoCategoria = scancategoria.nextLine();
                                                System.out.println("Ingrese el Prefijo de la Categoria");
                                                String prefijoCategoria = scancategoria.nextLine();
                                                System.out.println("Ingrese la descripcion de la Categoria");
                                                String descCategoria = scancategoria.nextLine();
                                                bw.write(codigoCategoria +"|"+prefijoCategoria+"|"+descCategoria+"\n");
                                            }
                                        }

                                        case 2 -> {
                                            try (FileReader fr = new FileReader(cF); 
                                                BufferedReader br = new BufferedReader(fr)) {
                                                String linea = "";
                                                while((linea = br.readLine()) != null) {
                                                    System.out.println(linea);
                                                }
                                            }
                                        }

                                        case 3 -> {                        
                                            FileReader fr = new FileReader(cF);
                                            BufferedReader br = new BufferedReader(fr);
                                            File cfc = new File("Categoria_copia.txt");
                                            FileWriter fw = new FileWriter(cfc);
                                            BufferedWriter bw = new BufferedWriter(fw);
                                            Scanner cambioDatos = new Scanner(System.in);
                                            String linea;
                                            System.out.println("Ingrese el codigo de Categoria");
                                            String codigoCategoria = cambioDatos.nextLine();
                                            while((linea = br.readLine()) != null) {
                                                String [] datos = linea.split("\\|");
                                                if (datos[0].compareTo(codigoCategoria) == 0) {
                                                    System.out.println(linea);
                                                    Scanner tecladoCambio = new Scanner(System.in);
                                                    System.out.println("Que desea realizar");
                                                    System.out.println("1. Cambiar prefijo");
                                                    System.out.println("2. Cambiar Descripcion");
                                                    int opcionCambioProveedor = tecladoCambio.nextInt();
                                                    switch (opcionCambioProveedor){
                                                        case 1 -> {
                                                            System.out.println("Ingrese el nuevo Prefijo de la categoria: ");
                                                            String nuevoPrefijo = cambioDatos.nextLine();
                                                            datos[1]= nuevoPrefijo;
                                                        }
                                                        case 2 -> {
                                                            System.out.println("Ingrese la nueva Descripcion de la categoria: ");
                                                            String nuevaDescripcion = cambioDatos.nextLine();
                                                            datos[2] = nuevaDescripcion;
                                                        }
                                                        default -> System.out.println("Opcion invalida");
                                                    }
                                                }
                                                bw.write(String.join("|",datos) + "\n");
                                            }
                                            bw.close();
                                            br.close();
                                            Files.move(cfc.toPath(), cF.toPath(), REPLACE_EXISTING);
                                        }
                                    }
                                       System.out.println("desea realizar otra operacion en Categorias s/n");
                                       continuar = teclado.nextLine();
                                    } while(continuar.equalsIgnoreCase("s"));
                                    if (!continuar.equalsIgnoreCase("s")){
                                    break;
                                    }
                        }
                    }
                    
                System.out.println("Desea realizar otra operacion en la vista de Productos s/n");
                continuar = teclado.nextLine();
                } while (continuar.equalsIgnoreCase("s"));
                if (!continuar.equalsIgnoreCase("s")){
                    break;
                }
            default: System.out.println("Opcion incorrecta. Por favor ingrese una opción válida.");
               
        }
     System.out.print("¿Desea realizar otra operacion en la aplicacion? (s/n): ");
     continuarMenu = menu.nextLine();
    } while (continuarMenu.equalsIgnoreCase("s"));
    
    scan.close();
  }
}