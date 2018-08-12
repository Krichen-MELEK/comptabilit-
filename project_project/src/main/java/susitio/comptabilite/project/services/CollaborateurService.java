package susitio.comptabilite.project.services;

import susitio.comptabilite.project.entities.Client;
import susitio.comptabilite.project.entities.Collaborateur;

import java.util.List;

public interface CollaborateurService {

    public List<Collaborateur> getCollaborateurs() ;
    public Collaborateur getCollaborateurById(int id ) ;
    public void addCollaborateur(Collaborateur collaborateur);
    public void deleteCollaborateur(int id) ;
}
