package com.uoa.di.csr.converter.user;

import com.uoa.di.csr.domain.User;
import com.uoa.di.csr.model.user.UserEditForm;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserEditFormToUser implements Function<UserEditForm, User> {

    @Override
    public User apply(UserEditForm userEditForm) {
        User userToEdit = new User();
        userToEdit.setId(userEditForm.getId());
        userToEdit.setUsername(userEditForm.getUsername());
        userToEdit.setPassword(userEditForm.getPassword());
        userToEdit.setFirstName(userEditForm.getFirstName());
        userToEdit.setLastName(userEditForm.getLastName());
        userToEdit.setRole(userEditForm.getRole());
        userToEdit.setEmail(userEditForm.getEmail());
        return userToEdit;
    }
}
