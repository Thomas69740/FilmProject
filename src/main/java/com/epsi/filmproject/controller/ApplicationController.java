package com.epsi.filmproject.controller;

import com.epsi.filmproject.entity.User;
import com.epsi.filmproject.entity.UserFavoris;
import com.epsi.filmproject.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

/**
 * Created by Gildasftw on 20/09/2017.
 */
@CrossOrigin(origins = "*")
@RestController
public class ApplicationController {

    @Autowired
    ApplicationService service;

    @RequestMapping(value="/api/favoris/{userId}", method=RequestMethod.GET)
    public List<UserFavoris> getUserFavoris(@PathVariable("userId") Long userId) {
        List<UserFavoris> favs = service.getUserFavoris(userId);
        return favs;
    }

    @RequestMapping(value="/api/favoris/{favorisId}", method=RequestMethod.DELETE)
    public void removeFavoris(@PathVariable("favorisId") Long favorisId) {
        service.removeFavoris(favorisId);
    }

    @RequestMapping(value="/api/favoris", method=RequestMethod.POST)
    public ResponseEntity addFavoris(@RequestBody Map<String, String> params) {
        boolean favorisAlreadyThere = service.isFavorisAlreadyThere(Long.parseLong(params.get("userid")), Long.parseLong(params.get("movieid")));

        if (favorisAlreadyThere) {
            return new ResponseEntity<>(HttpStatus.IM_USED);
        }
        else {
            service.addFavoris(Long.parseLong(params.get("userid")),
                    Long.parseLong(params.get("movieid")),
                    params.get("titre"),
                    params.get("dtsortie"),
                    params.get("image"),
                    params.get("note"));
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @RequestMapping(value="/api/user/create", method=RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody Map<String, String> params) {
        boolean userExist = service.isUserExist(params.get("username"));

        if (userExist) {
            return new ResponseEntity<>(HttpStatus.IM_USED);
        }
        else {
            User ret = service.createUser(params.get("username"), params.get("password"));
            return new ResponseEntity<>(ret, HttpStatus.OK);
        }
    }

    @RequestMapping(value="/api/user/{username}/{password}", method=RequestMethod.POST)
    public ResponseEntity connectUser(@PathVariable("username") String username, @PathVariable("password") String password) {
        User u  = service.canConnectUser(username, password);

        if (u != null) {
            return new ResponseEntity<>(u, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
