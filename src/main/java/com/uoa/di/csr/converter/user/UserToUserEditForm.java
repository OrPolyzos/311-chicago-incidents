package com.uoa.di.csr.converter.user;

import com.uoa.di.csr.domain.User;
import com.uoa.di.csr.model.user.UserEditForm;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserToUserEditForm implements Function<User, UserEditForm> {

    @Override
    public UserEditForm apply(User user) {
        UserEditForm userEditForm = new UserEditForm();
        userEditForm.setId(user.getId());
        userEditForm.setUsername(user.getUsername());
        userEditForm.setPassword(user.getPassword());
        userEditForm.setEmail(user.getEmail());
        userEditForm.setFirstName(user.getFirstName());
        userEditForm.setLastName(user.getLastName());
        userEditForm.setRole(user.getRole());
        return userEditForm;
    }

}
