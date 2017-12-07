package com.example.demo6.service;

import com.example.demo6.model.StudentWork;
import com.example.demo6.repository.StudentWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * File comments...
 *
 * @author Kenny Fang
 * @version 1.0
 * @date 2017/9/18 16:26
 */
@Service
public class StudentWorkService {
    @Autowired
    private StudentWorkRepository studentWorkRepository;


    public void save(StudentWork studentWork) {
        studentWorkRepository.save(studentWork);
    }
}
