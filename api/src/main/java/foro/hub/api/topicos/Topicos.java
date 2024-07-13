package foro.hub.api.topicos;

//Para la persistencia de datos en MySql//

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensajeEnPantalla;
    private String fechaDeCreacion;
    private Boolean estadoUsuario;

    public Topicos(DTORegistroDeTopico registroDeTopico) {
        this.estadoUsuario = true;
        this.titulo=registroDeTopico.titulo();
        this.mensajeEnPantalla=registroDeTopico.mensajeEnPantalla();
        this.fechaDeCreacion=registroDeTopico.fechaDeCreacion();
    }

    public void actualizacion(DTOActualizarTopicos actualizarTopicos) {
        if (actualizarTopicos.titulo() != null){

            this.titulo=actualizarTopicos.titulo();
        }

        if (actualizarTopicos.mensajeEnPantalla() != null){

            this.mensajeEnPantalla=actualizarTopicos.mensajeEnPantalla();
        }
    }

    public void desactivarTopico() {
        this.estadoUsuario= false;


    }
}
