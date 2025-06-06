package com.example.WikiUrfu.controllers;


import com.example.WikiUrfu.DTOs.CreateInstituteRequestDto;
import com.example.WikiUrfu.entity.InstituteEntity;
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
            InstituteEntity institute = instituteService.createInstitute(request.getName(), request.getDescription());
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

    @GetMapping("/{institute_id}")
    public ResponseEntity<?> getInstituteById(@PathVariable UUID institute_id) throws Exception {
        try {
            var institute = instituteService.getInstituteById(institute_id);
            return ResponseEntity.ok().body(institute);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @DeleteMapping("/{institute_id}")
    public ResponseEntity<?> deleteInstituteById(@PathVariable("institute_id") UUID institute_id) throws Exception {
        try {
            instituteService.deleteInstituteById(institute_id);
            System.out.println(institute_id);
            return ResponseEntity.ok("Институт был успешно удалён");
        } catch(Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
