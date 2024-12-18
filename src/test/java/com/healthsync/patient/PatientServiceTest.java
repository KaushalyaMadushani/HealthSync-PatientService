//package com.healthsync.patient;
//
//import com.healthsync.patient.dto.PatientRequest;
//import com.healthsync.patient.model.Patient;
//import com.healthsync.patient.repository.PatientRepository;
//import com.healthsync.patient.service.PatientService;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//public class PatientServiceTest {
//    @Mock
//    private PatientRepository patientRepository;
//
//    @InjectMocks
//    private PatientService patientService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testCreatePatient() {
//        PatientRequest request = new PatientRequest(
//                "",
//                "John Doe",
//                30,
//                "Male",
//                "1234567890",
//                "123 Main St",
//                "johndoe@example.com",
//                "No known allergies, previous knee surgery",
//                "Aspirin 100mg, Paracetamol 500mg",
//                "Normal"
//        );
//
//        Patient patient = Patient.builder()
//                .name("John Doe")
//                .age(30)
//                .gender("Male")
//                .contactNum("1234567890")
//                .address("123 Main St")
//                .email("johndoe@example.com")
//                .medicalHistory("None")
//                .prescriptions("None")
//                .labResults("Normal")
//                .build();
//
//        when(patientRepository.save(any(Patient.class))).thenReturn(patient);
//
//        Patient createdPatient = patientService.createPatient(patient);
//
//        assertNotNull(createdPatient);
//        assertEquals("John Doe", createdPatient.getName());
//        verify(patientRepository, times(1)).save(any(Patient.class));
//    }
//
//    @Test
//    public void testGetPatientById() {
//        Patient patient = Patient.builder()
//                .patientId("1")
//                .name("John Doe")
//                .build();
//
//        when(patientRepository.findById("1")).thenReturn(Optional.of(patient));
//
//        Optional<Patient> foundPatient = patientService.getPatientById("1");
//
//        assertTrue(foundPatient.isPresent());
//        assertEquals("John Doe", foundPatient.get().getName());
//        verify(patientRepository, times(1)).findById("1");
//    }
//
//    @Test
//    public void testGetAllPatients() {
//        Patient patient1 = Patient.builder().name("John Doe").build();
//        Patient patient2 = Patient.builder().name("Jane Doe").build();
//        List<Patient> patients = Arrays.asList(patient1, patient2);
//
//        when(patientRepository.findAll()).thenReturn(patients);
//
//        List<Patient> allPatients = patientService.getAllPatients();
//
//        assertEquals(2, allPatients.size());
//        verify(patientRepository, times(1)).findAll();
//    }
//
//    @Test
//    public void testUpdatePatient() {
//        Patient existingPatient = Patient.builder()
//                .patientId("1")
//                .name("John Doe")
//                .build();
//
//        PatientRequest updateRequest = new PatientRequest(
//                "1",
//                "Johnny Doe",
//                31,
//                "Male",
//                "9876543210",
//                "456 Another St",
//                "johnny@example.com",
//                "Updated History",
//                "Updated Prescriptions",
//                "Updated Results"
//        );
//
//        when(patientRepository.findById("1")).thenReturn(Optional.of(existingPatient));
//        when(patientRepository.save(any(Patient.class))).thenAnswer(invocation -> invocation.getArgument(0));
//
//        Patient updatedPatient = patientService.updatePatient("1", updateRequest);
//
//        assertNotNull(updatedPatient);
//        assertEquals("Johnny Doe", updatedPatient.getName());
//        assertEquals(31, updatedPatient.getAge());
//        verify(patientRepository, times(1)).save(existingPatient);
//    }
//
//    @Test
//    public void testDeletePatient() {
//        doNothing().when(patientRepository).deleteById("1");
//
//        patientService.deletePatient("1");
//
//        verify(patientRepository, times(1)).deleteById("1");
//    }
//
////    @Test
////    public void testGetPatientById_NotFound() {
////        when(patientRepository.findById("1")).thenReturn(Optional.empty());
////
////        Exception exception = assertThrows(
////                RuntimeException.class,
////                () -> patientService.getPatientById("1")
////        );
////
////        assertEquals("Patient not found with id 1", exception.getMessage());
////        verify(patientRepository, times(1)).findById("1");
////   }
//
//}
