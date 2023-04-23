package com.mepho.ksonder.mappers;

import com.mepho.ksonder.models.dtos.PatientDto;
import com.mepho.ksonder.models.entities.Patient;
import com.mepho.ksonder.models.forms.PatientForm;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    public PatientMapper(){
    }

    public Patient formToEntity(PatientForm form){
        Patient patient = new Patient();
        patient.setFirstName(form.getFirstName());
        patient.setLastName(form.getLastName());
        patient.setEmail(form.getEmail());
        patient.setBloodType(form.getBloodType());
        patient.setContactPersonNumber(form.getContactPersonNumber());

        return patient;
    }

    public PatientDto entityToDto(Patient entity){
        PatientDto dto = new PatientDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setBloodType(entity.getBloodType());
        dto.setContactPersonNumber(entity.getContactPersonNumber());

        return dto;
    }
}
