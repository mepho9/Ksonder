package com.mepho.ksonder.controllers;


import com.mepho.ksonder.models.dtos.CareGiverDto;
import com.mepho.ksonder.models.dtos.PatientDto;
import com.mepho.ksonder.models.forms.CareGiverForm;
import com.mepho.ksonder.models.forms.PatientForm;
import com.mepho.ksonder.services.CareGiverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/careGiver")
public class CareGiverController {

    private final CareGiverService careGiverService;

    public CareGiverController(CareGiverService careGiverService) {
        this.careGiverService = careGiverService;
    }

    @PostMapping("/insert")
    public CareGiverDto insert(@RequestBody CareGiverForm form){
        return careGiverService.create(form);
    }

    @GetMapping("/getById")
    public CareGiverDto getById(@RequestParam Long id){
        return this.careGiverService.getById(id);
    }


    @GetMapping("/getAll")
    public List<CareGiverDto> getAll(){
        return this.careGiverService.getAll();
    }

    @PatchMapping("/update")
    public CareGiverDto update(@RequestBody CareGiverForm form){
        return this.careGiverService.update(form);
    }

    @DeleteMapping("/deleteById")
    public CareGiverDto deleteById(@RequestParam Long id){
        return this.careGiverService.deleteById(id);
    }



}
