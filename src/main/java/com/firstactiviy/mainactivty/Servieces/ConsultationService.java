package com.firstactiviy.mainactivty.Servieces;

import com.firstactiviy.mainactivty.Models.Consultation;
import com.firstactiviy.mainactivty.Reposetories.ConsultationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    public Optional<Consultation> getConsultationById(Integer id) {
        return consultationRepository.findById(id);
    }

    public Consultation createConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public Consultation updateConsultation(Integer id, Consultation consultationDetails) {
        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consultation not found with id " + id));
        consultation.setPatient(consultationDetails.getPatient());
        consultation.setDocteur(consultationDetails.getDocteur());
        consultation.setMotif(consultationDetails.getMotif());
        return consultationRepository.save(consultation);
    }

    public void deleteConsultation(Integer id) {
        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consultation not found with id " + id));
        consultationRepository.delete(consultation);
    }
}