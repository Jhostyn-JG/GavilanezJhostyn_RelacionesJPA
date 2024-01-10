package jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Modelo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jjgs_position")
public class jjgs_Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jjgs_p_id;

    private String jjgs_p_name;

    @OneToMany(mappedBy = "jjgs_position", cascade = CascadeType.ALL)
    private List<jjgs_Employee> jjgs_employee;

}