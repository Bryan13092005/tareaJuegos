package ejercicio3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Equipo extends Participante{
    public static ArrayList<Equipo> equipos = new ArrayList<>();

    private ArrayList<Atleta> atletasEquipo = new ArrayList<>();

    private Scanner datos = new Scanner(System.in);

    public void registrarEquipo() {

        System.out.print("Nombre del equipo: ");
        setNombre(datos.nextLine());

        if (Atleta.atletas.isEmpty()) {
            System.out.println("No existen atletas registrados.");
            return;
        }

        System.out.println("\nAtletas disponibles:");
        for (int i = 0; i < Atleta.atletas.size(); i++) {
            System.out.println((i + 1) + ". " + Atleta.atletas.get(i).getNombre());
        }

        System.out.println("\nIngrese los números de los atletas del equipo (0 para terminar):");

        while (true) {
            try {
                System.out.print("Atleta nº: ");
                int opcion = datos.nextInt();

                if (opcion == 0) break;
                if (opcion < 1 || opcion > Atleta.atletas.size()) {
                    System.out.println("Opción inválida.");
                    continue;
                }

                Atleta seleccionado = Atleta.atletas.get(opcion - 1);
                atletasEquipo.add(seleccionado);
                System.out.println("Agregado: " + seleccionado.getNombre());

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                datos.nextLine();
            }
        }

        equipos.add(this);
        System.out.println("Equipo registrado correctamente.");
    }

    @Override
    public void mostarInformacion() {
        System.out.println("\nEquipo: " + getNombre());
        System.out.println("Atletas:");
        for (Atleta a : atletasEquipo) {
            a.mostarInformacion();
        }
    }
}
