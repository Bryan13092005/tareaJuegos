package ejercicio4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<Candidata> candidatas=new ArrayList<>();
    public static Scanner datos=new Scanner(System.in);

    public static void menu(){
        do {
            try {
                System.out.println("------------MENU PRINCIPAL-------------");
                System.out.print("1. Registrar Candidatas\n2. Mostrar Candidatas\n3. Buscar Candidatas por Nombre o ID\n4. Filtrar por tipo\n5. Votos" +
                        "\n6. Mostrar Resultados y ganadora\n7. Salir\nIngrese una opcion: ");
                int opcion= datos.nextInt();
                datos.nextLine();
                switch (opcion){
                    case 1:
                        System.out.println("### MENU REGISTRO ###");
                        System.out.print("1. Estudiante\n2.Profesional\n3.Cancelar\nIngrese una opcion: ");
                        int opcionRegistro = datos.nextInt();
                        datos.nextLine();

                        if (opcionRegistro == 1) {
                            try {
                                CandidataEstudiante e = new CandidataEstudiante();
                                e.pedirInformacion();
                            } catch (DatoInvalidoExcepcion | InputMismatchException ex) {
                                System.err.println(ex.getMessage());
                            }

                        } else if (opcionRegistro == 2) {
                            try {
                                CandidataProfesional e = new CandidataProfesional();
                                e.pedirInformacion();
                            } catch (DatoInvalidoExcepcion | InputMismatchException ex) {
                                System.err.println(ex.getMessage());
                            }

                        } else if (opcionRegistro == 3) {
                            System.out.println("Regresando al menu principal...");
                        } else {
                            System.out.println("Opcion incorrecta");
                        }
                        break;
                    case 2:
                        if (candidatas.isEmpty()){
                            System.out.println("No hay candidatas registradas");
                            break;
                        }
                        System.out.println("___Candidatas Profesiones___");
                        boolean cp=false;
                        for(Candidata c:candidatas){
                            if (c instanceof CandidataProfesional){
                                c.mostrarDetalles();
                                cp=true;
                            }
                        }
                        if(!cp){
                            System.out.println("No hay candidatas profesionales");
                        }
                        System.out.println("___Candidatas Estudiantes___");
                        boolean ce=false;
                        for(Candidata c:candidatas){
                            if (c instanceof CandidataEstudiante){
                                c.mostrarDetalles();
                                ce=true;
                            }
                        }
                        if(!ce){
                            System.out.println("No hay candidatas estudiantes");
                        }
                        break;
                    case 3:
                        if (candidatas.isEmpty()){
                            System.out.println("No hay candidatas");
                            break;
                        }
                        System.out.println("### MENU DE BUSQUEDA ###");
                        System.out.print("1. Nombre\n2. ID\n3.Cancelar\nIngrese una opcion: ");
                        int opcionBusqueda= datos.nextInt();
                        datos.nextLine();
                        String nombreBuscar="";
                        int IDBuscar=0;
                        if (opcionBusqueda==1){
                            System.out.print("Ingrese el nombre: ");
                            nombreBuscar=datos.nextLine();
                        }else if (opcionBusqueda==2){
                            System.out.print("Ingrese el ID: ");
                            IDBuscar=datos.nextInt();
                            datos.nextLine();
                        }else if (opcionBusqueda==3) {
                            System.out.println("Regresando al menu principal...");
                            break;
                        }else{
                            System.out.println("Opcion incorrecta");
                            break;
                        }
                        boolean encontrada=false;
                        for(Candidata c:candidatas){
                            if (c.getNombre().equals(nombreBuscar.toUpperCase())){
                                c.mostrarDetalles();
                                encontrada=true;
                                break;
                            }
                            if (c.getId()==IDBuscar){
                                c.mostrarDetalles();
                                encontrada=true;
                                break;
                            }
                        }
                        if(!encontrada){
                            System.out.println("Candidata no encontrada");
                            break;
                        }
                        break;
                    case 4:
                        if (candidatas.isEmpty()){
                            System.out.println("No hay candidatas");
                            break;
                        }
                        System.out.println("### FILTRAR ###");
                        System.out.print("1. Estudiantes\n2. Profesionales\n3. Distrito\n4. Cancelar\nIngrese una opcion: ");
                        int opcionFiltros=datos.nextInt();
                        datos.nextLine();
                        switch (opcionFiltros){
                            case 1:
                                System.out.println("Candidatas Estudiantes");
                                ce=false;
                                for(Candidata c:candidatas){
                                    if (c instanceof CandidataEstudiante){
                                        c.mostrarDetalles();
                                        ce=true;
                                    }
                                }
                                if(!ce){
                                    System.out.println("No hay candidatas estudiantes");
                                }
                                break;
                            case 2:
                                System.out.println("Candidatas Profesiones");
                                cp=false;
                                for(Candidata c:candidatas){
                                    if (c instanceof CandidataProfesional){
                                        c.mostrarDetalles();
                                        cp=true;
                                    }
                                }
                                if(!cp){
                                    System.out.println("No hay candidatas profesionales");
                                }
                                break;
                            case 3:
                                System.out.print("Ingrese el nombre del distrito: ");
                                String distritoBuscar=datos.nextLine();
                                encontrada=false;
                                for(Candidata c:candidatas){
                                    if (c.getDistrito().equals(distritoBuscar.toUpperCase())){
                                        c.mostrarDetalles();
                                        encontrada=true;
                                        break;
                                    }
                                }
                                if(!encontrada){
                                    System.out.println("No se encontraron candidatas en el distrito "+distritoBuscar.toUpperCase());
                                }
                                break;
                            case 4:
                                System.out.println("Regresando al menu principal...");
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                                break;
                        }
                        break;
                    case 5:
                        if (candidatas.isEmpty()){
                            System.out.println("No hay candidatas");
                            break;
                        }
                        System.out.println("### MENU VOTACION ###");
                        System.out.print("1. Simular votacion\n2. Votar (SE PEDIRAN LAS VOTACIONES DE TODAS LAS CANDIDATAS)\n3. Cancelar\nIngrese una opcion: ");
                        int opcionVotar=datos.nextInt();
                        datos.nextLine();
                        switch (opcionVotar){
                            case 1:
                                Random rand = new Random();
                                for(Candidata c:candidatas){
                                    c.votos.put("Jurado 1",rand.nextInt(100)+1);
                                    c.votos.put("Jurado 2",rand.nextInt(100)+1);
                                    c.votos.put("Jurado 3",rand.nextInt(100)+1);
                                    c.setPuntajeJurado();
                                }
                                System.out.println("Puntajes creados con exito");
                                break;
                            case 2:
                                System.out.print("Ingrese la cantidad de jurados: ");
                                int jurados=datos.nextInt();
                                datos.nextLine();
                                for(Candidata c:candidatas){
                                    c.pedirPuntajes(jurados);
                                }
                                break;
                            case 3:
                                System.out.println("Regresando al menu principal...");
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                                break;
                        }
                        break;
                    case 6:
                        if (candidatas.isEmpty()) {
                            System.out.println("No hay candidatas");
                            break;
                        }

                        boolean hayVotos = true;
                        for (Candidata c : candidatas) {
                            if (c.votos.isEmpty()) {
                                hayVotos = false;
                                break;
                            }
                        }

                        if (!hayVotos) {
                            System.out.println("Aún no hay votos para todas las candidatas");
                            break;
                        }

                        System.out.println("Mostrando resultados y aplicando desempates...");

                        candidatas.getFirst().validarEmpates();

                        candidatas.sort((a, b) -> (int) (b.getPuntajeJurado() - a.getPuntajeJurado()));

                        for (Candidata c : candidatas) {
                            System.out.println(c.getNombre() + " ------------------ " + c.getPuntajeJurado());
                        }

                        System.out.println("LA GANADORA ES:");
                        Candidata g=candidatas.get(0).obtenerGanadora();
                        g.mostrarDetalles();
                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opcion invalida");
                        break;
                }
            }catch (InputMismatchException e){
                datos.nextLine();
            }
        }while (true);
    }

    public static void main(String[] args){
        menu();
    }
}
