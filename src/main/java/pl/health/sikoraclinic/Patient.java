package pl.health.sikoraclinic;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @Length(min = 11, max=11)
    public String pesel;
    @Column
    @NotEmpty
    public String name;
    @NotEmpty
    public String surname;
    @Length(min = 9, max=9)
    public String phoneNumber;
    public String comment;


}
