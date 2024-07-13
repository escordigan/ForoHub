package foro.hub.api.topicos;


//Para recibir y visibilizar los datos especificos, seleccionados o deseados a mostrar en pantalla//

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DTORegistroDeTopico(

        @NotBlank
        String id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensajeEnPantalla,
        @NotBlank
        String fechaDeCreacion
){
}
