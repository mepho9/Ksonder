package com.mepho.ksonder.services;

import com.mepho.ksonder.mappers.PatientMapper;
import com.mepho.ksonder.models.dtos.PatientDto;
import com.mepho.ksonder.models.entities.Patient;
import com.mepho.ksonder.models.forms.PatientForm;
import com.mepho.ksonder.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;


@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;


    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public PatientDto create(PatientForm form){
        if(form == null){
            throw new IllegalArgumentException("Player Form cannot be null");
        }
        if(patientRepository.findByEmail(form.getEmail()).isPresent()){
            throw new EntityExistsException("Email adress : {"+form.getEmail()+"} is already used");
        }

        Patient patient = patientMapper.formToEntity(form);
        patient = patientRepository.save(patient);

        return patientMapper.entityToDto(patient);
    }

    public PatientDto getById(Long id){
        return patientMapper
                .entityToDto(this.patientRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Patient with that Id doesn't exist")));
    }

    public PatientDto getByEmail(String email){
        return patientMapper
                .entityToDto(patientRepository
                        .findByEmail(email)
                        .orElseThrow(() -> new RuntimeException("Patient with that Email doesn't exist")));
    }


    public List<PatientDto> getAll(){
        return this.patientRepository.findAll()
                .stream()
                .map(patientMapper::entityToDto)
                .toList();
    }

    public PatientDto update(PatientForm form){
        if( form == null){
            throw new IllegalArgumentException("Patient Form cannot be null");
        }

        Patient patient = patientRepository
                .findByEmail(form.getEmail())
                .orElseThrow(() -> new RuntimeException("to Update account with that Email doesn't exist"));

        if(form.getFirstName() != null ) { patient.setFirstName(form.getFirstName());}
        if(form.getLastName() != null ) { patient.setLastName(form.getLastName());}
        if(form.getEmail() != null){ patient.setEmail(form.getEmail());}

        return patientMapper.entityToDto(patientRepository.save(patient));
    }

    public PatientDto deleteById(Long id){
        Patient patient =
                patientRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Patient with ID : {"+id+"} can't be delete because doesn't exist"));

        this.patientRepository.delete(patient);
        patient.setId(null);

        return patientMapper.entityToDto(patient);
    }

    public PatientDto deleteByEmail(String email){
        Patient patient =
                patientRepository
                        .findByEmail(email)
                        .orElseThrow(() -> new RuntimeException("Patient with Email : {"+email+"} can't be delete because doesn't exist"));

        this.patientRepository.delete(patient);
        patient.setId(null);

        return patientMapper.entityToDto(patient);
    }

}
