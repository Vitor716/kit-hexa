package br.com.hexa.core.service;

import br.com.hexa.core.dto.EntradaCriarUsuarioDTO;
import br.com.hexa.core.dto.SaidaCriarUsuarioDTO;
import br.com.hexa.core.port.input.CriarUsuarioInputPort;
import br.com.hexa.core.usercase.FormataNomeUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CriarUsuarioService implements CriarUsuarioInputPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(CriarUsuarioService.class);

    private final FormataNomeUseCase formataNomeUseCase;

    public CriarUsuarioService(FormataNomeUseCase formataNomeUseCase) {
        this.formataNomeUseCase = formataNomeUseCase;
    }

    @Override
    public SaidaCriarUsuarioDTO criar(EntradaCriarUsuarioDTO entrada) {

        String nome = formataNomeUseCase.formatarNome(entrada);



        return null;
    }
}
