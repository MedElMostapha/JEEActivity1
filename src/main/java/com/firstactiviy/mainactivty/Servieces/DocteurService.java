package com.firstactiviy.mainactivty.Servieces;

import com.firstactiviy.mainactivty.Models.Docteur;
import com.firstactiviy.mainactivty.Reposetories.DocteurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocteurService {

    @Autowired
    private DocteurRepository docteurRepository;

    public List<Docteur> getAllDocteurs() {
        return docteurRepository.findAll();
    }

    public Optional<Docteur> getDocteurById(Integer id) {
        return docteurRepository.findById(id);
    }

    public Docteur createDocteur(Docteur docteur) {
        return docteurRepository.save(docteur);
    }

    public Docteur updateDocteur(Integer id, Docteur docteurDetails) {
        Docteur docteur = docteurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Docteur not found with id " + id));
        docteur.setNom(docteurDetails.getNom());
        docteur.setPrenom(docteurDetails.getPrenom());
        docteur.setTel(docteurDetails.getTel());
        docteur.setAge(docteurDetails.getAge());
        docteur.setGenre(docteurDetails.getGenre());
        docteur.setSpecialite(docteurDetails.getSpecialite());
        return docteurRepository.save(docteur);
    }

    public void deleteDocteur(Integer id) {
        Docteur docteur = docteurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Docteur not found with id " + id));
        docteurRepository.delete(docteur);
    }
}
