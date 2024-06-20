package org.hexa.adapter.input.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class UsuarioResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nome")
    private String nome;
}
