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

    @Column(name="titre")
    public String titre;

    @Column(name="dt_sortie")
    public String dtSortie;

    @Column(name="note")
    public String note;

    @Column(name="image")
    public String image;

    public Long getId() {
        return this.id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public Long getFilmId() {
        return this.filmId;
    }

    public String getTitre() {return this.titre;}

    public String getDtSortie() {return this.dtSortie;}

    public String getNote() {return this.note;}

    public String getImage() {return this.image;}

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public void setTitre(String titre) {this.titre = titre;}

    public void setDtSortie(String dtSortie) {this.dtSortie = dtSortie;}

    public void setNote(String note) {this.note = note;}

    public void setImage(String image) {this.image = image;}
}
