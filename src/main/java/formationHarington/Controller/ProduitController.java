package formationHarington.Controller;


import formationHarington.Manager.ProduitManagerImpl;
import formationHarington.Model.Commande;
import formationHarington.Model.Produit;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/api")
@Validated
@AllArgsConstructor

@CrossOrigin(origins = {"http://localhost:4200"})
public class ProduitController {

    private final ProduitManagerImpl produitService ;


    @PostMapping(produces = APPLICATION_JSON_VALUE, path = "/CreateProduit/{idCommande}")
    ResponseEntity<Produit> CreateProduit (@RequestBody Produit produit , @PathVariable("idCommande") Long idCommande  ){
        return ResponseEntity.ok(produitService.createNewProduit(produit , idCommande));
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/GetAllProduits")
    ResponseEntity<List<Produit>> getAllProduits  (){
        return ResponseEntity.ok(produitService.GetAllProduit());
    }


    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/GetProduitByID/{id}")
    ResponseEntity<Produit>  getProduitById  (@PathVariable("id") Long id){
        return ResponseEntity.ok(produitService.GetProduitById(id));
    }


    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/GetProduitByCategorie/{Categorie}")
    ResponseEntity<List<Produit>>  getCommandeById  (@PathVariable("Categorie") String Categorie){
        return ResponseEntity.ok(produitService.GetProduitByCategorie(Categorie));
    }


    @PutMapping(produces = APPLICATION_JSON_VALUE, path = "/UpdateProduit/{id}")
    ResponseEntity<Produit>  UpdateClient (@RequestBody Produit produit , @PathVariable("id") Long ID){
        return ResponseEntity.ok(produitService.UpdateProduit(produit , ID));
    }


    @DeleteMapping(produces = APPLICATION_JSON_VALUE, path = "/DeleteProduit/{idProduit}")
    ResponseEntity<Long>  DeleteClient (@PathVariable("idProduit") Long idProduit){
        return ResponseEntity.ok(produitService.DeleteProduit(idProduit));
    }








}
