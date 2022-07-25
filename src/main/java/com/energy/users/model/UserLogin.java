package com.energy.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin {
    @NotNull
    @Email(message = "Email is invalid.")
    private String email;

    @NotNull
    private String password;

    private String socialMediaId;
}
