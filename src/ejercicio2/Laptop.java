package ejercicio2;

import static ejercicio2.Main.datos;

class Laptop extends Dispositivo{
    private int RAM,espacio;
    private String SO;
    public Laptop(){
        super();
    }

    public void RegistrarProducto() throws DatoInvalidoException {
        try {
            System.out.print("Ingrese la marca: ");
            setMarca(datos.nextLine());
            System.out.print("Ingrese el modelo: ");
            setModelo(datos.nextLine());
            System.out.print("Ingrese el Sistema Operativo: ");
            setSO(datos.nextLine());
            System.out.print("Ingrese la RAM (GB): ");
            setRAM(datos.nextInt());
            System.out.print("Ingrese el espacio SSD (GB): ");
            setEspacio(datos.nextInt());
            System.out.print("Ingrese el precio: $");
            setPrecio(datos.nextDouble());
            datos.nextLine();
            if (getMarca().isEmpty() || getEspacio() == 0 || getRAM() == 0 || getModelo().isEmpty() || getSO().isEmpty() || getPrecio() == 0) {
                System.err.println("No se puede crear el dispositivo");
            } else {
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
        if (RAM<0){
            throw new DatoInvalidoException("La RAM no puede ser negativa");
        }else {
            this.RAM=RAM;
        }
    }

    public int getEspacio() {
        return espacio;
    }

    public void setEspacio(int espacio) throws DatoInvalidoException {
        if (espacio<0){
            throw new DatoInvalidoException("El espacio no puede ser negativo");
        }else {
            this.espacio = espacio;
        }
    }

    public String getSO() {
        return SO;
    }

    public void setSO(String SO) throws DatoInvalidoException {
        if (SO.trim().isEmpty()){
            throw new DatoInvalidoException("Debes escribir un SO");
        }else {
            this.SO = SO;
        }
    }

    @Override
    public String mostrarInfo() {
        return "---Laptop---" +super.mostrarInfo()+
                "\nRAM: " + getRAM() +
                "\nEspacio: " + getEspacio() +
                "\nSistema Operativo: " + getSO();
    }
}
