package jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Repositorio;


import jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Modelo.jjgs_Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface jjgs_PositionRepositorio extends JpaRepository<jjgs_Position, Integer> {


}
