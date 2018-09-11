package susitio.comptabilite.project.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import susitio.comptabilite.project.dao.DocumentRepository;
import susitio.comptabilite.project.dao.NotificationRepository;
import susitio.comptabilite.project.entities.Document;
import susitio.comptabilite.project.entities.Notification;
import susitio.comptabilite.project.enums.TypeFolder;
import susitio.comptabilite.project.enums.TypeNotification;

@Service
public class DocumentServiceImpl implements DocumentService{
	
	private final Path rootLocation = Paths.get("ProfilePictureStore");
	
	@Autowired
	DocumentRepository documentRepository;
	@Autowired
	NotificationService notificationService ;

    @Override
    public List<Document> getDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Document getDocumentById(int id) {
        return documentRepository.findById(id).get();
    }

    @Override
    public void deleteDocument(int id) {
    	documentRepository.deleteById(id);
    }

	@Override
	public void uploadDocuments(MultipartFile file , TypeFolder type , String annee) {
		Document document = new Document(file.getOriginalFilename(),rootLocation.toUri().toString(),annee,type);
		documentRepository.save(document);
		String message = "";
		try {

			  try {
			   System.out.println(file.getOriginalFilename());
			   System.out.println(rootLocation.toUri());
			   Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
			  } catch (Exception e) {
			   throw new RuntimeException("FAIL!");
			  }
			 
	    	   message = "You successfully uploaded " + file.getOriginalFilename() + "!";

	    	  } catch (Exception e) {
	    	   message = "Fail to upload Profile Picture" + file.getOriginalFilename() + "!";
	    	  }
	/*	String contenueNotification = client.getNom() + "\n" + message.getObject() ;
		Notification notification = new Notification(TypeNotification.document,contenueNotification,document.getId()) ;
		notificationService.addNotification(notification); */
	}
}
