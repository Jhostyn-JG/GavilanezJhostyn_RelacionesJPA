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
@Table(name = "jjgs_account")
public class jjgs_Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jjgs_id;

    private String jjgs_password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "jjgs_account_role",
            joinColumns = @JoinColumn(name = "jjgs_account_id", referencedColumnName = "jjgs_id"),
            inverseJoinColumns = @JoinColumn(name = "jjgs_role_id", referencedColumnName = "jjgs_role_id"))
    private List<jjgs_Role> jjgsRole;

}
