package ejercicio2;

import static ejercicio2.Main.datos;

class Telefono extends Dispositivo{
    private int RAM,espacio;
    public Telefono(){
        super();
    }

    public void registrarProducto() throws DatoInvalidoException {
        try {
            System.out.print("Ingrese la marca: ");
            setMarca(datos.nextLine());
            System.out.print("Ingrese el modelo: ");
            setModelo(datos.nextLine());
            System.out.print("Ingrese la RAM (GB): ");
            setRAM(datos.nextInt());
            System.out.print("Ingrese el espacio (GB): ");
            setEspacio(datos.nextInt());
            System.out.print("Ingrese el precio: $");
            setPrecio(datos.nextDouble());
            datos.nextLine();
            if (getEspacio()==0||getPrecio()==0||getRAM()==0||getMarca().isEmpty()||getModelo().isEmpty()){
                System.err.println("No se puede crear el dispositivo");
            }else{
                Main.dispositivos.add(this);
            }
        }catch (DatoInvalidoException e){
            System.err.println(e.getMessage());
        }
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) throws DatoInvalidoException {
        if (RAM<0 || RAM>24){
            throw new DatoInvalidoException("El dato de RAM es incorrecto");
        }else {
            this.RAM = RAM;
        }
    }

    public int getEspacio() {
        return espacio;
    }

    public void setEspacio(int espacio) throws DatoInvalidoException {
        if (espacio<0||espacio>512){
            throw new DatoInvalidoException("El espacio ingresado es invalido");
        }else {
            this.espacio = espacio;
        }
    }

    @Override
    public String mostrarInfo() {
        return "---Telefono---" +super.mostrarInfo()+
                "\nRAM: " + getRAM() +
                "\nEspacio: " + getEspacio();
    }
}
