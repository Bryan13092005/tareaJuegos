package ejercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static Scanner datos=new Scanner(System.in);

    public static void menu(){
        do {
            try {
                System.out.println("Menu Principal");
                System.out.print("1.Registrar Juego de Mario Bross\n2.Registrar juego de Carreras de Vehiculos\n3.Listar todos los juegos con su informacion\n4.Buscar juego por nombre\n5.Salir\nIngrese una opcion: ");
                int opcion = datos.nextInt();
                datos.nextLine();
                switch (opcion) {
                    case 1:
                        MarioBross j1 = new MarioBross();
                        j1.registrarInformacion();
                        break;
                    case 2:
                        CarrerasVehiculos j2 = new CarrerasVehiculos();
                        j2.registrarInformacion();
                        break;
                    case 3:
                        if (MarioBross.juegosMario.isEmpty()) {
                            System.out.println("NO HAY JUEGOS DE MARIO BROSS REGISTRADOS");
                        } else {
                            System.out.println("-------JUEGOS DE MARIO BROSS--------");
                            int contadorM = 1;
                            for (MarioBross m : MarioBross.juegosMario) {
                                System.out.println("Juego " + contadorM);
                                m.mostrarInformacion();
                                contadorM++;
                            }
                        }
                        if (CarrerasVehiculos.juegosCarrreras.isEmpty()) {
                            System.out.println("NO HAY JUEGOS DE CARRERAS DE VEHICULOS REGISTRADOS");
                        } else {
                            System.out.println("-------JUEGOS DE CARRERAS DE VEHICULOS--------");
                            int contadorV = 1;
                            for (CarrerasVehiculos c : CarrerasVehiculos.juegosCarrreras) {
                                System.out.println("Juego " + contadorV);
                                c.mostrarInformacion();
                                contadorV++;
                            }
                        }
                        break;
                    case 4:
                        if (CarrerasVehiculos.juegosCarrreras.isEmpty()&&MarioBross.juegosMario.isEmpty()){
                            System.out.println("No hay juegos registrados");
                            break;
                        }
                        boolean e=false;
                        System.out.print("Ingresa el nombre del juego a buscar: ");
                        String buscar= datos.nextLine();
                        for (CarrerasVehiculos c : CarrerasVehiculos.juegosCarrreras) {
                            if(buscar.equalsIgnoreCase(c.getNombre())) {
                                c.mostrarInformacion();
                                e=true;
                            }
                        }
                        for (MarioBross m : MarioBross.juegosMario) {
                            if(buscar.equalsIgnoreCase(m.getNombre())) {
                                m.mostrarInformacion();
                                e=true;
                            }
                        }

                        if (!e){
                            System.out.println("Juego no encontrado");
                        }
                        break;
                    case 5:
                        System.out.println("SALIENDO");
                        return;
                    default:
                        System.out.println("Has ingresado una opcion invalida");
                        break;
                }
            }catch (InputMismatchException e){
                System.err.println("Has Ingresado una palabra");
                datos.nextLine();
            }
        }while (true);
    }
    public static void main(String[] args){
        menu();
    }
}