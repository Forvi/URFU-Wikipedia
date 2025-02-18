package com.example.WikiUrfu.controllers;


import com.example.WikiUrfu.DTOs.CreateInstituteRequestDto;
import com.example.WikiUrfu.entity.InstitutesEntity;
import com.example.WikiUrfu.services.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/institutes")
public class InstituteController {
    private InstituteService instituteService;

    @Autowired
    public InstituteController(InstituteService instituteService) {
        this.instituteService = instituteService;
    }

    @PostMapping
    public ResponseEntity<?> createInstitute (@RequestBody CreateInstituteRequestDto request) {
        try {
            InstitutesEntity institute = instituteService.createInstitute(request.getName(), request.getDescription());
            return ResponseEntity.ok(institute);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllInstitutes() {
        try {
            var institutes = instituteService.getAllInstitutes();
            return ResponseEntity.ok(institutes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstituteById(@PathVariable UUID institute_id)throws Exception {
        try {
            instituteService.deleteInstituteById(institute_id);
            return ResponseEntity.ok("Институт был успешно удалён");
        } catch(Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
