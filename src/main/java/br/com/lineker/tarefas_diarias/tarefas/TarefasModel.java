package br.com.lineker.tarefas_diarias.tarefas;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Entity
public class TarefasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String supervisor;
    private String tecnico;
    private String contrato;
    private LocalDate prazoFinal;
    private boolean finalizado = false;

    public TarefasModel(Long id, String supervisor, String tecnico, String contrato, LocalDate prazoFinal, boolean finaliado) {
        this.id = id;
        this.supervisor = supervisor;
        this.tecnico = tecnico;
        this.contrato = contrato;
        this.prazoFinal = prazoFinal;
        this.finalizado = finaliado;
    }

    public TarefasModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public LocalDate getPrazoFinal() {
        return prazoFinal;
    }

    public void setPrazoFinal(LocalDate prazoFinal) {
        this.prazoFinal = prazoFinal;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finaliado) {
        this.finalizado = finaliado;
    }
}
