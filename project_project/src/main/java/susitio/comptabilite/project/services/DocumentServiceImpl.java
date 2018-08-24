package susitio.comptabilite.project.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import susitio.comptabilite.project.dao.DocumentRepository;
import susitio.comptabilite.project.entities.Document;

public class DocumentServiceImpl implements DocumentService{
	@Autowired
	DocumentRepository documentRepository;
    @Override
    public List<Document> getDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Document getDocumentById(int id) {
        return documentRepository.findById(id).get();
    }

    @Override
    public void addDocument(Document document) {
    	documentRepository.save(document);
    }

    @Override
    public void deleteDocument(int id) {
    	documentRepository.deleteById(id);
    }

	@Override
	public void uploadDocuments(MultipartFile[] files) {
		try {
			for (MultipartFile file : files) {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(file.getOriginalFilename());
				Files.write(path, bytes);
			}


		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
