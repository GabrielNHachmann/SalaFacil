package com.sala.facil.controller;

import com.sala.facil.entity.Usuario;
import com.sala.facil.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> getUsuario(){
        return service.findAll();
    }

    @PostMapping
    public Usuario saveUsuario(@RequestBody Usuario usuario){
        Usuario usuarioSalvo = service.saveUsuario(usuario);
        return usuarioSalvo;
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable long id){
        Usuario usuario = service.findById(id);
        return usuario;
    }

    @PutMapping("/{id}")
    public Usuario editUsuario(@PathVariable long id, @RequestBody Usuario usuario){
        Usuario usuarioEdit = service.editUsuario(usuario, id);
        return usuarioEdit;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        service.deleteUser(id);
    }
}
