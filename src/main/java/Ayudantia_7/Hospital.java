package Ayudantia_7;

import java.util.ArrayList;

public class Hospital {
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Medico> medicos = new ArrayList<>();

    //Registrar pacientes
    public void registrarPaciente(Paciente paciente ){
        pacientes.add(paciente);
    }

    //Contratar, despedir y encontrar medicos
    public void contratarMedico(Medico medico){
        medicos.add(medico);
    }
    public Medico despedirMedico(String rut){
        Medico medicoDespedido = encontrarMedico(rut);
        medicos.remove(medicoDespedido);
        return medicoDespedido;
    }
    private Medico encontrarMedico(String rut) {
        int posicion = -1;
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getRut() == rut) {
                posicion = i;
            }
        }
        if (posicion != -1) {
            return medicos.get(posicion);
        } else {
            return null;
        }
    }
}
