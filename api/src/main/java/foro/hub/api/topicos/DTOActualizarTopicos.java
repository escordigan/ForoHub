package foro.hub.api.topicos;

import jakarta.validation.constraints.NotNull;

public record DTOActualizarTopicos(

        @NotNull
        Long id,
        String titulo,
        String mensajeEnPantalla
) {
}
