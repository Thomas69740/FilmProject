package com.epsi.filmproject.entity;

import javax.persistence.*;

/**
 * Created by Gildasftw on 20/09/2017.
 */
@Entity
@Table(name="utilisateur")
public class User {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="login")
    private String login;

    @Column(name="motdepasse")
    private String motdepasse;

    public Long getId() {
        return this.id;
    }

    public String getLogin() {
        return this.login;
    }

    public String getMotDePasse() {
        return this.motdepasse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        this.motdepasse = motDePasse;
    }
}
