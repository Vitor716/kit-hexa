package br.com.hexa.adapter.input.controller;

import br.com.hexa.adapter.input.controller.openapi.HexaOpenApi;
import br.com.hexa.adapter.input.controller.request.UsuarioRequest;
import br.com.hexa.adapter.input.controller.response.UsuarioResponse;
import br.com.hexa.core.dto.EntradaCriarUsuarioDTO;
import br.com.hexa.core.dto.SaidaCriarUsuarioDTO;
import br.com.hexa.core.port.input.CriarUsuarioInputPort;
import br.com.hexa.infra.utils.ModelMapperUtils;
import jakarta.validation.Valid;
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
    public static final String URN_CRIAR_USUARIO = URN_VERSAO + "/usuario";

    private final CriarUsuarioInputPort criarUsuarioInputPort;

    public HexaController(CriarUsuarioInputPort criarUsuarioInputPort) {
        this.criarUsuarioInputPort = criarUsuarioInputPort;
    }

    @PostMapping(URN_CRIAR_USUARIO)
    public ResponseEntity<UsuarioResponse> criar(@Valid @RequestBody UsuarioRequest request){
        LOGGER.info("consultar dados usuário: inicio {}", request);
        EntradaCriarUsuarioDTO entrada = ModelMapperUtils.map(request, EntradaCriarUsuarioDTO.class);

        LOGGER.info("Criar usuario: {}", entrada);
        SaidaCriarUsuarioDTO resultado = criarUsuarioInputPort.criar(entrada);

        UsuarioResponse saida = ModelMapperUtils.map(resultado, UsuarioResponse.class);
        return ResponseEntity.ok(saida);
    }
}
