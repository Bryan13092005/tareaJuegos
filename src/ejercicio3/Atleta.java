package ejercicio3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Atleta extends Participante {
    public Scanner datos=new Scanner(System.in);
    private int edad;
    private String disciplina;
    public static ArrayList<Atleta> atletas=new ArrayList<>();
    public Atleta(){
        super();
    }

    public void registrarAtleta(){
        try {
            System.out.print("Ingrese el nombre: ");
            setNombre(datos.nextLine());
            System.out.print("Ingrese la edad: ");
            setEdad(datos.nextInt());
            datos.nextLine();
            System.out.print("Ingrese la disciplina: ");
            setDisciplina(datos.nextLine());
        }catch (InputMismatchException e){
            System.err.println("Ingresaste un valor invalido");
        }
        if (getNombre()==null||getEdad()==0||getDisciplina()==null){
            System.err.println("No se puede crear un atleta, uno de los datos esta incorrecto");
        }else{
            atletas.add(this);
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad>0) {
            this.edad = edad;
        }else{
            System.out.println("Edad incorrecta");
        }
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        if (disciplina.trim().isEmpty()) {
            System.out.println("Disciplina incorrecta");
        }else{
            this.disciplina = disciplina;
        }
    }

    @Override
    public void mostarInformacion() {
        System.out.println("Nombre: "+getNombre()+
                            "\nEdad: "+getEdad()+
                            "\nDisciplina: "+getDisciplina());
    }
}
