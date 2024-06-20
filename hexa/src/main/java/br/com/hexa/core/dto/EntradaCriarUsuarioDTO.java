package br.com.hexa.core.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EntradaCriarUsuarioDTO {

    private String primeiroNome;

    private String ultimoNome;
}
