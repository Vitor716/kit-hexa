package br.com.hexa.adapter.input.controller.openapi;

import br.com.hexa.adapter.input.controller.request.UsuarioRequest;
import br.com.hexa.adapter.input.controller.response.UsuarioResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;


@Tag(name = "Aplicação hexa", description = "Aplicação base para projetos hexagonal")
public interface HexaOpenApi {

    @Operation(summary = "Consultar dados do cliente", description = "Endpoint para consulta de dados do cliente")
    //x-stateless
    ResponseEntity<UsuarioResponse> criar(@Valid UsuarioRequest request);
}
