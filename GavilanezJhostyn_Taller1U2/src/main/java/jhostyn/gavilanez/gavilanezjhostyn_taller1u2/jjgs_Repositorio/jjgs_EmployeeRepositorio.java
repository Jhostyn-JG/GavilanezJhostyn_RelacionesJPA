package jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Repositorio;

import jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Modelo.jjgs_Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface jjgs_EmployeeRepositorio extends JpaRepository<jjgs_Employee, Integer> {

    //Consultas JPQL relacionadas
    //List<jjgs_Employee> findByPositionName(String jjgs_p_name);
    @Query("SELECT e FROM jjgs_Employee e WHERE e.jjgs_position.jjgs_p_name = :positionName")
    List<jjgs_Employee> findByPositionName(@Param("positionName") String positionName);

    @Query("SELECT p.jjgs_p_name, COUNT(e) FROM jjgs_Position p LEFT JOIN p.jjgs_employee e GROUP BY p.jjgs_p_name")
    List<Object[]> jjgsCountEmployeesByPosition();

}
