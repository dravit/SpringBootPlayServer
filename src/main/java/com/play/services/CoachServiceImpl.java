package com.play.services;

import com.play.objects.Coach;
import com.play.repositories.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Created by dgup27 on 3/15/2017.
 */
@Service
@Transactional
public class CoachServiceImpl implements CoachService {

    CoachRepository coachRepository;

    @Autowired
    CoachServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public Coach findById(String id) {
        return coachRepository.findOne(id);
    }

    @Override
    public Coach findByCoach(Coach coach) {
        String loginEmail = coach.getLoginEmail();
        boolean inValidEmail = StringUtils.isEmpty(loginEmail);
        System.out.printf("validEmail>>>>>>>>>>."+inValidEmail);
        if(inValidEmail) {
            loginEmail = "";
        }
        if(!inValidEmail) {
            System.out.println("finding coach>>>>>>>>>>>>>>.");
            return  coachRepository.findCoachByLoginEmail(loginEmail);
        } else {
            return null;
        }
    }

    @Override
    public Coach save(Coach coach) {
        return coachRepository.save(coach);
    }
}
