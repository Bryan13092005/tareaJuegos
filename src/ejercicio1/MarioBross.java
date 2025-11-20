package ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

class MarioBross extends Juego{
    public Scanner datos=new Scanner(System.in);
    private int cantJugadores;
    public static ArrayList<MarioBross> juegosMario=new ArrayList<>();

    public MarioBross(){
        super();
    }

    @Override
    public void registrarInformacion(){
        try {
            System.out.print("Ingrese el nombre del juego: ");
            setNombre(datos.nextLine());
            System.out.print("Ingrese la cantidad de niveles: ");
            setCantidadNiveles(datos.nextInt());
            datos.nextLine();
            System.out.print("Ingrese la cantidad de jugadores (maximo 4): ");
            setCantJugadores(datos.nextInt());
        } catch (DatosExepcion e) {
            System.err.println(e.getMessage());
        }

        if (getNombre()!=null&&getCantJugadores()!=0&&getCantidadNiveles()!=0){
            juegosMario.add(this);
        }
    }

    public void setCantJugadores(int cantJugadores) throws DatosExepcion {
        if (cantJugadores<=0||cantJugadores>4){
            throw new DatosExepcion("El numero maximo de jugadores 4 y el minimo 1");
        }else {
            this.cantJugadores = cantJugadores;
        }
    }

    public int getCantJugadores() {
        return cantJugadores;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre Juego: "+getNombre()+"\nCantidad de niveles: "+getCantidadNiveles()+"Cantidad de Jugadores: "+getCantJugadores());
    }
}
