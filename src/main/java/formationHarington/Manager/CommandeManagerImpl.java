package formationHarington.Manager;



import formationHarington.Model.Client;
import formationHarington.Model.Commande;
import formationHarington.Model.Produit;
import formationHarington.Repository.ClientRepository;
import formationHarington.Repository.ProduitRepository;
import formationHarington.Repository.commandeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
@CrossOrigin
public class CommandeManagerImpl {


    private final commandeRepository commandeRepository ;
    private final ClientRepository clientRepository;
    private final ProduitRepository ProduitRepo ;

    public Commande CreateNewCommandeAndAffecte (Commande commande , Long IdClient){
        Client client = clientRepository.findById(IdClient).orElse(null);
        commande.setClient(client);
        return commandeRepository.save(commande) ;
    }

    public List<Commande> GetAllCommande (){
        return commandeRepository.findAll();
    }

    public Commande GetCommandeById (Long idCommande){
        return commandeRepository.findById(idCommande).orElse(null) ;
    }

    public Commande UpdateCommande (Commande commande , Long IdCommande) {
        Commande Oldcommande = commandeRepository.findById(IdCommande).orElse(null) ;
        Oldcommande.setDescription(commande.getDescription());
        Oldcommande.setPoids(commande.getPoids());
        Oldcommande.setDateLivraison(commande.getDateLivraison());
        Oldcommande.setNomBoutique(commande.getNomBoutique());
        return commandeRepository.save(Oldcommande);
    }
    public List<Produit> GetProduitParCommande(Long IdCommande){
        List<Produit> produits = ProduitRepo.findAll();
        return produits.stream().filter(produit -> produit.getCommande().getIdCommande()==IdCommande).collect(Collectors.toList());
    }

    public Client GetClientCommande (Long IdCommande){
        Commande commande = commandeRepository.findById(IdCommande).orElse(null) ;
        return commande.getClient();
    }
    public Long DeleteCommande (Long IdCommande){
        commandeRepository.deleteById(IdCommande);
        return IdCommande ;

    }




}
