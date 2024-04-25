package com.salesync.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesync.users.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

}
