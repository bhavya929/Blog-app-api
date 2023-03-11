package com.example.Blogappapi.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class Userdt {
    private int id;
    @NotEmpty
    @Size(min = 4,message = "username must be min 4 length")
    private String name;
    @Email
    private String email;
    @NotEmpty
    @Size(min=8,message = "Password should be min 8 character")
    private String password;
    @NotEmpty
    private String about;
}
