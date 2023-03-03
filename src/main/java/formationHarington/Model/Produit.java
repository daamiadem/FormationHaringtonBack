package formationHarington.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdProduit ;
    private String Categorie ;
    private String ProduitName ;
    private String Description ;
    //private String Image ;


    @ManyToOne
    private Commande commande ;

}
