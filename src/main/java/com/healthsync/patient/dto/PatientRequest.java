package com.healthsync.patient.dto;

public record PatientRequest(String patientId,String name, int age,String gender, String contactNum,String address,String email,String medicalHistory,String prescriptions, String labResults) {
}