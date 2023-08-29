/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estudiantes;

import Mundo.Alumno;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Estudiantes {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        //creacion de la consola para poder ingresar datos
        Scanner consola = new Scanner(System.in);
        int opcion; 
        ArrayList<Alumno> listAlumnos = new ArrayList<Alumno>(); //Creacion de una lista para guardar los datos de estudiantes
        Alumno miAlumno = new Alumno();
        leerDatos(listAlumnos);
        //Creacion de un menu principal
        do {            
            mostrarMenu();
            opcion = consola.nextInt();
            
            switch (opcion) {
                case 1:
                    ingresarAlumno(listAlumnos);
                    break;
                case 2:

                    if(listAlumnos.isEmpty()){
                      System.out.println("No hay estudiantes registrados para eliminar");
                    }else{
                        eliminarAlumno(listAlumnos);
                        eliminarDatos(listAlumnos);
                       
                  }
                    
                    break;
                case 3:
                    if(listAlumnos.isEmpty()){
                        System.out.println("No hay estudiantes registrados para modificar");
                    }else{
                       modificarAlumno(listAlumnos);
                    }
                    break;
                case 4:
                    
                    if(listAlumnos.isEmpty()){
                        System.out.println("No hay estudiantes registrados");
                    }else{
                        mostrarAlumno(listAlumnos);
                        
                    }    
                    break;
                case 5:
                        crearReporte(listAlumnos, consola);

                    break;
                case 6:
                    eliminarDatos(listAlumnos);
                    crearReporte(listAlumnos, consola);
                    break;
                default:
                    System.out.println("Ingresa una opcion correcta");
                break;    
            }
            
        } while (opcion!=7);
       
    }
    //metodo para mostrar el menu
    public static void mostrarMenu(){
         System.out.println("¡Bienvenido!");
            System.out.println("--------Menu de opciones--------------");
            System.out.println("Ingresa la operacion c:");
            System.out.println("1. Ingresar alumno");
            System.out.println("2. Eliminar alumno");
            System.out.println("3. Modificar alumno");
            System.out.println("4. Consultar alumnos");
            System.out.println("5. Generar reporte de estudiantes por semestre");
            System.out.println("6. Eliminar reportes de estudiantes");
            System.out.println("7. Salir");
            System.out.println("------------------------");       
    }
    //metodo para ingresar alumno
    public static void ingresarAlumno(ArrayList<Alumno> listAlumnos){
           Scanner consola = new Scanner(System.in);
           Alumno miAlumno = new Alumno();//creacion de un objeto tipo Alumno para poder llamar los atributos de la clase alumno
           System.out.println("Ingresa la cedula del estudiante:");
           String cedula = consola.nextLine();
           miAlumno.setCedula(cedula);
           
           System.out.println("Ingresa el nombre del estudiante:");
           String nombre = consola.nextLine();
           miAlumno.setNombre(nombre);
           
           System.out.println("Ingresa el apellido del estudiante:");
           String apellido = consola.nextLine();
           miAlumno.setApellido(apellido);
           
           System.out.println("Ingresa el semestre del estudiante:");
           String semestre = consola.nextLine();
           miAlumno.setSemestre(semestre);
           
           System.out.println("Ingresa el correo del estudiante:");
           String correo = consola.next();
           miAlumno.setCorreo(correo);
           
           System.out.println("Ingresa el celular del estudiante:");
           String celular = consola.next();
           miAlumno.setCelular(celular);
           
           listAlumnos.add(miAlumno);
           
     }
    //metodo para mostrar alumno
    public static void mostrarAlumno(ArrayList<Alumno> listAlumnos){
        //recorre la lista con un for y muestra los datos guardados en el ArrayList
         for(Alumno alumno : listAlumnos){
            
                    System.out.println("------------------------------");
                    System.out.println("Datos del alumno:");
                    System.out.println("Nombre: " + alumno.getNombre());
                    System.out.println("Apellido: " + alumno.getApellido());
                    System.out.println("Cédula: " + alumno.getCedula());
                    System.out.println("Semestre: " + alumno.getSemestre());
                    System.out.println("Correo: " + alumno.getCorreo());
                    System.out.println("Celular: " + alumno.getCelular());
                    System.out.println("------------------------------");
   
         }
    }
    //metodo para modificar alumno
    public static void modificarAlumno(ArrayList<Alumno> listAlumnos){
        Scanner consola = new Scanner(System.in);
        System.out.println("Ingresa el numero de cedula del estudiante para modificarlo");
        String id = consola.next();
        int opcion;
        //recorre la lista y da al usuario la opcion de que dato quiere modificar 
        for(Alumno alumno: listAlumnos){
            if(alumno.getCedula().equals(id)){
                do{
                    System.out.println("Ingresa el dato que deseas modificar: ");
                    System.out.println("");
                    System.out.println("1. Modificar nombre");
                    System.out.println("2. Modificar apellido");
                    System.out.println("3. Modificar semestre");
                    System.out.println("4. Modificar correo");
                    System.out.println("5. Modificar celular");
                    System.out.println("6. Volver");
                    opcion = consola.nextInt();
                
                
                    switch (opcion) {
                        case 1:
                            System.out.print("Ingrese el nombre a modificar: ");
                            String nombreModificado = consola.next(); 
                        
                            if(!nombreModificado.isEmpty()){
                                alumno.setNombre(nombreModificado);
                            }   
                
                        break;
                        case 2:
                            System.out.print("Ingrese el apellido a modificar: ");
                            String apellidoModificado = consola.next();
                        
                            if(!apellidoModificado.isEmpty()){
                                alumno.setApellido(apellidoModificado);
                            }
                        break;
                        case 3:
                            System.out.print("Ingrese el semestre a modificar: ");
                            String semestreModificado = consola.nextLine();
                        
                            if(semestreModificado.isEmpty()){
                                alumno.setSemestre(semestreModificado);
                            }
                        break;
                        case 4:
                            System.out.print("Ingrese el correo a modificar: ");
                            String correoModificado = consola.next();
                        
                            if(!correoModificado.isEmpty()){
                                alumno.setCorreo(correoModificado);
                            }
                        break;
                        case 5:
                            System.out.print("Ingrese el celular a modificar: ");
                            String celularModificado = consola.next();
                        
                            if(!celularModificado.isEmpty()){
                                alumno.setCelular(celularModificado);
                            }
                        break;
                        default:
                            System.out.println("Ingresa una opcion correcta");
                    }
                }while(opcion !=6);
            }else{
                System.out.println("El numero de documento no se encuentra registrado");
            }
        
        
        }
        
    }
    //metodo para eliminar alumno
    public static void eliminarAlumno(ArrayList<Alumno> listAlumnos){
        Scanner consola = new Scanner(System.in);
        System.out.println("Ingresa el numero de cedula a eliminar");
        String idBorrar = consola.next();
        Alumno miAlumno = new Alumno();
        int opcion=0;
        for(Alumno alumno: listAlumnos){
            if(alumno.getCedula().equals(idBorrar)){
                System.out.println("El estudiante a borrar es: "); 
                System.out.println("Cedula: " + alumno.getCedula()); 
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("Apellido: " + alumno.getApellido());
                System.out.println("-------------------------------");
                
                miAlumno = alumno;
                
                System.out.println("¿Esta seguro que desea eliminarlo?");
                System.out.println("1. Si");
                System.out.println("2. No");
                opcion = consola.nextInt();
            }else{
                System.out.println("El numero de documento ingresado no existe");
                
            }
            
        }
            //Utiliza un .remove para eliminar de la lista el estudiante registrado
                if(opcion == 1){
                    listAlumnos.remove(miAlumno);
                    System.out.println("Alumno eliminado");
                }
    }
    //metodo para crear reporte de alumnos en un txt
    public static void crearReporte(ArrayList<Alumno> listAlumnos , Scanner consola)throws FileNotFoundException{
        File archivo = new File("./data/reporteEstudiantes.txt");
        
        PrintWriter pluma = new PrintWriter(archivo);
        
        if(!listAlumnos.isEmpty()){
            System.out.println("Ingrese el semestre para generar el reporte");
            String semestreCreado = consola.next();
        
            pluma.println("Reporte de estudiantes");
            pluma.println("-----------------------");
            System.out.println("Reporte creado");
            for(Alumno alumno: listAlumnos){
            if(alumno.getSemestre().equals(semestreCreado))
                pluma.println("----------------------");
                pluma.println("Datos del alumno: ");
                pluma.println("Nombre: " + alumno.getNombre());
                pluma.println("Apellido: " + alumno.getApellido());
                pluma.println("Cedula: " + alumno.getCedula());
                pluma.println("Semestre: " + alumno.getSemestre());
                pluma.println("Correo: " + alumno.getCorreo());
                pluma.println("Celular: " + alumno.getCelular());

          }  
             pluma.close();
        }else{
            System.out.println("No hay estudiantes de dicho semestre registrados");
        }
    
       
    }
    
    public static void leerDatos(ArrayList<Alumno> listAlumnos)throws IOException{
        File archivo = new File("./data/reporteEstudiantes.txt");
       
       
        try(FileReader fail = new FileReader(archivo)){
            BufferedReader cx = new BufferedReader(fail);
            
            if((cx.readLine()) != null){
                String datos[];
                datos = new String[6];        
                
                String cedula = datos[0];
                String nombre = datos [1];
                String apellido = datos [2];
                String semestre = datos [3];
                String correo = datos [4];
                String celular = datos [5];
                
            
                Alumno miAlumno = new Alumno(nombre, apellido, semestre, correo, celular, cedula);
                listAlumnos.add(miAlumno);
            
            }
        }catch(FileNotFoundException e){
            System.out.println("No existe ningun archivo");
        }
    }
    
    public static void eliminarDatos(ArrayList<Alumno> listAlumnos){
        if(!listAlumnos.isEmpty()){
            listAlumnos.clear();
            System.out.println("Se ha eliminado el reporte");
        }else{
            System.out.println("No hay datos que eliminar");
        }
        
    
    }
}
