package com.mepho.ksonder.models.dtos;

import com.sun.istack.NotNull;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatientDto {

    private Long id;
    private String firstName;
    private String lastName;

    private String email;

    private String bloodType;

    private String contactPersonNumber;
}
