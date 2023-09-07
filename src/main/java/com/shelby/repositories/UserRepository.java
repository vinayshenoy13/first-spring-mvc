package com.shelby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shelby.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
