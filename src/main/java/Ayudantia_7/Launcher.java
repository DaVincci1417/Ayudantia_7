package Ayudantia_7;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args){
        principal();
    }

    public static void principal(){
        Hospital hospital = new Hospital();
        Scanner leer = new Scanner(System.in);
        int opc = -1;
        do{
            menuPrincipal();
            opc = leer.nextInt();
            segunPrincipal(opc, hospital);
        }while (opc != 0);
        System.out.println("Ha salido.");
    }
    public static void menuPrincipal(){
        System.out.println(
                "Bienvenido. Ingrese opción según corresponda:\n" +
                        "0. Salir\n" +
                        "1. Registrar paciente.\n" +
                        "2. Contratar Medico.\n" +
                        "3. Despedir Medico.\n"
        );
    }
    public static void segunPrincipal(int opc, Hospital hospital){
        switch (opc){
            case 0:
                break;
            case 1:
                try {
                    registrarPaciente(hospital);
                } catch (Exception e){
                    System.out.println("Has ingresadoa algo mal, vuelve a intentarlo");
                }
                break;
            case 2:
                try {
                    contrarMedico(hospital);
                } catch (Exception e){
                    System.out.println("Has ingresadoa algo mal, vuelve a intentarlo");
                }
                break;
            case 3:
                try {
                    despedirMedico(hospital);
                } catch (Exception e){
                    System.out.println("Has ingresadoa algo mal, vuelve a intentarlo");
                }
                break;
            default: System.out.println("Agregue una opción valida");
        }
    }
    public static void registrarPaciente(Hospital hospital){
        Scanner leer = new Scanner(System.in);

        String nombre;
        String rut;
        String edad;

        System.out.println("Ingre el nombre (completo) del paciente");
        nombre = leer.nextLine();
        System.out.println("Ingre el RUT");
        rut = leer.nextLine();
        System.out.println("Ingre la edad del paciente");
        edad = leer.nextLine();
        Paciente paciente = new Paciente(nombre, rut, edad);
        hospital.registrarPaciente(paciente);

        System.out.println("Ha agregado con exito a paciente: ");
        System.out.println(paciente.toString());
    }
    public static void contrarMedico(Hospital hospital){
        Scanner leer = new Scanner(System.in);

        String nombre;
        String rut;
        String edad;

        System.out.println("Ingre el nombre (completo) del medico");
        nombre = leer.nextLine();
        System.out.println("Ingre el RUT del medico");
        rut = leer.nextLine();
        System.out.println("Ingre la edad del medico");
        edad = leer.nextLine();
        Medico medico = new Medico(nombre, rut, edad);
        hospital.contratarMedico(medico);

        System.out.println("Ha agregado con exito a paciente: ");
        System.out.println(medico.toString());
    }
    public static void despedirMedico(Hospital hospital){
        Scanner leer = new Scanner(System.in);
        String rut;

        System.out.println("Ingre el RUT del medico");
        rut = leer.nextLine();
        if(hospital.despedirMedico(rut) != null){
            System.out.println(
                    "Se ha despedido al medico"
            );

        }else{
            System.out.println("No se ha encontrado al medico a despedir.");
        }

    }

}
