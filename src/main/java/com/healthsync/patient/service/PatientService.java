package com.healthsync.patient.service;

import com.healthsync.patient.dto.PatientRequest;
import com.healthsync.patient.model.Patient;
import com.healthsync.patient.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private static final Logger log = LoggerFactory.getLogger(PatientService.class);

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

//    public Patient createPatient(PatientRequest patientRequest) {
//        Patient patient = new Patient();
//        patient.setName(patientRequest.name());
//        patient.setAge(patientRequest.age());
//        patient.setGender(patientRequest.gender());
//        patient.setContactNum(patientRequest.contactNum());
//        patient.setAddress(patientRequest.address());
//        patient.setEmail(patientRequest.email());
//        patient.setMedicalHistory(patientRequest.medicalHistory());
//        patient.setPrescriptions(patientRequest.prescriptions());
//        patient.setLabResults(patientRequest.labResults());
//
//        patientRepository.save(patient);
//        log.info("Patient Created Successfully");
//        return patient;
//    }

    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientById(String patientId){
        return patientRepository.findById(patientId);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }


    public Patient updatePatient(String id, PatientRequest patientRequest) {
        return patientRepository.findById(id)
                .map(patient -> {
                    patient.setName(patientRequest.name());
                    patient.setAge(patientRequest.age());
                    patient.setGender(patientRequest.gender());
                    patient.setContactNum(patientRequest.contactNum());
                    patient.setAddress(patientRequest.address());
                    patient.setEmail(patientRequest.email());
                    patient.setMedicalHistory(patientRequest.medicalHistory());
                    patient.setPrescriptions(patientRequest.prescriptions());
                    patient.setLabResults(patientRequest.labResults());
                    return patientRepository.save(patient);
                })
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public void deletePatient(String id){
        patientRepository.deleteById(id);
    }
}
