package susitio.comptabilite.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import susitio.comptabilite.project.entities.Collaborateur;
import susitio.comptabilite.project.services.CollaborateurService;

import java.util.List;

@RestController
@RequestMapping("/collaborateur")
public class CollaborateurController {

    @Autowired
    CollaborateurService collaborateurService ;

    @PostMapping("/add")
    public void addCollaborateur(@RequestBody Collaborateur collaborateur){
        collaborateurService.addCollaborateur(collaborateur);
    }
    @GetMapping("getAll")
    public List<Collaborateur> getAllCollaborateurs(){
        return collaborateurService.getCollaborateurs() ;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCollaborateur(@PathVariable final int id){
        collaborateurService.deleteCollaborateur(id);
    }
}
