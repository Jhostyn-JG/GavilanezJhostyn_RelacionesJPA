package jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Servicio;

import jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Modelo.jjgs_Position;
import jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Repositorio.jjgs_PositionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class jjgs_PositionServicio {

    @Autowired
    private jjgs_PositionRepositorio jjgs_positionRepositorio;

    public List<jjgs_Position> jjgs_buscarTodos() {
        return jjgs_positionRepositorio.findAll();
    }

    public jjgs_Position jjgs_buscarPorId(Integer id) {
        return jjgs_positionRepositorio.findById(id).orElse(null);
    }

    public jjgs_Position jjgs_crearPosition(String name) {
        jjgs_Position nuevaPosicion = new jjgs_Position();
        nuevaPosicion.setJjgs_p_name(name);
        return jjgs_positionRepositorio.save(nuevaPosicion);
    }

    public String jjgs_eliminarPorId(Integer id) {
        jjgs_positionRepositorio.deleteById(id);
        return "La posición con id " + id + " esta eliminada de la BDD";
    }

    public jjgs_Position jjgs_actualizar(Integer id, jjgs_Position nuevaPosicion) {
        return jjgs_positionRepositorio.findById(id)
                .map(position -> {
                    position.setJjgs_p_name(nuevaPosicion.getJjgs_p_name());
                    return jjgs_positionRepositorio.save(position);
                })
                .orElseGet(() -> {
                    nuevaPosicion.setJjgs_p_id(id);
                    return jjgs_positionRepositorio.save(nuevaPosicion);
                });
    }


    // Consultas JPQL relacionadas


}
