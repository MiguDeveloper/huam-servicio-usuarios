package pe.tuna.huamserviciousuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.tuna.huamserviciousuarios.models.Alumno;
import pe.tuna.huamserviciousuarios.service.IAlumnoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping("/")
    public ResponseEntity<?> findAll() {

        Map<String, Object> response = new HashMap<>();
        List<Alumno> alumnos = null;
        try {
            alumnos = alumnoService.findAll();
        } catch (DataAccessException ex) {
            response.put("isSucces", false);
            response.put("message", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause()
                    .getMessage()));
            System.out.println("error al listar alumnos: " + ex.getMessage());
            return new ResponseEntity<Map<String, Object>>(response,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("alumnos", alumnos);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {

        Alumno alumno;
        Map<String, Object> response = new HashMap<>();
        try {
            alumno = alumnoService.findById(id).orElse(null);
        } catch (DataAccessException ex) {
            response.put("isSuccess", false);
            response.put("message", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause()
                    .getMessage()));

            return new ResponseEntity<Map<String, Object>>(response,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("alumno", alumno);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    @PostMapping("/")
    public ResponseEntity<?> createAlumno(@RequestBody Alumno alumno) {

        Map<String, Object> response = new HashMap<String, Object>();
        Alumno alumnoNew;
        try {
            alumnoNew = alumnoService.save(alumno);
        } catch (DataAccessException ex) {
            response.put("isSuccess", false);
            response.put("message", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause()
                    .getMessage()));

            return new ResponseEntity<Map<String, Object>>(response,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("alumno", alumnoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAlumno(@PathVariable long id, @RequestBody Alumno alumno) {
        Alumno alumnoBd;
        Alumno alumnoUpdate;
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            alumnoBd = alumnoService.findById(id).get();
            alumnoBd.setNombre(alumno.getNombre());
            alumnoBd.setApellido(alumno.getApellido());
            alumnoBd.setEmail(alumno.getEmail());
            alumnoUpdate = alumnoService.save(alumnoBd);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlumno(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            alumnoService.deleteById(id);
        } catch (DataAccessException ex) {
            response.put("isSuccess", false);
            response.put("message", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause()
                    .getMessage()));

            return new ResponseEntity<Map<String, Object>>(response,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return  ResponseEntity.noContent().build();
    }
}
