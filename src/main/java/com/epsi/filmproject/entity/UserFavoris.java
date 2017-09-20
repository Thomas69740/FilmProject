package com.epsi.filmproject.entity;

import javax.persistence.*;

/**
 * Created by Gildasftw on 20/09/2017.
 */
@Entity
@Table(name="userfavoris")
public class UserFavoris {

    @Id
    @GeneratedValue
    @Column(name="id")
    public Long id;

    @Column(name="user_id")
    public Long userId;

    @Column(name="film_id")
    public Long filmId;

    public Long getId() {
        return this.id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public Long getFilmId() {
        return this.filmId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }
}
