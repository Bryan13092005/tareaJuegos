package ejercicio4;

import java.util.*;

import static ejercicio4.Main.candidatas;
import static ejercicio4.Main.datos;

public abstract class Candidata {
    private int id,edad;
    private String nombre,distrito;
    private double puntajeJurado;
    Map<String,Integer> votos=new HashMap<>();

    public Candidata(){}

    public void pedirInformacion() throws DatoInvalidoExcepcion{
        try {
            setId();
            System.out.print("Nombre: ");
            setNombre(datos.nextLine());
            System.out.print("Distrito: ");
            setDistrito(datos.nextLine());
            System.out.print("Edad: ");
            setEdad(datos.nextInt());
        }catch (DatoInvalidoExcepcion e){
            System.err.println(e.getMessage());
        }catch (InputMismatchException e){
            System.err.println("Ingresa un numero\nPresiona ENTER para continuar");
        }
    }
    public int getId() {
        return id;
    }

    private void setId(){
        if (candidatas.isEmpty()){
            this.id=1;
        }else {
            int cantidadCandidatas=candidatas.size();
            this.id = cantidadCandidatas+1;
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws DatoInvalidoExcepcion {
        if (edad<=15){
            throw new DatoInvalidoExcepcion("Edad invalida, el minimo es 16");
        }else {
            datos.nextLine();
            this.edad = edad;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws DatoInvalidoExcepcion {
        if (nombre.trim().isEmpty()){
            throw new DatoInvalidoExcepcion("El nombre esta vacio");
        }else {
            this.nombre = nombre.toUpperCase();
        }
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) throws DatoInvalidoExcepcion {
        if (distrito.trim().isEmpty()){
            throw new DatoInvalidoExcepcion("Distrito vacio");
        }else {
            this.distrito = distrito.toUpperCase();
        }
    }

    public double getPuntajeJurado() {
        return puntajeJurado;
    }

    public void setPuntajeJurado() {
        this.puntajeJurado=0;
        if (!votos.isEmpty()){
            for(Integer p: votos.values()){
                this.puntajeJurado+=p;
            }
            this.puntajeJurado/=votos.size();
        }
    }

    public void pedirPuntajes(int cantidadJurados) {
        System.out.println("PUNTAJES SOBRE 100");

        for (int i = 1; i <= cantidadJurados; i++) {
            String nombreJurado = "Jurado " + i;
            boolean valido = false;

            while (!valido) {
                try {
                    System.out.print(nombreJurado + ": ");
                    int pt = datos.nextInt();
                    datos.nextLine();
                    agregarPuntaje(nombreJurado, pt);
                    valido = true;
                } catch (DatoInvalidoExcepcion e) {
                    System.err.println(e.getMessage());
                } catch (InputMismatchException e) {
                    System.err.println("Debe ingresar solo números");
                    datos.nextLine();
                }
            }
        }

        setPuntajeJurado();
    }

    private void agregarPuntaje(String nombreJurado, int puntaje) throws DatoInvalidoExcepcion {
        if (puntaje < 0 || puntaje > 100) {
            throw new DatoInvalidoExcepcion("El puntaje debe estar entre 0 y 100");
        }
        votos.put(nombreJurado, puntaje);
    }

    public String mostrarPuntajes() {
        if (votos.isEmpty()) {
            return "No tiene puntajes (0/100)\n";
        }

        StringBuilder r = new StringBuilder();

        List<String> keys = new ArrayList<>(votos.keySet());
        Collections.sort(keys);

        for (String key : keys) {
            r.append("\n")
                    .append(key)
                    .append(": ")
                    .append(votos.get(key))
                    .append("/100\n");
        }
        return r.toString();
    }


    public void validarEmpates() {
        candidatas.sort((a, b) -> Double.compare(b.getPuntajeJurado(), a.getPuntajeJurado()));

        Candidata favorita = candidatas.get(0);

        var jurados = new ArrayList<>(favorita.votos.keySet());
        jurados.sort(String::compareTo);

        for (Candidata c : candidatas) {

            if (c == favorita) continue;

            int mejores = 0;

            for (String jurado : jurados) {
                int vFav = favorita.votos.get(jurado);
                int vCand = c.votos.get(jurado);

                if (vCand > vFav) {
                    mejores++;
                }
            }

            int mitad = jurados.size() / 2;

            if (mejores > mitad) {
                c.puntajeJurado += 0.5;
            } else {
                favorita.puntajeJurado += 0.5;
            }
        }

        candidatas.sort((a, b) -> Double.compare(b.getPuntajeJurado(), a.getPuntajeJurado()));
    }

    public Candidata obtenerGanadora() {

        if (candidatas.isEmpty()) return null;

        Candidata ganadora = candidatas.getFirst();

        for (Candidata c : candidatas) {
            if (c.getPuntajeJurado() > ganadora.getPuntajeJurado()) {
                ganadora = c;
            }
        }

        return ganadora;
    }


    public abstract void mostrarDetalles();

}
