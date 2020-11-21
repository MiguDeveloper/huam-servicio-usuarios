package pe.tuna.huamserviciousuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.tuna.huamserviciousuarios.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
