package ejercicio3;

public abstract class Participante{
    private String nombre;

    public Participante(){}

    public abstract void mostarInformacion();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.trim().isEmpty()){
            System.out.println("Nombre vacio");
            return;
        }
        this.nombre = nombre;
    }
}
