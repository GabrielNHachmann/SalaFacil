package com.sala.facil.controller;

import com.sala.facil.entity.Sala;
import com.sala.facil.entity.Usuario;
import com.sala.facil.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "sala")
public class SalaController {

    @Autowired
    private SalaService service;

    @GetMapping
    public List<Sala> getSala(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Sala findById(@PathVariable long id){
        Sala sala = service.findById(id);
        return sala;
    }

    @PostMapping
    public Sala saveSala(@RequestBody Sala sala){
        Sala salaSalva = service.saveSala(sala);
        return salaSalva;
    }

    @PutMapping("/{id}")
    public Sala editSala(@PathVariable long id, @RequestBody Sala sala){
        Sala salaEdit = service.editSala(sala, id);
        return salaEdit;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        service.deleteSala(id);
    }
}
