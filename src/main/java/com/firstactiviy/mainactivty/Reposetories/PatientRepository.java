package com.firstactiviy.mainactivty.Reposetories;

import com.firstactiviy.mainactivty.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}