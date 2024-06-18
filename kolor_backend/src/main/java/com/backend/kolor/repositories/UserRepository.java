package com.backend.kolor.repositories;

import com.backend.kolor.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "Select * from user_table where email = :email", nativeQuery = true)
    Optional<User> findUserByEmail(@Param("email") String email);

    @Query(value = "Select * from user_table where username = :username", nativeQuery = true)
    Optional<User> findUserByUsername(@Param("username") String username);
}


