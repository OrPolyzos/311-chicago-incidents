package com.uoa.di.csr.converter.user;

import com.uoa.di.csr.domain.User;
import com.uoa.di.csr.model.user.UserForm;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class UserFormToUser implements Function<UserForm, User> {

    @Override
    public User apply(UserForm userForm) {
        User userToCreate = new User();
        userToCreate.setUsername(userForm.getUsername());
        userToCreate.setPassword(userForm.getPassword());
        userToCreate.setFirstName(userForm.getFirstName());
        userToCreate.setLastName(userForm.getLastName());
        userToCreate.setRole(userForm.getRole());
        userToCreate.setEmail(userForm.getEmail());
        return userToCreate;
    }
}
