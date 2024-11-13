package com.firstactiviy.mainactivty.Servieces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstactiviy.mainactivty.Models.Specialite;
import com.firstactiviy.mainactivty.Reposetories.SpecialiteRepository;

@Service
public class SpecialiteService {

    @Autowired
    private SpecialiteRepository specialiteRepository;

    public List<Specialite> getSpecialites() {
        return specialiteRepository.findAll();
    }

    public Specialite createSpecialite(Specialite specialite) {
        return specialiteRepository.save(specialite);
    }

    public Optional<Specialite> getSpecialiteById(Integer id) {
        return specialiteRepository.findById(id);
    }

    public Specialite updateSpecialite(Integer id, Specialite updatedSpecialite) {
        return specialiteRepository.findById(id)
                .map(specialite -> {
                    specialite.setNom(updatedSpecialite.getNom());
                    return specialiteRepository.save(specialite);
                })
                .orElseThrow(() -> new RuntimeException("pas de spacialité  " + id));
    }

    public void deleteSpecialite(Integer id) {
        specialiteRepository.deleteById(id);
    }
}
