package foro.hub.api.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DTOUsuariosRegistrados(

        @NotBlank
        String login,
        @NotBlank
        String password
) {
}
