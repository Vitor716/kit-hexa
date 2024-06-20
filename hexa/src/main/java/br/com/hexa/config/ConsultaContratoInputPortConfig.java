package br.com.hexa.config;

import br.com.hexa.core.port.input.CriarUsuarioInputPort;
import br.com.hexa.core.service.CriarUsuarioService;
import br.com.hexa.core.usercase.FormataNomeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsultaContratoInputPortConfig {

    @Bean
    public CriarUsuarioInputPort criarUsuarioInputPort(FormataNomeUseCase formataNomeUseCase){
        return new CriarUsuarioService(formataNomeUseCase);
    }
}
