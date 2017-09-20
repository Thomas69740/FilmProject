package com.epsi.filmproject.repository;

import com.epsi.filmproject.entity.UserFavoris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Gildasftw on 20/09/2017.
 */

@Repository
public interface UserFavorisRepository extends JpaRepository<UserFavoris, Long> {
    List<UserFavoris> findByUserId(Long userId);
}
