package com.mepho.ksonder.models.forms;


import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CareGiverForm {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @NotNull
    private String credentials;

    @NotNull
    private String password;

    @NotNull
    private String phoneNumber;
}
