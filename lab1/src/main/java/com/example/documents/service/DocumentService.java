package com.example.documents.service;

import com.example.documents.model.Document;
import com.example.documents.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository repository;

    public DocumentService(DocumentRepository repository) {
        this.repository = repository;
    }

    public Document create(Document document) {
        return repository.save(document);
    }

    public Document update(Long id, Document newDocument) {
        Document document = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));

        if (newDocument.getTitle() != null) {
            document.setTitle(newDocument.getTitle());
        }
        if (newDocument.getType() != null) {
            document.setType(newDocument.getType());
        }
        if (newDocument.getBody() != null) {
            document.setBody(newDocument.getBody());
        }
        if (newDocument.getSignedAt() != null) {
            document.setSignedAt(newDocument.getSignedAt());
        }
        if (newDocument.getUsername() != null) {
            document.setUsername(newDocument.getUsername());
        }

        return repository.save(document);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Document> getByUsername(String username) {
        return repository.findByUsername(username);
    }

    public List<Document> getSignedByUsername(String username) {
        return repository.findByUsernameAndSignedAtIsNotNull(username);
    }

    public List<Document> getUnsignedByUsername(String username) {
        return repository.findByUsernameAndSignedAtIsNull(username);
    }

    public List<Document> getByDateRange(LocalDateTime from, LocalDateTime to) {
        return repository.findByCreatedAtBetween(from, to);
    }
}
