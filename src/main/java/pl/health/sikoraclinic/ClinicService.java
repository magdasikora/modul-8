package pl.health.sikoraclinic;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor

public class ClinicService {
    private final Map<String, Patient> patients;
    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;




    public void addPatient (Patient patient){
    this.patients.put(patient.getPesel(), patient);
    patientRepository.save(patient);

}

public void deletePatient (String pesel){
   this.patients.remove(pesel);
   patientRepository.deleteById(pesel);

}

public void updatePatient (String pesel, Patient patient){
     this.patients.put(pesel, patient);
     if(patientRepository.existsById(pesel)){
         Patient updatedPatient= patientRepository.findById(pesel).get();
         updatedPatient.setPesel(patient.getPesel());
         updatedPatient.setName(patient.getName());
         updatedPatient.setSurname(patient.getSurname());
         updatedPatient.setPhoneNumber(patient.getPhoneNumber());
         updatedPatient.setComment(patient.getComment());
         patientRepository.save(updatedPatient);
     }

   }


public List<Patient> getPatients(){
   List<Patient> patientList= new ArrayList<>();
   for(String pesel: this.patients.keySet()){
       patientList.add(this.patients.get(pesel));
   }
return patientList;
   }

   public List<Patient> getAllPatients(){
       return patientRepository.findAll();
   }
}

