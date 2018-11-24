package com.uoa.di.csr.service;

import com.uoa.di.csr.domain.User;
import com.uoa.di.csr.exception.InvalidCredentialsException;
import com.uoa.di.csr.exception.user.UserNotFoundException;
import com.uoa.di.csr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<User> findAllUsersWithRole(String userRole) {
        return userRepository.findAllByRole(userRole);
    }

    public Long count() {
        return userRepository.count();
    }

    public User findUserWithId(Long userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElseThrow(() -> new UserNotFoundException(userId));
    }

    public User login(String username, String password) throws InvalidCredentialsException {
        Optional<User> userOptional = userRepository.findByUsernameAndPassword(username, password);
        return userOptional.orElseThrow(InvalidCredentialsException::new);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User userToEdit) throws UserNotFoundException {
        User retrievedUser = findUserWithId(userToEdit.getId());
        return saveUser(userToEdit);
    }

    public void deleteUserById(Long userId) throws UserNotFoundException {
        User retrievedUser = findUserWithId(userId);
        userRepository.delete(retrievedUser);
    }
}
