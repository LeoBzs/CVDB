package com.curriculum.curriculum.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity

@Table(name ="experiencia")
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    //@ManyToOne
    //@JoinColumn(name="cv_id_experiencia")
    //private Cv cv;

    @Column(name = "nome", length = 255, nullable = false, unique = true)
    private String nome;

    @Column(name = "cargo", length = 500, nullable = false)
    private String cargo;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate data_inicio;

    @Column(name = "data_termino")
    private LocalDate data_termino;

    @Column(name = "atividades", length = 2000, nullable = false)
    private String atividades;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    @NonNull
    public String getCargo() {
        return cargo;
    }

    public void setCargo(@NonNull String cargo) {
        this.cargo = cargo;
    }

    @NonNull
    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(@NonNull LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_termino() {
        return data_termino;
    }

    public void setData_termino(LocalDate data_termino) {
        this.data_termino = data_termino;
    }

    @NonNull
    public String getAtividades() {
        return atividades;
    }

    public void setAtividades(@NonNull String atividades) {
        this.atividades = atividades;
    }
}