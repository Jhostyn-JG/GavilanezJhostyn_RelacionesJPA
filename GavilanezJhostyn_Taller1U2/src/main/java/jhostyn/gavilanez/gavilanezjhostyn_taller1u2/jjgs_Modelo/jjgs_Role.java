package jhostyn.gavilanez.gavilanezjhostyn_taller1u2.jjgs_Modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jjgs_role")
public class jjgs_Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jjgs_role_id;
    private String jjgs_role_name;
    @ManyToMany(mappedBy = "jjgsRole")
    private List<jjgs_Account> jjgsAccount;
}
