package formationHarington.Manager;

import formationHarington.Model.Commande;
import formationHarington.Model.Produit;
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
public class ProduitManagerImpl {


    private final ProduitRepository produitRepository ;
    private final commandeRepository commandeRepository ;



    public Produit createNewProduit ( Produit produit , Long IdCommande) {
        Commande commande = commandeRepository.findById(IdCommande).orElse(null) ;
        produit.setCommande(commande);
        return produitRepository.save(produit) ;

    }


    public List<Produit> GetAllProduit (){
        return produitRepository.findAll();
    }

    public Long DeleteProduit( Long Id ){
        produitRepository.deleteById(Id);
        return Id ;
    }

    public Produit UpdateProduit (Produit produit , Long IdProduit){
        Produit OldProduit = produitRepository.findById(IdProduit).orElse(null) ;
        OldProduit.setProduitName(produit.getProduitName());
        OldProduit.setCategorie(produit.getCategorie());
        OldProduit.setDescription(produit.getDescription());
        return produitRepository.save(OldProduit) ;
    }

    public List<Produit> GetProduitByCategorie(String Categorie ){
        return produitRepository.findAll().stream().filter(produit -> produit.getCategorie().equals(Categorie)).collect(Collectors.toList());
    }

    public Produit GetProduitById (Long Id ){
        return produitRepository.findById(Id).orElse(null) ;
    }



}
