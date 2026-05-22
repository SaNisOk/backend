package com.example.documents.controller;

import com.example.documents.model.Document;
import com.example.documents.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * REST-контроллер документов. Базовый путь: /api/documents.
 */
@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public Document create(@RequestBody Document document) {
        return documentService.create(document);
    }

    @PutMapping("/{id}")
    public Document update(@PathVariable Long id, @RequestBody Document document) {
        return documentService.update(id, document);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        documentService.delete(id);
    }

    @GetMapping("/user/{username}")
    public List<Document> getByUsername(@PathVariable String username) {
        return documentService.getByUsername(username);
    }

    @GetMapping("/user/{username}/signed")
    public List<Document> getSignedByUsername(@PathVariable String username) {
        return documentService.getSignedByUsername(username);
    }

    @GetMapping("/user/{username}/unsigned")
    public List<Document> getUnsignedByUsername(@PathVariable String username) {
        return documentService.getUnsignedByUsername(username);
    }

    @GetMapping("/range")
    public List<Document> getByDateRange(@RequestParam LocalDateTime from,
                                         @RequestParam LocalDateTime to) {
        return documentService.getByDateRange(from, to);
    }
}
