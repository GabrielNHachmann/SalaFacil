package com.sala.facil.service;

import com.sala.facil.entity.Usuario;
import com.sala.facil.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Usuario saveUsuario(Usuario usuario){
        return repository.save(usuario);
    }

    public Usuario findById(long id){
        Usuario usuario = repository.findById(id).orElse(null);
        return usuario;
    }

    public Usuario editUsuario(Usuario usuario, long id){
        Usuario oldUser = this.findById(id);

        if(usuario.getCpf() != null){
            oldUser.setCpf(usuario.getCpf());
        }

        oldUser.setId(usuario.getId()!= null ? usuario.getId() : oldUser.getId());
        oldUser.setNome(usuario.getNome() != null ? usuario.getNome() : oldUser.getNome());
        oldUser.setEmail(usuario.getEmail() != null ? usuario.getEmail() : oldUser.getEmail());
        oldUser.setPhone(usuario.getPhone() != null ? usuario.getPhone() : oldUser.getPhone());

        return repository.save(oldUser);
    }

    public void deleteUser(long id){
        repository.deleteById(id);
    }


}
