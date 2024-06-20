package br.com.hexa.core.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SaidaCriarUsuarioDTO {

    private Integer id;

    private String nome;
}
