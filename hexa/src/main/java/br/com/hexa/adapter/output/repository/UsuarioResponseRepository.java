package br.com.hexa.adapter.output.repository;

import br.com.hexa.adapter.input.controller.response.UsuarioResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioResponseRepository extends JpaRepository<UsuarioResponse, Integer> {
}
