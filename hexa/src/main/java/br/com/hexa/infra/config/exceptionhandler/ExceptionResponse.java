package br.com.hexa.infra.config.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ExceptionResponse {

    @JsonProperty("timeStamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy hh:mm:ss")
    private LocalDateTime timeStamp;

    @JsonProperty("status")
    private HttpStatus status;

    @JsonProperty("codigoErro")
    private String codigoErro;

    @JsonProperty("message")
    private String mensagem;

    @JsonProperty("mensagemDetalhada")
    private String mensagemDetalhada;
}
