package br.com.hexa.config;

import br.com.hexa.core.usercase.FormataNomeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FormataNomeUseCaseConfig {

    @Bean
    public FormataNomeUseCase formataNomeUseCase(){
        return new FormataNomeUseCase();
    }
}
