package com.epsi.filmproject.service;

import com.epsi.filmproject.entity.User;
import com.epsi.filmproject.entity.UserFavoris;
import com.epsi.filmproject.repository.UserFavorisRepository;
import com.epsi.filmproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gildasftw on 20/09/2017.
 */
@Service
public class ApplicationService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserFavorisRepository userFavorisRepository;

    public void removeFavoris(Long favorisId) {
        UserFavoris userFav = userFavorisRepository.findById(favorisId);
        userFavorisRepository.delete(userFav);
    }

    public User createUser(String login, String password) {
        User u = new User();
        u.setLogin(login);
        u.setMotDePasse(password);
        User ret = userRepository.save(u);
        return ret;
    }

    public List<UserFavoris> getUserFavoris(Long userId) {
        List<UserFavoris> favs = userFavorisRepository.findByUserId(userId);
        return favs;
    }
    public User canConnectUser(String login, String password) {
        User ret = userRepository.canConnectUser(login, password);
        return ret;
    }
    public void addFavoris(Long userId, Long filmId, String titre, String dtSortie, String imageLink, String note) {
        UserFavoris fav = new UserFavoris();
        fav.setUserId(userId);
        fav.setFilmId(filmId);
        fav.setTitre(titre);
        fav.setDtSortie(dtSortie);
        fav.setImage(imageLink);
        fav.setNote(note);
        userFavorisRepository.save(fav);
    }

    public boolean isFavorisAlreadyThere(Long userid, Long movieid) {
        UserFavoris uf = userFavorisRepository.findByUserIdAndMovieId(userid, movieid);

        return uf != null ? true : false;
    }
    public User getUserByLogin(String login) {
        User user = userRepository.findByLogin(login);
        return user;
    }

    public boolean isUserExist(String login) {
        Long ret = userRepository.countUserByLogin(login);

        return ret > 0 ? true : false;
    }
}
