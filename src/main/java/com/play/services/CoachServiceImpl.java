package com.play.services;

import com.play.objects.Coach;
import com.play.repositories.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Coach save(Coach coach) {
        return coachRepository.save(coach);
    }
}
