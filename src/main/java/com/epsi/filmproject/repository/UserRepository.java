package com.epsi.filmproject.repository;

import com.epsi.filmproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Gildasftw on 20/09/2017.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
