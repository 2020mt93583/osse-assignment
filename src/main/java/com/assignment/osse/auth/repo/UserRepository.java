package com.assignment.osse.auth.repo;

import com.assignment.osse.auth.repo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    public User findUserByUsername(String userName);
}
