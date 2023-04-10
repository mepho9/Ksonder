package com.mepho.ksonder.models.dtos;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerDto {

    private Long id;
    private String firstName;
    private String lastName;

    private String email;
}
