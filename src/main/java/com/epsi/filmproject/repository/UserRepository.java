package com.epsi.filmproject.repository;

import com.epsi.filmproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Gildasftw on 20/09/2017.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

    @Query("SELECT count(u) FROM User u WHERE u.login = :login")
    Long countUserByLogin(@Param("login") String login);

    @Query("SELECT u FROM User u WHERE u.login = :login AND u.motdepasse = :password")
    User canConnectUser(@Param("login") String login, @Param("password") String password);
}
