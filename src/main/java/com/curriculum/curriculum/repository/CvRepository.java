package com.curriculum.curriculum.repository;

import java.util.UUID;

import com.curriculum.curriculum.model.Cv;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepository extends JpaRepository<Cv, UUID> {
    Cv findByNome(String nome) throws DataAccessException;
}