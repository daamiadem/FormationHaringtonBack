package formationHarington.Model;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdCommande ;
    private  String Description ;
    private LocalDate DateLivraison ;
    private String NomBoutique ;
    private Integer poids ;

    @ManyToOne
    private Client client ;

}
