package com.curriculum.curriculum.service;

import com.curriculum.curriculum.model.Cv;
import com.curriculum.curriculum.repository.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CvServiceImpl implements CvService{

    private final CvRepository cvRepository;

    @Autowired
    public CvServiceImpl(CvRepository cvRepository){
        this.cvRepository = cvRepository;
    }

    @Override
    public Cv findById(UUID id) throws DataAccessException {
        Optional<Cv> cv = this.cvRepository.findById(id);
        return cv.orElse(null);
    }

    @Override
    public Cv findByNome(String nome) throws DataAccessException {
        return cvRepository.findByNome(nome);
    }

    @Override
    public Cv saveCv(Cv cv) throws DataAccessException {
        return cvRepository.save(cv);
    }

    @Override
    public void deleteCv(UUID id) throws DataAccessException {
        cvRepository.deleteById(id);
    }

    @Override
    public Iterable<Cv> findAll() throws DataAccessException {
        return cvRepository.findAll();
    }

    @Override
    public Optional<Cv> changeCv(Cv newCv, UUID id) throws DataAccessException {
        return cvRepository.findById(id)
                .map(cv -> {
                    cv.setNome(newCv.getNome());
                    return cvRepository.save(newCv);
                });
    }
}
