package org.josecano.sistema;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.josecano.dao.VehiculoJpaController;
import org.josecano.dao.exceptions.NonexistentEntityException;
import org.josecano.dominio.Vehiculo;


public class Principal {
    private static Scanner sc = new Scanner(System.in);
    private static Scanner svehiculo = new Scanner(System.in);
    private static Vehiculo v;
    private static VehiculoJpaController vehiculoDao = new VehiculoJpaController();
    private static int op, id;     
    
    public static void main(String[] args) {
        //Definir el menu
        System.out.println("------------------------------------");
        System.out.println("--------- Menu de Opciones ---------");
        System.out.println("------------------------------------");
        System.out.println("-1. Buscar Vehiculos ---------------");
        System.out.println("-2. Agregar Vehiculo ---------------");
        System.out.println("-3. Actualizar Vehiculo ------------");
        System.out.println("-4. Eliminar Vehiculo --------------");
        System.out.println("-5. Listar Vehiculos ---------------");
        System.out.println("------------------------------------");
        System.out.println("--- Ingrese una opcion a realizar---");
        op = sc.nextInt();
        switch(op){
            case 1:
                v = obtenerVehiculo();
                System.out.println(v);
                break;
                
            case 2:
                v = getVehiculo();
                if (vehiculoDao.agregarVehiculo(v))
                    System.out.println("Se ha agregado un vehiculo");
                else
                    System.out.println("No se pudo agregar el vehiculo");
                break;
                
            case 3:
                v = obtenerVehiculo();
                System.out.println(v);
                System.out.println("Ingrese los nuevos datos del vehiculo");
                v = new Vehiculo(id, svehiculo.nextLine(), svehiculo.nextLine(), svehiculo.nextLine(), svehiculo.nextLine());
        
                try {
                    vehiculoDao.editarVehiculo(v);
                } catch (Exception ex) {
                    System.out.println("No se puede actualizar el registro!");
                }
        
                break;
                
            case 4:
                v = obtenerVehiculo();
                System.out.println("Esta seguro de eliminar el Vehiculo?");
                System.out.println(v);
        
                try {
                    vehiculoDao.eliminarVehiculo(id);
                    System.out.println("Registro eliminado exitosamente!");
                } catch (NonexistentEntityException ex) {
                    System.out.println("No se puede eliminar el registro");                }

                break;
                
            case 5:
                List<Vehiculo> personas = vehiculoDao.listarVehiculos();
                for(Iterator<Vehiculo>iterator = personas.iterator();iterator.hasNext();){
                    Vehiculo next = iterator.next();
                    System.out.println(next);
                }
                break;
            default:
                System.out.println("No es una opcion del menu...");
        }
        
        
    }
    
    private static Vehiculo obtenerVehiculo(){
            System.out.println("Ingrese el codigo del vehiculo");
            id = sc.nextInt();
            v = vehiculoDao.buscarVehiculo(id);
            return v;
    }
    
    private static Vehiculo getVehiculo(){
        System.out.println("Ingrese el codigo, la marca, el tipo de vehiculo, el estado y la placa del nuevo vehiculo");
        Vehiculo v = new Vehiculo(sc.nextInt(), svehiculo.nextLine(), svehiculo.nextLine(), svehiculo.nextLine(), svehiculo.nextLine());
        return v;
    }

}
