package com.sala.facil.service;

import com.sala.facil.entity.Reserva;
import com.sala.facil.entity.Usuario;
import com.sala.facil.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    public List<Reserva> findAll(){
        return repository.findAll();
    }

    public Reserva saveReserva(Reserva reserva){
        Date dataHoje = new Date();

        int comparacao = dataHoje.compareTo(reserva.getDataReserva());

        long diffMilis = Math.abs(reserva.getDataPedido().getTime() - reserva.getDataReserva().getTime());
        long diffDias = diffMilis / (24 * 60 * 60 * 1000);

        if(comparacao < 0 && diffDias >= 30) {
            return repository.save(reserva);
        }else if(comparacao > 0){
            return null;
        }else{
            return null;
        }
    }

    public Reserva findById(long id){
        Reserva reserva = repository.findById(id).orElse(null);
        return reserva;
    }

    public Reserva editReserva(Reserva reserva, long id){
        Reserva oldReserva = this.findById(id);

        if(reserva.getDataPedido()!= null){
            oldReserva.setDataPedido(reserva.getDataPedido());
        }

        oldReserva.setId(reserva.getId()!= null ? reserva.getId() : oldReserva.getId());
        oldReserva.setDataReserva(reserva.getDataReserva() != null ? reserva.getDataReserva() : oldReserva.getDataReserva());
        oldReserva.setStatus(reserva.getStatus()!= null ? reserva.getStatus() : oldReserva.getStatus());

        return repository.save(oldReserva);
    }

    public void deleteReserva(long id){
        repository.deleteById(id);
    }

    public List<Reserva> getReservasPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public List<Reserva> getReservasPorSala(Long salaId){
        return repository.findBySalaId(salaId);
    }
}
