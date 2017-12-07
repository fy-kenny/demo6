package com.example.demo6.repository;

import com.example.demo6.model.StudentWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * File comments...
 *
 * @author Kenny Fang
 * @version 1.0
 * @date 2017/9/18 16:23
 */
@Repository
public class StudentWorkRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(StudentWork studentWork) {
        mongoTemplate.save(studentWork);
    }
}
