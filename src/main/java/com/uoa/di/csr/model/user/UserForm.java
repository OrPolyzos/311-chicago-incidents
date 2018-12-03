package com.uoa.di.csr.model.user;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.uoa.di.csr.model.validation.RegexPatterns.*;

public class UserForm {

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    @Size(min = 6, max = 16, message = BETWEEN_6_16_MESSAGE)
    @Pattern(regexp = REGEX_START + ALPHANUMERICAL + REGEX_END + "{6,16}", message = ALPHANUMERICAL_MESSAGE)
    private String username;

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    @Size(min = 6, max = 16, message = BETWEEN_6_16_MESSAGE)
    @Pattern(regexp = REGEX_START + ALPHANUMERICAL + PASSWORD_SYMBOLS + REGEX_END + "{6,16}", message = PASSWORD_MESSAGE)
    private String password;

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    @Size(min = 1, max = 128, message = BETWEEN_1_128_MESSAGE)
    @Pattern(regexp = REGEX_START + ENG_ALPHABET_LOWER_CASE + ENG_ALPHABET_UPPER_CASE + REGEX_END + "{1,128}", message = ENG_ALPHABET_MESSAGE)
    private String firstName, lastName;

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    @Pattern(regexp = ROLES_REGEX, message = CAN_BE_ONE_OF_THE_AVAILABLE_CHOICES)
    private String role;

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    @Email(message = EMAIL_ADDRESS_MESSAGE)
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
