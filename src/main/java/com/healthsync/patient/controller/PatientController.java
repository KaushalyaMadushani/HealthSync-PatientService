package com.healthsync.patient.controller;

import com.healthsync.patient.dto.PatientRequest;
import com.healthsync.patient.model.Patient;
import com.healthsync.patient.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
        return ResponseEntity.ok(patientService.createPatient(patient));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id){
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String id, @RequestBody PatientRequest patientRequest) {
        try {
            return ResponseEntity.ok(patientService.updatePatient(id, patientRequest));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable String id){
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
}
}


