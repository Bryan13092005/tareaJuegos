package ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner datos = new Scanner(System.in);

    private static void menuAtletas() {
        int op;
        do {
            System.out.println("\n--- MENÚ ATLETAS ---");
            System.out.println("1. Registrar atleta");
            System.out.println("2. Mostrar atletas");
            System.out.println("3. Volver");
            System.out.print("Opción: ");

            op = datos.nextInt();
            datos.nextLine();

            switch (op) {
                case 1:
                    Atleta a = new Atleta();
                    a.registrarAtleta();
                    break;
                case 2:
                    for (Atleta at : Atleta.atletas) {
                        at.mostarInformacion();
                    }
                    break;
                case 3:
                    System.out.println("Volviendo...");
                    return;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (true);
    }

    private static void menuEquipos() {
        int op;
        do {
            System.out.println("\n--- MENÚ EQUIPOS ---");
            System.out.println("1. Registrar equipo");
            System.out.println("2. Mostrar equipos");
            System.out.println("3. Volver");
            System.out.print("Opción: ");

            op = datos.nextInt();
            datos.nextLine();

            switch (op) {
                case 1:
                    Equipo e = new Equipo();
                    e.registrarEquipo();
                    break;
                case 2:
                    for (Equipo eq : Equipo.equipos) {
                        eq.mostarInformacion();
                    }
                    break;
                case 3:
                    System.out.println("Volviendo...");
                    return;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (true);
    }

    private static void menuEventos() {
        int op;
        do {
            System.out.println("\n--- MENÚ EVENTOS ---");
            System.out.println("1. Registrar evento");
            System.out.println("2. Mostrar eventos");
            System.out.println("3. Volver");
            System.out.print("Opción: ");

            op = datos.nextInt();
            datos.nextLine();

            switch (op) {
                case 1:
                    Evento e = new Evento();
                    e.registrarEvento();
                    break;
                case 2:
                    for (Evento ev : Evento.eventos) {
                        ev.mostrarEvento();
                    }
                    break;
                case 3:
                    System.out.println("Volviendo...");
                    return;
                default :
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (true);
    }

    private static void menuOlimpiadas() {
        int op;
        do {
            System.out.println("\n--- MENÚ OLIMPIADAS ---");
            System.out.println("1. Registrar olimpiada");
            System.out.println("2. Mostrar olimpiadas");
            System.out.println("3. Volver");
            System.out.print("Opción: ");

            op = datos.nextInt();
            datos.nextLine();

            switch (op) {
                case 1:
                    Olimpiada o = new Olimpiada();
                    o.registrarOlimpiada();
                    break;
                case 2:
                    for (Olimpiada ol : Olimpiada.olimpiadas) {
                        ol.mostrarOlimpiada();
                    }
                    break;
                case 3:
                    System.out.println("Volviendo...");
                    return;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (true);
    }

    public static void main(String[] args) {

        int opcion;

        do {
            try {
                System.out.println("\n===== MENÚ PRINCIPAL =====");
                System.out.println("1. Gestionar Atletas");
                System.out.println("2. Gestionar Equipos");
                System.out.println("3. Gestionar Eventos");
                System.out.println("4. Gestionar Olimpiadas");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = datos.nextInt();
                datos.nextLine();

                switch (opcion) {

                    case 1:
                        menuAtletas();
                        break;

                    case 2:
                        menuEquipos();
                        break;

                    case 3:
                        menuEventos();
                        break;

                    case 4:
                        menuOlimpiadas();
                        break;

                    case 5:
                        System.out.println("Saliendo del sistema...");
                        return;

                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (InputMismatchException e) {
                System.err.println("Debes ingresar un número.");
                datos.nextLine();
                opcion = 0;
            }

        } while (true);

    }
}