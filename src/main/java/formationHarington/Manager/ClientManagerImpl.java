package formationHarington.Manager;


import formationHarington.Model.Client;
import formationHarington.Repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
@CrossOrigin
public class ClientManagerImpl {

private final ClientRepository clientRepository ;


public Client CreateNewClient (Client client){
    return clientRepository.save(client) ;

}
public Long DeleteClient (Long id ){
    clientRepository.deleteById(id);
    return id ;
}

public Client updateClient ( Client client , Long id ) {
    Client oldClient = clientRepository.findById(id).orElse(null) ;
    oldClient.setNameClient(client.getNameClient());
    oldClient.setProfession(client.getProfession());
    oldClient.setBirthDate(client.getBirthDate());
    oldClient.setPhoneNumber(client.getPhoneNumber());
    return clientRepository.save(oldClient) ;
}

public List<Client> GetAllClient(){
    return clientRepository.findAll();
}

public Client GetClientByID (Long id ){
    return clientRepository.findById(id).orElse(null) ;
}

public List<Client> GetClientByProfession (String profession){
    List<Client> clientsProfession = clientRepository.findAll().stream().filter(cl-> cl.getProfession().equals(profession)).collect(Collectors.toList());
    return clientsProfession ;

}

public List<Client> GetClientsDataBirth (LocalDate startDate , LocalDate EndDate){
    List<Client> clientDateBirth = clientRepository.findAll().stream().filter(cl-> cl.getBirthDate().isAfter(EndDate)&& cl.getBirthDate().isBefore(startDate)).collect(Collectors.toList());
    return clientDateBirth ;

}

public List<Client> GetClientByname(String name){
    List<Client> clientByName = clientRepository.findAll().stream().filter(cl-> cl.getNameClient().equals(name)).collect(Collectors.toList());
    return clientByName ;
}



}
