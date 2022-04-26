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

}
