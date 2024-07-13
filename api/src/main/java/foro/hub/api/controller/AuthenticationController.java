package foro.hub.api.controller;
import foro.hub.api.infra.security.DTOJWTToken;
import foro.hub.api.infra.security.TokenService;
import foro.hub.api.usuarios.DTOUsuariosRegistrados;
import foro.hub.api.usuarios.Usuarios;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DTOUsuariosRegistrados usuariosRegistrados){
        Authentication authToken = new UsernamePasswordAuthenticationToken(usuariosRegistrados.login(), usuariosRegistrados.password());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTToken = tokenService.generarToken((Usuarios) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DTOJWTToken(JWTToken));

    }
}
