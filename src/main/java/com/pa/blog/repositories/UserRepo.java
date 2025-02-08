package com.pa.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pa.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
