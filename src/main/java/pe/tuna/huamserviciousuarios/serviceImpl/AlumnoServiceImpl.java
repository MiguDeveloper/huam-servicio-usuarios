package pe.tuna.huamserviciousuarios.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.tuna.huamserviciousuarios.models.Alumno;
import pe.tuna.huamserviciousuarios.repository.AlumnoRepository;
import pe.tuna.huamserviciousuarios.service.IAlumnoService;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Alumno> findById(Long id) {
        return alumnoRepository.findById(id);
    }

    @Override
    @Transactional
    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        alumnoRepository.deleteById(id);
    }
}
