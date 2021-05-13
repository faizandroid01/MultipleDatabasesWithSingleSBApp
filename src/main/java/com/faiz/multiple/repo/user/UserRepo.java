package com.faiz.multiple.repo.user;

import org.springframework.data.repository.CrudRepository;

import com.faiz.multiple.model.user.User;

public interface UserRepo extends CrudRepository<User, Integer> {

}
