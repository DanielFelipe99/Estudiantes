/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estudiantes;

import Mundo.Alumno;
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
    public static void main(String[] args) {
        // TODO code application logic here:
        //creacion de la consola para poder ingresar datos
        Scanner consola = new Scanner(System.in);
        int opcion;  
        ArrayList<Alumno> listAlumnos = new ArrayList<Alumno>(); //Creacion de una lista para guardar los datos de estudiantes
       
        //Creacion de un menu principal
        do {            
            System.out.println("¡Bienvenido!");
            System.out.println("--------Menu de opciones--------------");
            System.out.println("Ingresa la operacion c:");
            System.out.println("1. Ingresar alumno");
            System.out.println("2. Eliminar alumno");
            System.out.println("3. Modificar alumno");
            System.out.println("4. Consultar alumnos");
            System.out.println("5. Salir");
            System.out.println("------------------------"); 
            
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
                    break;
                default:
                    System.out.println("Ingresa una opcion correcta");
            }
            
        } while (opcion!=5);
       
    }
    
    
    //metodo para ignresar alumno
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
           int semestre = consola.nextInt();
           miAlumno.setSemestre(semestre);
           
           System.out.println("Ingresa el correo del estudiante:");
           String correo = consola.next();
           miAlumno.setCorreo(correo);
           
           System.out.println("Ingresa el celular del estudiante:");
           String celular = consola.next();
           miAlumno.setCelular(celular);
           
           listAlumnos.add(miAlumno);
           
     }
    //metoido para mostrar alumno
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
    //metoido para modificar alumno
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
                            int semestreModificado = consola.nextInt();
                        
                            if(semestreModificado != 0){
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
}
