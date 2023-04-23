package com.mepho.ksonder.models.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CareGiverDto {
    private Long id;
    private String firstName;
    private String lastName;

    private String credentials;
    private String password;

    private String phoneNumber;
}
