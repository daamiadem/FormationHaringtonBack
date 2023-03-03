package formationHarington.Controller;

import formationHarington.Manager.ClientManagerImpl;
import formationHarington.Model.Client;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/api")
@Validated
@AllArgsConstructor

@CrossOrigin(origins = {"http://localhost:4200"})
public class ClientController {

    private  final ClientManagerImpl clientService ;

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/GetAllClients")
    ResponseEntity<List<Client>>  getAllCLients  (){
        return ResponseEntity.ok(clientService.GetAllClient());
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/GetClientsByProfessions/{profession}")
    ResponseEntity<List<Client>>  getClientsByProfession  (@PathVariable ("profession") String Profession){
        return ResponseEntity.ok(clientService.GetClientByProfession(Profession));
    }


    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/GetClientsByName/{name}")
    ResponseEntity<List<Client>>  getClientsByName  (@PathVariable ("name") String Name){
        return ResponseEntity.ok(clientService.GetClientByname(Name));
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/GetClientsByid/{id}")
    ResponseEntity<Client>  getClientsById  (@PathVariable ("id") Long id){
        return ResponseEntity.ok(clientService.GetClientByID(id));
    }

    /*@GetMapping(produces = APPLICATION_JSON_VALUE, path = "/GetClientsByDate")
    ResponseEntity<List<Client>>  getClientsByDate (@RequestBody LocalDate StartDate, @RequestBody LocalDate endDate){
        return ResponseEntity.ok(clientService.GetClientsDataBirth(StartDate,endDate));
    }*/


    @PostMapping(produces = APPLICATION_JSON_VALUE, path = "/CreateClient")
    ResponseEntity<Client>  CreateClient (@RequestBody Client client){
        return ResponseEntity.ok(clientService.CreateNewClient(client));
    }

    @PutMapping(produces = APPLICATION_JSON_VALUE, path = "/UpdateClient/{id}")
    ResponseEntity<Client>  UpdateClient (@RequestBody Client client, @PathVariable("id") Long ID){
        return ResponseEntity.ok(clientService.updateClient(client , ID));
    }

    @DeleteMapping(produces = APPLICATION_JSON_VALUE, path = "/DeleteClient/{id}")
    ResponseEntity<Long>  DeleteClient (@PathVariable("id") Long ID){
        return ResponseEntity.ok(clientService.DeleteClient(ID));
    }



}
