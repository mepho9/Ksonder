package com.mepho.ksonder.mappers;


import com.mepho.ksonder.models.dtos.CareGiverDto;
import com.mepho.ksonder.models.dtos.PatientDto;
import com.mepho.ksonder.models.entities.CareGiver;
import com.mepho.ksonder.models.entities.Patient;
import com.mepho.ksonder.models.forms.CareGiverForm;
import com.mepho.ksonder.models.forms.PatientForm;
import org.springframework.stereotype.Service;

@Service
public class CareGiverMapper {

    public CareGiverMapper(){

    }

    public CareGiver formToEntity(CareGiverForm form){
        CareGiver careGiver = new CareGiver();
        careGiver.setFirstName(form.getFirstName());
        careGiver.setLastName(form.getLastName());
        careGiver.setCredentials(form.getCredentials());
        careGiver.setPassword(form.getPassword());
        careGiver.setPhoneNumber(form.getPhoneNumber());

        return careGiver;
    }

    public CareGiverDto entityToDto(CareGiver entity){
        CareGiverDto dto = new CareGiverDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setCredentials(entity.getCredentials());
        dto.setPassword(entity.getPassword());
        dto.setPhoneNumber(entity.getPhoneNumber());

        return dto;
    }


}
