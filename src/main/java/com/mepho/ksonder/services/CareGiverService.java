package com.mepho.ksonder.services;

import com.mepho.ksonder.mappers.CareGiverMapper;
import com.mepho.ksonder.models.dtos.CareGiverDto;
import com.mepho.ksonder.models.dtos.PatientDto;
import com.mepho.ksonder.models.entities.CareGiver;
import com.mepho.ksonder.models.entities.Patient;
import com.mepho.ksonder.models.forms.CareGiverForm;
import com.mepho.ksonder.models.forms.PatientForm;
import com.mepho.ksonder.repositories.CareGiverRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class CareGiverService {

    private final CareGiverRepository careGiverRepository;

    private final CareGiverMapper careGiverMapper;

    public CareGiverService(CareGiverRepository careGiverRepository, CareGiverMapper careGiverMapper) {
        this.careGiverRepository = careGiverRepository;
        this.careGiverMapper = careGiverMapper;
    }

    public CareGiverDto create(CareGiverForm form){
        if(form == null){
            throw new IllegalArgumentException("Player Form cannot be null");
        }

        CareGiver careGiver = careGiverMapper.formToEntity(form);
        careGiver = careGiverRepository.save(careGiver);

        return careGiverMapper.entityToDto(careGiver);
    }

    public CareGiverDto getById(Long id){
        return careGiverMapper
                .entityToDto(this.careGiverRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("CareGiver with that Id doesn't exist")));
    }

    public List<CareGiverDto> getAll(){
        return this.careGiverRepository.findAll()
                .stream()
                .map(careGiverMapper::entityToDto)
                .toList();
    }


    public CareGiverDto update(CareGiverForm form){
        if( form == null){
            throw new IllegalArgumentException("Patient Form cannot be null");
        }

        CareGiver careGiver = careGiverMapper.formToEntity(form);

        if(form.getFirstName() != null ) { careGiver.setFirstName(form.getFirstName());}
        if(form.getLastName() != null ) { careGiver.setLastName(form.getLastName());}

        if(form.getCredentials()!=null) {careGiver.setCredentials(form.getCredentials());}
        if(form.getPassword()!=null) {careGiver.setPassword(form.getPassword());}

        if (form.getPhoneNumber()!=null){careGiver.setPhoneNumber(form.getPhoneNumber());}

        return careGiverMapper.entityToDto(careGiverRepository.save(careGiver));

        }


    public CareGiverDto deleteById(Long id){
        CareGiver careGiver =
                careGiverRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("CareGiver with ID : {"+id+"} can't be delete because doesn't exist"));

        this.careGiverRepository.delete(careGiver);
        careGiver.setId(null);

        return careGiverMapper.entityToDto(careGiver);
    }





}
