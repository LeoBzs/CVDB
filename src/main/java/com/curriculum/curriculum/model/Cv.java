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
    @JoinTable(name = "cv_experiencia", joinColumns = @JoinColumn(name = "cv_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "experiencia_id", referencedColumnName = "id"))
    @Builder.Default
    private List<Experiencia> experiencia = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cv_educacao", joinColumns = @JoinColumn(name = "cv_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "educacao_id", referencedColumnName = "id"))
    @Builder.Default
    private List<Educacao> educacao = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cv_secoes", joinColumns = @JoinColumn(name = "cv_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "secoes_id", referencedColumnName = "id"))
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

    public void addExperiencia(Experiencia experiencia) {
        this.experiencia.add(experiencia);
    }

    public void removeExperiencia(Experiencia experiencia) {
        this.experiencia.remove(experiencia);
    }

    public void addEducacao(Educacao educacao) {
        this.educacao.add(educacao);
    }

    public void removeEducacao(Educacao educacao) {
        this.educacao.remove(educacao);
    }

    public void addSecoes(Secoes secoes) {
        this.secoes.add(secoes);
    }

    public void removeSecoes(Secoes secoes) {
        this.secoes.remove(secoes);
    }
}