package com.play.services;

import com.play.objects.Coach;
import org.springframework.stereotype.Service;

/**
 * Created by dgup27 on 3/15/2017.
 */
public interface CoachService {

    Coach findById(String id);

    Coach save(Coach coach);
}
