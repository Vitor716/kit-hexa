package br.com.hexa.adapter.output.repository;

import br.com.hexa.core.dto.EntradaCriarUsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<EntradaCriarUsuarioDTO, Integer> {
}
