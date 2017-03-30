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
@RequestMapping("/coach")
public class CoachController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoachController.class);

    CoachService coachService;

    @Autowired
    CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @RequestMapping(value = "/registerCoach", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Coach registerUser(@RequestBody @Valid Coach coach) {
        return coachService.save(coach);
    }

    @RequestMapping(value = "/getCoach", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.FOUND)
    Coach getCoach(@RequestBody @Valid Coach coach) {
        System.out.println("Coming here to check"+coach.getLoginEmail());
        Coach returnCoach = coachService.findByCoach(coach);
        if(returnCoach != null) {

            System.out.println("returnCoach>>>>>>>>>>>>"+returnCoach.getGoogleDisplayName()+">>>"+returnCoach.getLoginEmail());
            return returnCoach;
        } else {
            System.out.printf("Coach is not present");
            return null;
        }
    }

    @RequestMapping(value = "/updateCoachDetails", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    Coach updateCoachDetails(@RequestBody @Valid Coach coach) {
        System.out.println("coach>>>>>>>>>."+coach.getId());
        return coachService.save(coach);
    }
}
