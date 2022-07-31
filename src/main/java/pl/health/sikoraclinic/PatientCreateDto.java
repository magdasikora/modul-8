package pl.health.sikoraclinic;

import lombok.Data;

@Data

public class PatientCreateDto {
    public String name;
    public String surname;
    public String pesel;
    public String phoneNumber;
    public String comment;


}
