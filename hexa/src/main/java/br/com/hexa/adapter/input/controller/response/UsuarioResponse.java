package br.com.hexa.adapter.input.controller.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioResponse {

    private Integer id;

    private String nome;

    public UsuarioResponse() {
    }

    public UsuarioResponse(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
