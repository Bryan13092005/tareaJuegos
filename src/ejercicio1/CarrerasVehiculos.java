package ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

class CarrerasVehiculos extends Juego{
    public Scanner datos=new Scanner(System.in);
    private int cantidadCarros;
    private double velocidadMaxima;
    public static ArrayList<CarrerasVehiculos> juegosCarrreras=new ArrayList<>();

    public CarrerasVehiculos(){
        super();
    }

    @Override
    public void registrarInformacion() {
        try {
            System.out.print("Ingrese el nombre del juego: ");
            setNombre(datos.nextLine());
            System.out.print("Ingrese la cantidad de niveles: ");
            setCantidadNiveles(datos.nextInt());
            System.out.print("Ingrese la cantidad de carros por carrera (minimo 2 y maximo 8): ");
            setCantidadCarros(datos.nextInt());
            System.out.print("Ingrese la velocidad maxima por carro (el minimo es 100km/h y el maximo 350km/h): ");
            setVelocidadMaxima(datos.nextDouble());
            datos.nextLine();
        } catch (DatosExepcion e) {
            System.err.println(e.getMessage());
        }

        if (getNombre()!=null&&getCantidadCarros()!=0&&getCantidadNiveles()!=0&&getVelocidadMaxima()!=0){
            juegosCarrreras.add(this);
        }
    }

    public int getCantidadCarros() {
        return cantidadCarros;
    }

    public void setCantidadCarros(int cantidadCarros) throws DatosExepcion {
        if (cantidadCarros>=2&&cantidadCarros<=8) {
            this.cantidadCarros = cantidadCarros;
        }else {
            throw new DatosExepcion("La cantidad minima de carros es 2 y maxima 8");
        }
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) throws DatosExepcion {
        if (velocidadMaxima<100||velocidadMaxima>350){
            throw new DatosExepcion("La velocidad minima es 100km/h y la maxima 350km/h");
        }else {
            this.velocidadMaxima = velocidadMaxima;
        }
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: "+getNombre()+"\nCantidad de niveles: "+getCantidadNiveles()+"\nCantidad de Vehiculos: "+getCantidadCarros()+"\nVelocidad Maxima: "+getVelocidadMaxima()+"km/h");
    }
}
