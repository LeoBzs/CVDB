package com.curriculum.curriculum.controller;

import com.curriculum.curriculum.model.Cv;
import com.curriculum.curriculum.service.CvServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/cv")
public class CvController {

    private final CvServiceImpl cvService;

    @Autowired
    public CvController(CvServiceImpl cvService) {
        this.cvService = cvService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Cv> saveUsuario(@RequestBody Cv cv, BindingResult bindingResult) {

        Cv saveCv = cvService.saveCv(cv);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(cv, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(saveCv, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cv> findById(@PathVariable UUID id) {
        Optional<Cv> cv;
        cv = Optional.ofNullable(cvService.findById(id));
        if (cv.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cv.get(), HttpStatus.OK);
        //return new ResponseEntity<>(cvService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cv> deleteById(@PathVariable UUID id) {
        cvService.deleteCv(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Cv>> changeById(@RequestBody Cv newCv, @PathVariable UUID id) {
        return new ResponseEntity<>(cvService.changeCv(newCv, id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(cvService.findAll(), HttpStatus.OK);
    }

}
