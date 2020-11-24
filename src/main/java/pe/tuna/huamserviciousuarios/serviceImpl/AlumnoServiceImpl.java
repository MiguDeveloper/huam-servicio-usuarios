package pe.tuna.huamserviciousuarios.serviceImpl;

import org.springframework.stereotype.Service;
import pe.tuna.commonsmicroservicios.services.CommonServiceImpl;
import pe.tuna.huamserviciousuarios.models.Alumno;
import pe.tuna.huamserviciousuarios.repository.AlumnoRepository;
import pe.tuna.huamserviciousuarios.service.IAlumnoService;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository>
        implements IAlumnoService {

}
