package com.mepho.ksonder.models.forms;


import com.sun.istack.NotNull;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerForm {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @NotNull
    private String email;
}
