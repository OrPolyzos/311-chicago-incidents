package com.uoa.di.csr.model.user;

import javax.validation.constraints.NotNull;

import static com.uoa.di.csr.model.validation.RegexPatterns.CANNOT_BE_EMPTY_MESSAGE;

public class UserEditForm extends UserForm {

    @NotNull(message = CANNOT_BE_EMPTY_MESSAGE)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
