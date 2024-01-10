package jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Controlador;


import jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Modelo.jjgs_Position;
import jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Servicio.jjgs_PositionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jjgsapi/jjgspositions")
public class jjgs_PositionControlador {

    @Autowired
    private jjgs_PositionServicio jjgspositionServicio;

    @GetMapping
    public List<jjgs_Position> jjgs_getAllPositions() {
        return jjgspositionServicio.jjgs_buscarTodos();
    }

    @GetMapping("/{jjgsid}")
    public jjgs_Position bfcm_getPositionById(@PathVariable Integer jjgsid) {
        return jjgspositionServicio.jjgs_buscarPorId(jjgsid);
    }

    @PostMapping
    public jjgs_Position createPosition(@RequestBody jjgs_Position position) {
        return jjgspositionServicio.jjgs_crearPosition(position.getJjgs_p_name());
    }

    @PutMapping("/{jjgsid}")
    public jjgs_Position bfcm_updatePosition(@PathVariable Integer jjgsid,
                                             @RequestBody jjgs_Position newPosition) {
        return jjgspositionServicio.jjgs_actualizar(jjgsid, newPosition);
    }

    // In bfcm_RestPosition.java
    @DeleteMapping("/{jjgsid}")
    public ResponseEntity<String> bfcm_deletePosition(@PathVariable Integer jjgsid) {
        String response = jjgspositionServicio.jjgs_eliminarPorId(jjgsid);
        return ResponseEntity.ok(response);
    }

}
