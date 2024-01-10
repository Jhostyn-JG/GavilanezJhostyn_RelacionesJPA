package jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Servicio;

import jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Modelo.jjgs_Employee;
import jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Modelo.jjgs_Position;
import jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Repositorio.jjgs_EmployeeRepositorio;
import jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Repositorio.jjgs_PositionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class jjgs_EmployeeServicio {


    @Autowired
    private jjgs_EmployeeRepositorio jjgsemployeeRepositorio;

    @Autowired
    private jjgs_PositionRepositorio jjgs_positionRepositorio;


    public List<jjgs_Employee> jjgs_buscartodos() {
        return jjgsemployeeRepositorio.findAll();
    }

    public jjgs_Employee jjgs_buscarporId(Integer id) {
        return jjgsemployeeRepositorio.findById(id).orElse(null);
    }


    public jjgs_Employee jjgs_crearEmployee(String name, String email, Integer positionId) {
        jjgs_Employee newEmployee = new jjgs_Employee();
        newEmployee.setJjgs_name(name);
        newEmployee.setJjgs_email(email);
        jjgs_Position position = jjgs_positionRepositorio.findById(positionId).orElse(null);
        if (position == null) {
            throw new RuntimeException("Position not found");
        }
        newEmployee.setJjgs_position(position);
        return jjgsemployeeRepositorio.save(newEmployee);
    }

    public String jjgs_eliminarPorId(Integer id) {
        jjgsemployeeRepositorio.deleteById(id);
        return "El empleado con id " + id + " esta eliminado";
    }

    public jjgs_Employee jjgs_actualizar(Integer id, jjgs_Employee newEmployee) {
        return jjgsemployeeRepositorio.findById(id)
                .map(employee -> {
                    employee.setJjgs_name(newEmployee.getJjgs_name());
                    employee.setJjgs_email(newEmployee.getJjgs_email());
                    jjgs_Position position = jjgs_positionRepositorio.findById(newEmployee.getJjgs_position().getJjgs_p_id()).orElse(null);
                    if (position == null) {
                        throw new RuntimeException("Position not found");
                    }
                    employee.setJjgs_position(position);
                    return jjgsemployeeRepositorio.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setJjgs_id(id);
                    jjgs_Position position = jjgs_positionRepositorio.findById(newEmployee.getJjgs_position().getJjgs_p_id()).orElse(null);
                    if (position == null) {
                        throw new RuntimeException("Position not found");
                    }
                    newEmployee.setJjgs_position(position);
                    return jjgsemployeeRepositorio.save(newEmployee);
                });
    }

    // Agregar método para consultar empleados por nombre de posición
    public List<jjgs_Employee> jjgsBuscarPorNombreDePosicion(String jjgs_p_name) {
        return jjgsemployeeRepositorio.findByPositionName(jjgs_p_name);
    }

    // Agregar método para contar empleados por posición
    public List<Object[]> jjgsContarEmpleadosPorPosicion() {
        return jjgsemployeeRepositorio.jjgsCountEmployeesByPosition();
    }

}
