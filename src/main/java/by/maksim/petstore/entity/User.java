package by.maksim.petstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    @NotEmpty
    @NotBlank
    private String username;
    @NotEmpty
    @NotBlank
    private String firstName;
    @NotEmpty
    @NotBlank
    private String lastName;
    @NotEmpty
    @NotBlank
    private String email;
    @NotEmpty
    @NotBlank
    private String password;
    @NotEmpty
    @NotBlank
    private String phone;
    private int userStatus;
}
