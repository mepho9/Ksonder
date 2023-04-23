package com.mepho.ksonder.models.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Person {

    private String firstName;
    private String lastName;

    //TODO -> From String to an Enum
    private String Sexe;

    private LocalDate birthDate;
    private LocalDate entryDate;
}
