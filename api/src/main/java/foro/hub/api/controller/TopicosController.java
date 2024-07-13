package foro.hub.api.controller;


import foro.hub.api.topicos.DTOActualizarTopicos;
import foro.hub.api.topicos.DTORegistroDeTopico;
import foro.hub.api.topicos.Topicos;
import foro.hub.api.topicos.TopicosRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicosRepository topicosRepository;

    @PostMapping
    public void registrartopico(@RequestBody @Valid DTORegistroDeTopico registroDeTopico){
        topicosRepository.save(new Topicos(registroDeTopico));
    }

    @GetMapping
    public Page<Topicos> verListaDeTopicos(Pageable paginacion){
        return topicosRepository.findByestadoUsuarioTrue(paginacion);
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DTOActualizarTopicos actualizarTopicos){
        Topicos topicos = topicosRepository.getReferenceById(actualizarTopicos.id());
        topicos.actualizacion(actualizarTopicos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topicos topicos = topicosRepository.getReferenceById(id);
        topicos.desactivarTopico();
        return ResponseEntity.noContent().build();
    }


}
