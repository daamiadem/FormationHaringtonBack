package formationHarington.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdClient;
    private String NameClient;
    private String Profession ;
    private String PhoneNumber ;
    private LocalDate BirthDate ;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Commande> commandes = new ArrayList<>() ;




}
