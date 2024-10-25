package com.sala.facil.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 2223333;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "cpf")
    private String cpf;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Reserva> reserva;

    public Usuario() {
    }

    public Usuario(String cpf, String email, Long id, String nome, String phone) {
        this.cpf = cpf;
        this.email = email;
        this.id = id;
        this.nome = nome;
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }
}
