package br.com.hexa.adapter.input.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UsuarioRequest {

    @JsonIgnore
    private Integer id;

    @JsonProperty("nome")
    private String nome;
}
