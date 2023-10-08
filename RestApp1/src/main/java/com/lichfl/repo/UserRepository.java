package com.lichfl.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lichfl.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
