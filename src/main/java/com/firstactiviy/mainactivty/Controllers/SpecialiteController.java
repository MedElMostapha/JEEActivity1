package com.firstactiviy.mainactivty.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.firstactiviy.mainactivty.Models.Specialite;
import com.firstactiviy.mainactivty.Reposetories.SpecialiteRepository;
import com.firstactiviy.mainactivty.Servieces.SpecialiteService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/specialites")
public class SpecialiteController {

    @Autowired
    private SpecialiteService specialiteService;

    @GetMapping
    public ResponseEntity<List<Specialite>> getAllSpecialites() {
        List<Specialite> specialites = specialiteService.getSpecialites();
        return ResponseEntity.ok(specialites);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialite> getSpecialiteById(@PathVariable Integer id) {
        Optional<Specialite> specialite = specialiteService.getSpecialiteById(id);
        return specialite.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Specialite> createSpecialite(@RequestBody Specialite specialite) {
        Specialite createdSpecialite = specialiteService.createSpecialite(specialite);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSpecialite);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialite> updateSpecialite(
            @PathVariable Integer id,
            @RequestBody Specialite specialiteDetails) {
        try {
            Specialite updatedSpecialite = specialiteService.updateSpecialite(id, specialiteDetails);
            return ResponseEntity.ok(updatedSpecialite);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialite(@PathVariable Integer id) {
        specialiteService.deleteSpecialite(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
