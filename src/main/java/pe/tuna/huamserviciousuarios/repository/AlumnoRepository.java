package pe.tuna.huamserviciousuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.tuna.commonsalumnos.models.Alumno;

import java.util.List;


public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    @Query("SELECT a FROM Alumno a WHERE a.nombre LIKE %?1% OR a.apellido LIKE %?1%")
    public List<Alumno> findByNombreOrApellido(String termino);
}
