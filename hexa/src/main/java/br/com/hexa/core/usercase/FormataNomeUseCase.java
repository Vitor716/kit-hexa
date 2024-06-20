package br.com.hexa.core.usercase;

import br.com.hexa.core.dto.EntradaCriarUsuarioDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormataNomeUseCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormataNomeUseCase.class);

    public String formatarNome(EntradaCriarUsuarioDTO entrada){

        return entrada.getPrimeiroNome() + entrada.getUltimoNome();
    }
}
