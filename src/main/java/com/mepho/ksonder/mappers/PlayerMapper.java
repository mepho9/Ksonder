package com.mepho.ksonder.mappers;

import com.mepho.ksonder.models.dtos.PlayerDto;
import com.mepho.ksonder.models.entities.Player;
import com.mepho.ksonder.models.forms.PlayerForm;
import org.springframework.stereotype.Service;

@Service
public class PlayerMapper {

    public PlayerMapper(){
    }

    public Player formToEntity(PlayerForm form){
        Player player = new Player();
        player.setFirstName(form.getFirstName());
        player.setLastName(form.getLastName());
        player.setEmail(form.getEmail());

        return player;
    }

    public PlayerDto entityToDto(Player entity){
        PlayerDto dto = new PlayerDto();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());

        return dto;
    }
}
