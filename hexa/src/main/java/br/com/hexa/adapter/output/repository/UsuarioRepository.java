package br.com.hexa.adapter.output.repository;


import br.com.hexa.adapter.input.controller.request.UsuarioRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioRequest, Integer> {
}
