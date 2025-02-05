package foro.hub.api.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    UserDetails findByLogin(String username);
}
