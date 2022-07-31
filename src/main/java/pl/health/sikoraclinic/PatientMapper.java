package pl.health.sikoraclinic;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient map(PatientCreateDto dto);
}
