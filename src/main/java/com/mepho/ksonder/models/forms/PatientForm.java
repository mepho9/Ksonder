package com.mepho.ksonder.models.forms;


import com.sun.istack.NotNull;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatientForm {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String bloodType;

    @NotNull
    private String contactPersonNumber;
}
