package br.com.hexa.infra.config.exception;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Accessors(chain = true)
public class BusinessException extends RuntimeException{

    @Getter(AccessLevel.NONE)
    private static final long serialVersionUID = 811729490504727051L;

    private LocalDateTime timeStamp;

    private String codigo;

    private String mensagem;

    private String mensagemDetalhada;
}
