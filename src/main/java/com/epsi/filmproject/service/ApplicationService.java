package com.epsi.filmproject.service;

import com.epsi.filmproject.entity.User;
import com.epsi.filmproject.entity.UserFavoris;
import com.epsi.filmproject.repository.UserFavorisRepository;
import com.epsi.filmproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Gildasftw on 20/09/2017.
 */
public class ApplicationService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserFavorisRepository userFavorisRepository;

    public void removeFavoris(Long userId) {
        User user = userRepository.findOne(userId);
        UserFavoris userFav = userFavorisRepository.findOne(user.getId());
        userFavorisRepository.delete(userFav);
    }

    public void addFavoris(Long userId, Long filmId) {
        UserFavoris fav = new UserFavoris();
        fav.setUserId(userId);
        fav.setFilmId(filmId);
        userFavorisRepository.save(fav);
    }

    public User getUserByLogin(String login) {
        User user = userRepository.findByLogin(login);
        return user;
    }
}
