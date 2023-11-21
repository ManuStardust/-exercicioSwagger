package com.manustardust.lombok.projetoLombok.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manustardust.lombok.projetoLombok.entities.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}