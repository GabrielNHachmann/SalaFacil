package com.sala.facil.service;

import com.sala.facil.entity.Sala;
import com.sala.facil.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository repository;
    @Autowired
    private DataSourceTransactionManagerAutoConfiguration dataSourceTransactionManagerAutoConfiguration;

    public List<Sala> findAll(){
        return repository.findAll();
    }

    public Sala findById(long id){
        Sala sala = repository.findById(id).orElse(null);
        return sala;
    }

    public Sala saveSala(Sala sala){
        if(sala.getStatus() == true) {
            return repository.save(sala);
        } else {
            return null;
        }
    }

    public Sala editSala(Sala sala, long id){
        Sala oldSala = this.findById(id);

        if(sala.getNome() != null){
            oldSala.setNome(sala.getNome());
        }

        oldSala.setId(sala.getId()!= null ? sala.getId() : oldSala.getId());
        oldSala.setDepartamento(sala.getDepartamento() != null ? sala.getDepartamento() : oldSala.getDepartamento());
        oldSala.setDescricao(sala.getDescricao() != null ? sala.getDescricao() : oldSala.getDescricao());
        oldSala.setStatus(sala.getStatus() != null ? sala.getStatus() : oldSala.getStatus());

        return repository.save(oldSala);
    }

    public void deleteSala(long id){
        repository.deleteById(id);
    }
}
