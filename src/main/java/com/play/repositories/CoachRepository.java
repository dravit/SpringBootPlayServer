package com.play.repositories;

import com.play.objects.Coach;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by dgup27 on 3/15/2017.
 */
public interface CoachRepository extends MongoRepository<Coach, String> {

    Coach save(Coach coach);

    /*@Query(value = "{ 'emailID' : ?0}", fields = "{ 'coach.email' : 1 }")
    List<Coach> findByEmailID(int userId, int questionID);*/

    Coach findCoachByLoginEmail(String loginEmail);
}
