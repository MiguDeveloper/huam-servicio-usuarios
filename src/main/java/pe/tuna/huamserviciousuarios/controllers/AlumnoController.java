package pe.tuna.huamserviciousuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.tuna.commonsmicroservicios.controllers.CommonController;
import pe.tuna.huamserviciousuarios.models.Alumno;
import pe.tuna.huamserviciousuarios.service.IAlumnoService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AlumnoController extends CommonController<Alumno, IAlumnoService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAlumno(@PathVariable long id, @RequestBody Alumno alumno) {
        Alumno alumnoBd;
        Alumno alumnoUpdate;
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            alumnoBd = servicio.findById(id);
            alumnoBd.setNombre(alumno.getNombre());
            alumnoBd.setApellido(alumno.getApellido());
            alumnoBd.setEmail(alumno.getEmail());
            alumnoUpdate = servicio.save(alumnoBd);
        } catch (DataAccessException ex) {
            response.put("isSuccess", false);
            response.put("message", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause()
                    .getMessage()));

            return new ResponseEntity<Map<String, Object>>(response,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("alumno", alumnoUpdate);
        return new ResponseEntity<Map<String, Object>>(response,
                HttpStatus.CREATED);
    }

}
