package com.firstactiviy.mainactivty.Reposetories;

import com.firstactiviy.mainactivty.Models.Docteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocteurRepository extends JpaRepository<Docteur, Integer> {
}