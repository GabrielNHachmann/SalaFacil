package com.sala.facil.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity(name = "sala")
public class Sala implements Serializable{

    private static final long serialVersionUID = 2223333;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sala")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    Boolean status;

    @OneToMany(mappedBy = "sala")
    @JsonIgnore
    private List<Reserva> reserva;

    public Sala() {
    }

    public Sala(String departamento, String descricao, Long id, String nome, Boolean status) {
        this.departamento = departamento;
        this.descricao = descricao;
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }
}
