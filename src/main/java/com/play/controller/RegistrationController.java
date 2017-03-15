package com.play.controller;

import com.play.objects.Coach;
import com.play.services.CoachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by dgup27 on 3/15/2017.
 */
@RestController
@RequestMapping("/play/register")
public class RegistrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    CoachService coachService;

    @Autowired
    RegistrationController(CoachService coachService) {
        this.coachService = coachService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Coach registerUser(@RequestBody @Valid Coach coach) {
        return coachService.save(coach);
    }
}
