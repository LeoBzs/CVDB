package com.curriculum.curriculum.service;

import java.util.Optional;
import java.util.UUID;

import com.curriculum.curriculum.model.Cv;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public interface CvService {

    Cv findById(UUID id) throws DataAccessException;
    Cv findByNome(String senha) throws DataAccessException;
    Cv saveCv(Cv cv) throws DataAccessException;
    void deleteCv(UUID id) throws DataAccessException;
    Iterable<Cv> findAll() throws DataAccessException;
    Optional<Cv> changeCv(Cv cv, UUID id) throws DataAccessException;
}