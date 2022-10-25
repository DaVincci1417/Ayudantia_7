package Ayudantia_7;

public class Medico {
    private String nombreCompleto;
    private String rut;
    private String edad;

    public Medico(String nombreCompleto, String rut, String edad) {
        setNombreCompleto(nombreCompleto);
        setRut(rut);
        setEdad(edad);
    }

    //Setters
    private void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    private void setRut(String rut) {
       try{
           validarRut(rut);
           this.rut = rut;
       }catch (Exception e){
           System.out.println("Ha ocurrido un error, ingrese el RUT de nuevo.");
       }
    }
    private void setEdad(String edad) {
        validarEdad(edad);
        this.edad = edad;
    }

    //Getters
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public String getRut() {
        return rut;
    }
    public String getEdad() {
        return edad;
    }

    //Validacion de RUT
    private void validarRut(String rut) throws Exception{
        String rutSinPuntosNiGuion = quitarPuntosYGuion(rut);
        String mensajeError = "Ingrese un RUT valido.";

        if (rutSinPuntosNiGuion.length() > 9){
            throw new Exception(mensajeError);
        }

        if(!rutSinPuntosNiGuion.substring(8,9).equalsIgnoreCase("k")){
            try {
                Integer.parseInt(rut.substring(8,9));
            }catch (Exception e){
                throw new Exception(mensajeError);
            }
        }

        try {
            Integer.parseInt(rutSinPuntosNiGuion.substring(0,8));
        }catch (Exception e){
            throw new Exception(mensajeError);
        }
    }
    private String quitarPuntosYGuion(String rut){
        String rutSinPuntos;
        rutSinPuntos = rut.replace(".", "");
        String rutSinPuntosNiGuion = rutSinPuntos.replace("-", "");
        String rutLimpio = rutSinPuntosNiGuion.replace(" ", "");
        return rutLimpio;
    }

    //Validacion edad
    private void validarEdad(String edad){
        try {
            Integer.parseInt(edad);
        }catch (Exception e){
            System.out.println("Ingrese una edad valida");
        }

    }

    @Override
    public String toString() {
        return "Medico{" +
                "Nombre: " + nombreCompleto + "\n" +
                "RUT: " + quitarPuntosYGuion(rut) + "\n" +
                "Edad: " + edad + "}";
    }
}
