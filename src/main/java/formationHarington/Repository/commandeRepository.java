package formationHarington.Repository;

import formationHarington.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface commandeRepository extends JpaRepository<Commande, Long> {
}
