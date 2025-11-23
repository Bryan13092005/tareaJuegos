package ejercicio4;
import java.util.InputMismatchException;

import static ejercicio4.Main.candidatas;
import static ejercicio4.Main.datos;

public class CandidataProfesional extends Candidata{
    private String profesion;
    private int añosExperiencia;

    public CandidataProfesional(){
        super();
    }

    @Override
    public void pedirInformacion() throws DatoInvalidoExcepcion, InputMismatchException {
        super.pedirInformacion();
        System.out.print("Anios de experiencia: ");
        setAñosExperiencia(datos.nextInt());
        System.out.print("Profesion: ");
        setProfesion(datos.nextLine());
        if (getNombre().trim().isEmpty()||getProfesion().trim().isEmpty()||getEdad()<=0||getAñosExperiencia()<0||getDistrito().trim().isEmpty()){
            System.err.println("No se puede agregar a la candidata, por falta de datos");
        }else{
            candidatas.add(this);
            System.out.println("Agregado con exito");
        }
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) throws DatoInvalidoExcepcion {
        if (profesion.trim().isEmpty()){
            throw new DatoInvalidoExcepcion("Profesion invalida");
        }else {
            this.profesion = profesion;
        }
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) throws DatoInvalidoExcepcion {
        datos.nextLine();
        if (añosExperiencia<0){
            throw new DatoInvalidoExcepcion("Año invalido");
        }
        this.añosExperiencia = añosExperiencia;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("ID: "+getId()+"\nNombre: "+getNombre()+"\nEdad: "+getEdad()+"\nAños de Experiencia: "+getAñosExperiencia()+"\nDistrito: "+getDistrito()+"\nPuntaje individual: "+ mostrarPuntajes()+"\nPuntaje Promedio: "+getPuntajeJurado());
    }
}
