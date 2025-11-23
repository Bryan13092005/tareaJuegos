package ejercicio4;

import java.util.InputMismatchException;

import static ejercicio4.Main.candidatas;
import static ejercicio4.Main.datos;

public class CandidataEstudiante extends Candidata{
    private String universidad,carrera;

    public CandidataEstudiante(){
        super();
    }

//    @Override
//    public void pedirInformacion() throws DatoInvalidoExcepcion{
//        try {
//            try {
//                super.pedirInformacion();
//            }catch (InputMismatchException e){
//                return;
//            }
//            System.out.print("Nombre univarsidad: ");
//            setUniversidad(datos.nextLine());
//            System.out.print("Carrera: ");
//            setCarrera(datos.nextLine());
//        }catch (DatoInvalidoExcepcion e){
//            System.err.println(e.getMessage());
//            return;
//        }catch (InputMismatchException e){
//            System.err.println("Dato invalido");
//            return;
//        }
//        if (getNombre().trim().isEmpty()||getCarrera().trim().isEmpty()||getEdad()<=0||getUniversidad().trim().isEmpty()||getDistrito().trim().isEmpty()){
//            System.err.println("No se puede agregar a la candidata, por falta de datos");
//        }else{
//            candidatas.add(this);
//            System.out.println("Agregado con exito");
//        }
//    }

    @Override
    public void pedirInformacion() throws DatoInvalidoExcepcion, InputMismatchException {
        super.pedirInformacion();
        System.out.print("Nombre universidad: ");
        setUniversidad(datos.nextLine());
        System.out.print("Carrera: ");
        setCarrera(datos.nextLine());

        if (getNombre().trim().isEmpty()||getCarrera().trim().isEmpty()||getEdad()<=0||getUniversidad().trim().isEmpty()||getDistrito().trim().isEmpty()){
            System.err.println("No se puede agregar a la candidata, por falta de datos");
        }else{
            candidatas.add(this);
            System.out.println("Agregado con exito");
        }
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) throws DatoInvalidoExcepcion {
        if (universidad.trim().isEmpty()){
            throw new DatoInvalidoExcepcion("La universidad no puede estar vacia");
        }else {
            this.universidad = universidad;
        }
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) throws DatoInvalidoExcepcion {
        if(carrera.trim().isEmpty()){
            throw new DatoInvalidoExcepcion("La carrera no puede estar vacia");
        }else {
            this.carrera = carrera;
        }
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("ID: "+getId()+"\nNombre: "+getNombre()+"\nEdad: "+getEdad()+"\nCarrera: "+getCarrera()+"\nDistrito: "+getDistrito()+"\nPuntaje individual: "+ mostrarPuntajes()+"\nPuntaje Promedio: "+getPuntajeJurado());
    }
}
