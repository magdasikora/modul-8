package pl.health.sikoraclinic;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clinic")
@RequiredArgsConstructor

public class ClinicController {

    private final ClinicService clinicService;


    @PostMapping("/patients")
    public ResponseEntity<Void> addPatient (@RequestBody @Valid Patient patient ){
        this.clinicService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/patients/{pesel}")
    public ResponseEntity<Void> deletePatient(@PathVariable String pesel){
        this.clinicService.deletePatient(pesel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/patients/{pesel}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String pesel, @RequestBody Patient patient){
        this.clinicService.updatePatient(pesel,patient);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getPatients(){
        List<Patient> patients= this.clinicService.getPatients();
        return ResponseEntity.status(HttpStatus.OK).body(patients);
    }
}
