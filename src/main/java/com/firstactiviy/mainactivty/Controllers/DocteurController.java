package com.firstactiviy.mainactivty.Controllers;

import com.firstactiviy.mainactivty.Models.Docteur;
import com.firstactiviy.mainactivty.Servieces.DocteurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docteurs")
public class DocteurController {

    @Autowired
    private DocteurService docteurService;

    @GetMapping
    public List<Docteur> getAllDocteurs() {
        return docteurService.getAllDocteurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docteur> getDocteurById(@PathVariable Integer id) {
        return docteurService.getDocteurById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Docteur createDocteur(@RequestBody Docteur docteur) {
        return docteurService.createDocteur(docteur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Docteur> updateDocteur(@PathVariable Integer id, @RequestBody Docteur docteurDetails) {
        return ResponseEntity.ok(docteurService.updateDocteur(id, docteurDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocteur(@PathVariable Integer id) {
        docteurService.deleteDocteur(id);
        return ResponseEntity.noContent().build();
    }
}