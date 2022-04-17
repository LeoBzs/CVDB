package com.curriculum.curriculum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity

@Table(name ="secoes")
public class Secoes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "titulo", length = 255, nullable = false)
    private String titulo;

    @Column(name = "campo_texto", length = 2000, nullable = false)
    private String campo_texto;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @NonNull
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NonNull String titulo) {
        this.titulo = titulo;
    }

    @NonNull
    public String getCampo_texto() {
        return campo_texto;
    }

    public void setCampo_texto(@NonNull String campo_texto) {
        this.campo_texto = campo_texto;
    }
}
