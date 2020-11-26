package pe.tuna.huamserviciousuarios.service;

import pe.tuna.commonsalumnos.models.Alumno;
import pe.tuna.commonsmicroservicios.services.ICommonService;

import java.util.List;

public interface IAlumnoService extends ICommonService<Alumno> {
    public List<Alumno> findByNombreOrApellido(String termino);
}
