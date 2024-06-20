package br.com.hexa.adapter.input.controller;

import br.com.hexa.adapter.input.controller.openapi.HexaOpenApi;
import br.com.hexa.adapter.input.controller.request.UsuarioRequest;
import jakarta.validation.Valid;
import org.hexa.adapter.input.controller.response.UsuarioResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class HexaController implements HexaOpenApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(HexaController.class);

    public static final String URN_VERSAO = "/v1";
    public static final String URN_CONSULTAR_DADOS = URN_VERSAO + "/consultardados";

    @PostMapping(URN_CONSULTAR_DADOS)
    public ResponseEntity<UsuarioResponse> criar(@Valid @RequestBody UsuarioRequest request){
        LOGGER.info("consultar dados usuário: inicio{}" +request);
        return null;
    }
}
