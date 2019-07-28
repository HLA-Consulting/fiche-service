package com.example.demo.model;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.nio.file.Files;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RestController

public class controller {
@Autowired

enfantRepository enfantRepository;
    public controller()
    {}





@GetMapping({"/enfants"})
    public List<enfant> getAllEnfants()
{
    System.out.println("Recuperer toutes les fiches des enfants");
    List<enfant> enfants = new ArrayList();
    this.enfantRepository.findAll().forEach(enfants::add);
    return enfants;
}


    @PostMapping({"/create"})


    public void createenfant(@RequestBody enfant enfant)
{enfant _enfant= (enfant)this.enfantRepository.save(
        new enfant(enfant.getId(), enfant.getNom(),enfant.getPrénom(),enfant.getClasse(),enfant.getDateNaissance(),enfant.getDateInscription()));
}


@PutMapping({"/enfant/{id}"})
    public ResponseEntity<enfant> updateenfant(@PathVariable("id") Long id , @RequestBody enfant enfant)
{

    System.out.println("Mise a jour l'enfant ayant l'id " + id +"");
    Optional<enfant> enfantData = this.enfantRepository.findById(id);
    if(enfantData.isPresent())
    {enfant _enfant =(enfant) enfantData.get();
        _enfant.setClasse(enfant.getClasse());
        _enfant.setDateInscription(enfant.getDateInscription());
        return new ResponseEntity(this.enfantRepository.save(_enfant),HttpStatus.OK) ;}
        else
    {return new ResponseEntity(HttpStatus.NOT_FOUND);}

}



@GetMapping({"/enfants/{id}"})
    public Optional<enfant> trouverlenfant(@PathVariable("id") long id)
{
    System.out.println("l'enfant ayant l ' id "+id+"");

    return this.enfantRepository.findById(id);


}

}



