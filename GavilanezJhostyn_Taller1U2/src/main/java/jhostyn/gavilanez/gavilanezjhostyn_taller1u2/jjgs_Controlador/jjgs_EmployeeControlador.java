package jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Controlador;


import jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Modelo.jjgs_Employee;
import jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Servicio.jjgs_EmployeeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jjgsapi/jjgsemployees")
public class jjgs_EmployeeControlador {

    @Autowired
    private jjgs_EmployeeServicio jjgsemployeeServicio;



    @PostMapping
    public jjgs_Employee jjgscrearEmployee(@RequestBody jjgs_Employee newEmployee) {
        return jjgsemployeeServicio.jjgs_crearEmployee(newEmployee.getJjgs_name(), newEmployee.getJjgs_email(), newEmployee.getJjgs_position().getJjgs_p_id());
    }

    @GetMapping
    public List<jjgs_Employee> jjgsgetAllEmployees() {
        return jjgsemployeeServicio.jjgs_buscartodos();
    }

    @GetMapping("/{jjgsid}")
    public jjgs_Employee jjgsgetEmployeeById(@PathVariable Integer jjgsid) {
        return jjgsemployeeServicio.jjgs_buscarporId(jjgsid);
    }

    @PutMapping("/{jjgsid}")
    public jjgs_Employee updateEmployee(@PathVariable Integer jjgsid, @RequestBody jjgs_Employee updatedEmployee) {
        return jjgsemployeeServicio.jjgs_actualizar(jjgsid, updatedEmployee);
    }

    @DeleteMapping("/{jjgsid}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer jjgsid) {
        String response = jjgsemployeeServicio.jjgs_eliminarPorId(jjgsid);
        return ResponseEntity.ok(response);
    }

    // Consultas JPQL relacionadas
    @GetMapping("/jjgsnombrePos/{jjgspositionName}")
    public List<jjgs_Employee> jjgsObtenerPorNombreDePosicion(@PathVariable String jjgspositionName) {
        return jjgsemployeeServicio.jjgsBuscarPorNombreDePosicion(jjgspositionName);
    }

    @GetMapping("/jjgsContarPos")
    public List<Object[]> jjgsContarEmpleadosPorPosicion() {
        return jjgsemployeeServicio.jjgsContarEmpleadosPorPosicion();
    }

}
