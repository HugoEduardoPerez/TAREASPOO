package consultas;

import consultorios.Consultorio;
import medicos.Medico;
import pacientes.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Consulta {
    public int id;
    public LocalDateTime fechaHora;
    public Paciente paciente;
    public Medico medico;
    public Consultorio consultorio;

    public Consulta(int id, LocalDateTime fechaHora, Paciente paciente, Medico medico, Consultorio consultorio) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public String mostrarInformacion(){
        String info = String.format("\nID: %s, fecha: %s, id paciente: %s, nombre paciente: %s, id medico: %s, piso consultorio: %s,numero onsultorio: %s",
                id,
                fechaHora,
                paciente.getId(),
                medico.getId(),
                medico.getNombre(),
                consultorio.getPiso(),
                consultorio.getNumeroConsultorio()
        );
        return info;
    }
}