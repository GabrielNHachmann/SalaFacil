package com.sala.facil.controller;

import com.sala.facil.entity.Reserva;
import com.sala.facil.entity.Usuario;
import com.sala.facil.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "reserva")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public List<Reserva> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Reserva saveReserva(@RequestBody Reserva reserva){
        Reserva reservaSalva = service.saveReserva(reserva);
        return reservaSalva;
    }

    @GetMapping("/{id}")
    public Reserva findById(@PathVariable long id){
        Reserva reserva = service.findById(id);
        return reserva;
    }

    @PutMapping("/{id}")
    public Reserva editReserva(@PathVariable long id, @RequestBody Reserva reserva){
        Reserva reservaEdit = service.editReserva(reserva, id);
        return reservaEdit;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        service.deleteReserva(id);
    }

    @GetMapping("/{userId}/usuario")
    public ResponseEntity<List<Reserva>> getReservasPorUsuario(@PathVariable Long userId) {
        List<Reserva> reserva = service.getReservasPorUsuario(userId);
        return ResponseEntity.ok(reserva);
    }

    @GetMapping("/{salaId}/sala")
    public ResponseEntity<List<Reserva>> getReservasPorSala(@PathVariable long salaId){
        List<Reserva> reserva = service.getReservasPorSala(salaId);
        return ResponseEntity.ok(reserva);
    }
}
