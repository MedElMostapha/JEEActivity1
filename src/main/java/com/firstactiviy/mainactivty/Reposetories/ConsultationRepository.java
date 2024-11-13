package com.firstactiviy.mainactivty.Reposetories;

import com.firstactiviy.mainactivty.Models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {
}