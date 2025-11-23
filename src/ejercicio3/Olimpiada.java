package ejercicio3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Olimpiada {

    public static ArrayList<Olimpiada> olimpiadas = new ArrayList<>();

    private String nombreOlimpiada;
    private ArrayList<Evento> eventosOlimpiada = new ArrayList<>();

    private Scanner datos = new Scanner(System.in);

    public void registrarOlimpiada() {

        System.out.print("Nombre de la olimpiada: ");
        nombreOlimpiada = datos.nextLine();

        if (Evento.eventos.isEmpty()) {
            System.out.println("No existen eventos registrados.");
            return;
        }

        System.out.println("\nEventos disponibles:");
        for (int i = 0; i < Evento.eventos.size(); i++) {
            System.out.println((i + 1) + ". " + Evento.eventos.get(i).getNombreEvento());
        }

        System.out.println("\nSeleccione los eventos para la olimpiada (0 para terminar):");

        while (true) {
            try {
                System.out.print("Evento nº: ");
                int opcion = datos.nextInt();

                if (opcion == 0) break;
                if (opcion < 1 || opcion > Evento.eventos.size()) {
                    System.out.println("Opción inválida.");
                    continue;
                }

                Evento seleccionado = Evento.eventos.get(opcion - 1);
                eventosOlimpiada.add(seleccionado);
                System.out.println("Agregado: " + seleccionado.getNombreEvento());

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                datos.nextLine();
            }
        }

        olimpiadas.add(this);
        System.out.println("Olimpiada registrada correctamente.");
    }

    public void mostrarOlimpiada() {
        System.out.println("\n==== OLIMPIADA: " + nombreOlimpiada + " ====");
        System.out.println("Eventos incluidos:");

        for (Evento ev : eventosOlimpiada) {
            System.out.println("- " + ev.getNombreEvento());
        }
    }

    public String getNombreOlimpiada() {
        return nombreOlimpiada;
    }
}