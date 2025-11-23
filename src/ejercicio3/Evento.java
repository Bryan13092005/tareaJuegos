package ejercicio3;

import java.util.*;

public class Evento {
    public static ArrayList<Evento> eventos = new ArrayList<>();

    private String nombreEvento;
    private ArrayList<Equipo> equiposParticipantes = new ArrayList<>();

    private Scanner datos = new Scanner(System.in);

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void registrarEvento() {

        System.out.print("Nombre del evento: ");
        nombreEvento = datos.nextLine();

        if (Equipo.equipos.isEmpty()) {
            System.out.println("No existen equipos registrados.");
            return;
        }

        // Mostrar equipos disponibles
        System.out.println("\nEquipos disponibles:");
        for (int i = 0; i < Equipo.equipos.size(); i++) {
            System.out.println((i + 1) + ". " + Equipo.equipos.get(i).getNombre());
        }

        // Selección simplificada (igual a la lógica de atletas)
        System.out.println("\nIngrese los números de los equipos participantes (0 para terminar):");

        while (true) {
            try {
                System.out.print("Equipo nº: ");
                int opcion = datos.nextInt();

                if (opcion == 0) break;
                if (opcion < 1 || opcion > Equipo.equipos.size()) {
                    System.out.println("Opción inválida.");
                    continue;
                }

                Equipo seleccionado = Equipo.equipos.get(opcion - 1);
                equiposParticipantes.add(seleccionado);
                System.out.println("Agregado: " + seleccionado.getNombre());

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                datos.nextLine();
            }
        }

        eventos.add(this);
        System.out.println("Evento registrado correctamente.");
    }

    public void mostrarEvento() {
        System.out.println("\nEvento: " + nombreEvento);
        System.out.println("Equipos participantes:");

        for (Equipo eq : equiposParticipantes) {
            eq.mostarInformacion();
        }
    }
}
