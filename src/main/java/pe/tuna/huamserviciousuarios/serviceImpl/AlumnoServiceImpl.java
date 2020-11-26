package pe.tuna.huamserviciousuarios.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.tuna.commonsalumnos.models.Alumno;
import pe.tuna.commonsmicroservicios.services.CommonServiceImpl;
import pe.tuna.huamserviciousuarios.repository.AlumnoRepository;
import pe.tuna.huamserviciousuarios.service.IAlumnoService;

import java.util.List;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository>
        implements IAlumnoService {

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findByNombreOrApellido(String termino) {
        return repository.findByNombreOrApellido(termino);
    }
}
