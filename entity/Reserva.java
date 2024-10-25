package com.sala.facil.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name =  "reserva")
public class Reserva {

    private static final long serialVersionUID = 2223333;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id;

    @Column(name = "data_reserva")
    Date dataReserva;
    @Column(name = "status")
    Boolean status;
    @Column(name = "data_pedido")
    Date dataPedido;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    Sala sala;

    public Reserva(Date dataPedido, Date dataReserva, Long id, Boolean status, Usuario usuario) {
        this.dataPedido = dataPedido;
        this.dataReserva = dataReserva;
        this.id = id;
        this.status = status;
        this.usuario = usuario;
    }

    public Reserva() {
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
