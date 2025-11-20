package ejercicio2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static ArrayList<Dispositivo> dispositivos=new ArrayList<>();
    public static Scanner datos=new Scanner(System.in);

    public static void menu(){
        do{
            try{
                System.out.println("--------MENU PRINCIPAL---------");
                System.out.print("1.Crear Laptop\n2.Crear Telefono\n3.Listar Dispositivos\n4.Salir\nIngrese una opcion: ");
                int opcion= datos.nextInt();
                datos.nextLine();
                switch (opcion){
                    case 1:
                        Laptop l=new Laptop();
                        l.RegistrarProducto();
                        break;
                    case 2:
                        Telefono t=new Telefono();
                        t.registrarProducto();
                        break;
                    case 3:
                        if (dispositivos.isEmpty()){
                            System.out.println("No hay dispositivos");
                            break;
                        }
                        boolean hayLaptops=false;
                        System.out.println("--------- LAPTOPS ---------");
                        for (Dispositivo d : dispositivos) {
                            if (d instanceof Laptop) {
                                System.out.println(d.mostrarInfo());
                                hayLaptops=true;
                            }
                        }
                        if (!hayLaptops){
                            System.out.println("No hay Laptops");
                        }
                        boolean hayTelefonos=false;
                        System.out.println("-------- TELEFONOS --------");
                        for (Dispositivo d : dispositivos) {
                            if (d instanceof Telefono) {
                                System.out.println(d.mostrarInfo());
                                hayTelefonos=true;
                            }
                        }
                        if (!hayTelefonos){
                            System.out.println("No hay telefonos");
                        }

                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opcion inavalida");
                        break;
                }
            }catch (InputMismatchException e){
                System.err.println("Opcion invalida");
                datos.nextLine();
            } catch (DatoInvalidoException e) {
                throw new RuntimeException(e);
            }
        }while (true);
    }

    public static void main(String[] args){
        menu();
    }
}
