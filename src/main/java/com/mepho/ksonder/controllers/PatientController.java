package com.mepho.ksonder.controllers;


import com.mepho.ksonder.models.dtos.PatientDto;
import com.mepho.ksonder.models.forms.PatientForm;
import com.mepho.ksonder.services.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;


    public PatientController(PatientService PatientService) {
        this.patientService = PatientService;
    }

    @PostMapping("/insert")
    public PatientDto insert(@RequestBody PatientForm form){
        return patientService.create(form);
    }

    @GetMapping("/getById")
    public PatientDto getById(@RequestParam Long id){
        return this.patientService.getById(id);
    }
    /*
    @GetMapping("/getByEmail")
    public PatientDto getByEmail(@RequestParam String email){
        return this.PatientService.getByEmail(email);
    }
     */

    @GetMapping("/getAll")
    public List<PatientDto> getAll(){
        return this.patientService.getAll();
    }

    @PatchMapping("/update")
    public PatientDto update(@RequestBody PatientForm form){
        return this.patientService.update(form);
    }

    @DeleteMapping("/deleteById")
    public PatientDto deleteById(@RequestParam Long id){
        return this.patientService.deleteById(id);
    }

    /*
    @DeleteMapping("/deleteByEmail")
    public PatientDto deleteByEmail(@RequestParam String email){
        return this.PatientService.deleteByEmail(email);
    }
     */
}
