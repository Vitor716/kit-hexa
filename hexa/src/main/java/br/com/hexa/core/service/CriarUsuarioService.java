package br.com.hexa.core.service;

import br.com.hexa.adapter.output.repository.UsuarioRepository;
import br.com.hexa.core.dto.EntradaCriarUsuarioDTO;
import br.com.hexa.core.dto.SaidaCriarUsuarioDTO;
import br.com.hexa.core.port.input.CriarUsuarioInputPort;
import br.com.hexa.core.usercase.FormataNomeUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CriarUsuarioService implements CriarUsuarioInputPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(CriarUsuarioService.class);

    private final FormataNomeUseCase formataNomeUseCase;

    private final UsuarioRepository repository;

    public CriarUsuarioService(FormataNomeUseCase formataNomeUseCase, UsuarioRepository repository) {
        this.formataNomeUseCase = formataNomeUseCase;
        this.repository = repository;
    }

    @Override
    public SaidaCriarUsuarioDTO criar(EntradaCriarUsuarioDTO entrada) {

        EntradaCriarUsuarioDTO dadosRepository = repository.save(entrada);

        String nomeFormatado = formataNomeUseCase.formatarNome(dadosRepository);

        SaidaCriarUsuarioDTO saida = new SaidaCriarUsuarioDTO();
        saida.setId(dadosRepository.getId());
        saida.setNome(nomeFormatado);

        return saida;
    }
}
