package ejercicio2;

abstract class Dispositivo {
    private String marca,modelo;
    private double precio;

    public Dispositivo(){}

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) throws DatoInvalidoException {
        if (marca.trim().isEmpty()){
            throw new DatoInvalidoException("La marca esta vacia");
        }else {
            this.marca = marca;
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) throws DatoInvalidoException{
        if (modelo.trim().isEmpty()){
            throw new DatoInvalidoException("El modelo esta vacio");
        }else {
            this.modelo = modelo;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) throws DatoInvalidoException {
        if (precio<0){
            throw new DatoInvalidoException("Precio incorrecto");
        }else {
            this.precio = precio;
        }
    }

    public String mostrarInfo(){
        return  "\nMarca: " + getMarca() +
                "\nModelo: " + getModelo() +
                "\nPrecio: " + getPrecio()+
                "\nEspecificaciones:";
    }
}
