package com.healthsync.patient.dto;

import java.util.List;

public record PatientRequest(String patientId, String name, int age, String gender, String contactNum, String address, String email,
                             List<String> medicalHistory, List<String> prescriptions, List<String> labResults) {
}