package com.mepho.ksonder.services;

import com.mepho.ksonder.mappers.PlayerMapper;
import com.mepho.ksonder.models.dtos.PlayerDto;
import com.mepho.ksonder.models.entities.Player;
import com.mepho.ksonder.models.forms.PlayerForm;
import com.mepho.ksonder.repositories.PlayerRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.lang.reflect.Member;
import java.util.List;


@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;


    public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public PlayerDto create(PlayerForm form){
        if(form == null){
            throw new IllegalArgumentException("Player Form cannot be null");
        }
        if(playerRepository.findByEmail(form.getEmail()).isPresent()){
            throw new EntityExistsException("Email adress : {"+form.getEmail()+"} is already used");
        }

        Player player = playerMapper.formToEntity(form);
        player = playerRepository.save(player);

        return playerMapper.entityToDto(player);
    }

    public PlayerDto getPlayerById(Long id){
        return playerMapper
                .entityToDto(this.playerRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Player with that Id doesn't exist")));
    }

    public PlayerDto getPlayerByEmail(String email){
        return playerMapper
                .entityToDto(playerRepository
                        .findByEmail(email)
                        .orElseThrow(() -> new RuntimeException("Player with that Email doesn't exist")));
    }


    public List<PlayerDto> getPlayers(){
        return this.playerRepository.findAll()
                .stream()
                .map(playerMapper::entityToDto)
                .toList();
    }

    public PlayerDto update(PlayerForm form){
        if( form == null){
            throw new IllegalArgumentException("Player Form cannot be null");
        }

        Player player = playerRepository
                .findByEmail(form.getEmail())
                .orElseThrow(() -> new RuntimeException("to Update account with that Email doesn't exist"));

        if(form.getFirstName() != null ) { player.setFirstName(form.getFirstName());}
        if(form.getLastName() != null ) { player.setLastName(form.getLastName());}
        if(form.getEmail() != null){ player.setEmail(form.getEmail());}

        return playerMapper.entityToDto(playerRepository.save(player));
    }

    public PlayerDto deleteById(Long id){
        Player player =
                playerRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Player with ID : {"+id+"} can't be delete because doesn't exist"));

        this.playerRepository.delete(player);
        player.setId(null);

        return playerMapper.entityToDto(player);
    }

    public PlayerDto deleteByEmail(String email){
        Player player =
                playerRepository
                        .findByEmail(email)
                        .orElseThrow(() -> new RuntimeException("Player with Email : {"+email+"} can't be delete because doesn't exist"));

        this.playerRepository.delete(player);
        player.setId(null);

        return playerMapper.entityToDto(player);
    }

}
