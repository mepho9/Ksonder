package com.mepho.ksonder.controllers;


import com.mepho.ksonder.models.dtos.PlayerDto;
import com.mepho.ksonder.models.forms.PlayerForm;
import com.mepho.ksonder.services.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService playerService;


    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/createPlayer")
    public PlayerDto createPlayer(@RequestBody PlayerForm form){
        return playerService.create(form);
    }

    @GetMapping("/getPlayerById")
    public PlayerDto getById(@RequestParam Long id){
        return this.playerService.getPlayerById(id);
    }

    @GetMapping("/getPlayerByEmail")
    public PlayerDto getByEmail(@RequestParam String email){
        return this.playerService.getPlayerByEmail(email);
    }

    @GetMapping("/getPlayers")
    public List<PlayerDto> getAll(){
        return this.playerService.getPlayers();
    }

    @PatchMapping("/updatePlayer")
    public PlayerDto updatePlayer(@RequestBody PlayerForm form){
        return this.playerService.update(form);
    }

    @DeleteMapping("/deleteById")
    public PlayerDto deleteById(@RequestParam Long id){
        return this.playerService.deleteById(id);
    }

    @DeleteMapping("/deleteByEmail")
    public PlayerDto deleteByEmail(@RequestParam String email){
        return this.playerService.deleteByEmail(email);
    }
}
