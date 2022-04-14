package com.curriculum.curriculum.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="cv")
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cv_experiencia", joinColumns = {
            @JoinColumn(name = "cv_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "experiencia_id", referencedColumnName = "id") })
    @Builder.Default
    private List<Experiencia> experiencia = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cv_educacao", joinColumns = {
            @JoinColumn(name = "cv_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "educacao_id", referencedColumnName = "id") })
    @Builder.Default
    private List<Educacao> educacao = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cv_secoes", joinColumns = {
            @JoinColumn(name = "cv_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "secoes_id", referencedColumnName = "id") })
    @Builder.Default
    private List<Secoes> secoes = new ArrayList<>();

    @Column(name = "conhecimentos", nullable = false)
    private String conhecimentos;

    @Column(name = "idioma", nullable = false)
    private String idioma;

    @Column(name = "nome", length = 255, nullable = false, unique = true)
    private String nome;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @Column(name = "cargo", length = 255, nullable = false)
    private String cargo;

    @Column(name = "sumario", length = 2000, nullable = false)
    private String sumario;

    @Column(name = "status")
    private LanguageLevel status = LanguageLevel.NONE ;

    public enum LanguageLevel {
        NONE, BASIC, INTERMEDIATE, ADVANCED
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getConhecimentos() {
        return conhecimentos;
    }

    public void setConhecimentos(String conhecimentos) {
        this.conhecimentos = conhecimentos;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getCargo() {
        return cargo;
    }

    public void setCargo(@NonNull String cargo) {
        this.cargo = cargo;
    }

    @NonNull
    public String getSumario() {
        return sumario;
    }

    public void setSumario(@NonNull String sumario) {
        this.sumario = sumario;
    }

    public List<Experiencia> getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(List<Experiencia> experiencia) {
        this.experiencia = experiencia;
    }

    public List<Educacao> getEducacao() {
        return educacao;
    }

    public void setEducacao(List<Educacao> educacao) {
        this.educacao = educacao;
    }

    public LanguageLevel getStatus() {
        return status;
    }

    public void setStatus(LanguageLevel status) {
        this.status = status;
    }

    public List<Secoes> getSecoes() {
        return secoes;
    }

    public void setSecoes(List<Secoes> secoes) {
        this.secoes = secoes;
    }
}