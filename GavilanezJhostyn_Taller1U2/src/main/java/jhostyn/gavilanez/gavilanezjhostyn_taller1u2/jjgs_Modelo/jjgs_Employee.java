package jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jjgs_employee")
public class jjgs_Employee {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jjgs_id;
    private String jjgs_name;
    private String jjgs_email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "jjgs_position_id", nullable = false, referencedColumnName = "jjgs_p_id")
    private jjgs_Position jjgs_position;
}
