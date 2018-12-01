package com.uoa.di.csr.repository;


import com.uoa.di.csr.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    Optional<User> findByUsernameAndPassword(String username, String password);

    List<User> findAllByRole(String userRole);

    long count();
}
