package com.curriculum.curriculum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity

@Table(name ="educacao")
public class Educacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "nome_instituicao", length = 255, nullable = false, unique = true)
    private String nome_instituicao;

    @Column(name = "curso", length = 500, nullable = false)
    private String curso;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate data_inicio;

    @Column(name = "data_termino")
    private LocalDate data_termino;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @NonNull
    public String getNome_instituicao() {
        return nome_instituicao;
    }

    public void setNome_instituicao(@NonNull String nome_instituicao) {
        this.nome_instituicao = nome_instituicao;
    }

    @NonNull
    public String getCurso() {
        return curso;
    }

    public void setCurso(@NonNull String curso) {
        this.curso = curso;
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
}
