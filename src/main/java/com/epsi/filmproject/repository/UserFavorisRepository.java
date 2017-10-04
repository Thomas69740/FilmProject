package com.epsi.filmproject.repository;

import com.epsi.filmproject.entity.UserFavoris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Gildasftw on 20/09/2017.
 */

@Repository
public interface UserFavorisRepository extends JpaRepository<UserFavoris, Long> {
    List<UserFavoris> findByUserId(Long userId);

    @Query("SELECT uf FROM UserFavoris uf WHERE uf.id = :favorisId")
    UserFavoris findById(@Param("favorisId") Long favorisId);

    @Query("SELECT uf FROM UserFavoris uf WHERE uf.userId = :userid AND uf.filmId = :movieid")
    UserFavoris findByUserIdAndMovieId(@Param("userid") Long userid, @Param("movieid") Long movieid);
}
