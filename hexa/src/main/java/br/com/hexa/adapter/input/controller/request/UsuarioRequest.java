package br.com.hexa.adapter.input.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UsuarioRequest {

    @JsonProperty("primeiroNome")
    private String primeiroNome;

    @JsonProperty("ultimoNome")
    private String ultimoNome;
}
