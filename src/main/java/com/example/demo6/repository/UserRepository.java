package com.example.demo6.repository;

import com.example.demo6.model.StudentWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo6.model.User;

import java.util.List;

/**
 * File comments...
 *
 * @author Kenny Fang
 * @version 1.0
 * @date 2017/9/15 19:49
 */
@Repository
public class UserRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(User user) {
        Id id =  user.getClass().getAnnotation(Id.class);
        mongoTemplate.save(user);
    }

    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }
}
