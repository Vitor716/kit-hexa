package br.com.hexa.core.port.input;

import br.com.hexa.core.dto.EntradaCriarUsuarioDTO;
import br.com.hexa.core.dto.SaidaCriarUsuarioDTO;

public interface CriarUsuarioInputPort {

    SaidaCriarUsuarioDTO criar(EntradaCriarUsuarioDTO entrada);
}
