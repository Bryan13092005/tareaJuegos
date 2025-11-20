package ejercicio1;

class DatosExepcion extends Exception{
    public DatosExepcion(String mensaje){
        super(mensaje+"\nNo se puede crear el jeugo");
    }
}
