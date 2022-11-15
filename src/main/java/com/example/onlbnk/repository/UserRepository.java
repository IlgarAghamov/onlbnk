package com.example.onlbnk.repository;

import com.example.onlbnk.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Long> {
   boolean existsByUserLogin(String login);

   @Override
   Optional<CustomUser> findById(Long aLong);
}