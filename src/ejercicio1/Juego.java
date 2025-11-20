package ejercicio1;

abstract class Juego {
    private String nombre;
    private int cantidadNiveles;

    public Juego(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws DatosExepcion {
        if (nombre.trim().isEmpty()){
            throw new DatosExepcion("El nombre del juego no puede estar vacio");
        }else {
            this.nombre = nombre;
        }
    }

    public void setCantidadNiveles(int cantidadNiveles) throws DatosExepcion {
        if (cantidadNiveles<=0){
            throw new DatosExepcion("La cantidad minima de niveles es 1");
        }else {
            this.cantidadNiveles = cantidadNiveles;
        }
    }

    public int getCantidadNiveles() {
        return cantidadNiveles;
    }

    public abstract void registrarInformacion();
    public abstract void mostrarInformacion();
}
