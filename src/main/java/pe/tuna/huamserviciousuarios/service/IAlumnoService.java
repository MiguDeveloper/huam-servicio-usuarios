package pe.tuna.huamserviciousuarios.service;

import pe.tuna.huamserviciousuarios.models.Alumno;

import java.util.List;
import java.util.Optional;

public interface IAlumnoService {
    public List<Alumno> findAll();
    public Optional<Alumno> findById(Long id);
    public Alumno save(Alumno alumno);
    public void deleteById(Long id);
}
