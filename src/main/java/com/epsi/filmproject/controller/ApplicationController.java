package com.epsi.filmproject.controller;

import com.epsi.filmproject.service.ApplicationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Gildasftw on 20/09/2017.
 */
@RestController
public class ApplicationController {

    ApplicationService service;

    @RequestMapping(value="/api/user", method= RequestMethod.GET)
    public String test() {
        return "Hello World !";
    }
}
