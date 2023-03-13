package formationHarington.Controller;


import formationHarington.Manager.CommandeManagerImpl;
import formationHarington.Model.Client;
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
public class CommandeController {

    private final CommandeManagerImpl commandeService ;

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/GetAllCommande")
    ResponseEntity<List<Commande>> getAllCommandes  (){
        return ResponseEntity.ok(commandeService.GetAllCommande());
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/GetCommandeByID/{id}")
    ResponseEntity<Commande>  getCommandeById  (@PathVariable("id") Long id){
        return ResponseEntity.ok(commandeService.GetCommandeById(id));
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, path = "/CreateCommande/{idClient}")
    ResponseEntity<Commande>  CreateCommande (@RequestBody Commande commande , @PathVariable("idClient") Long idClient ){
        return ResponseEntity.ok(commandeService.CreateNewCommandeAndAffecte(commande , idClient));
    }


    @PutMapping(produces = APPLICATION_JSON_VALUE, path = "/UpdateCommande/{id}")
    ResponseEntity<Commande>  UpdateClient (@RequestBody Commande commande, @PathVariable("id") Long ID){
        return ResponseEntity.ok(commandeService.UpdateCommande(commande , ID));
    }


    @DeleteMapping(produces = APPLICATION_JSON_VALUE, path = "/DeleteCommande/{idCommande}")
    ResponseEntity<Long>  DeleteClient (@PathVariable("idCommande") Long IdCommande){
        return ResponseEntity.ok(commandeService.DeleteCommande(IdCommande));
    }


    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/GetClientCommande/{id}")
    ResponseEntity<Client>  getClienCommande (@PathVariable("id") Long id){
        return ResponseEntity.ok(commandeService.GetClientCommande(id));
    }


    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/GetProduitByCommande/{id}")
    ResponseEntity<List<Produit>> getProduitsByCommande  (@PathVariable("id") Long id){
        return ResponseEntity.ok(commandeService.GetProduitParCommande(id));
    }





}
