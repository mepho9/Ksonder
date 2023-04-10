package com.mepho.ksonder.repositories;

import com.mepho.ksonder.models.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player,Long> {

    Optional<Player> findByEmail(String email);
    //Optional<Player> findByTokenResetPassword(String token);
}
