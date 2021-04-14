package com.mo16.springaop.javaconfig.aopexample.services;

import com.mo16.springaop.javaconfig.aopexample.annotiations.Transactional;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class StudentServiceImpl implements StudentService {

    @Transactional
    @Override
    public void enroll(String studentId, String courseId) {
        if("123".equals(studentId)) throw new RuntimeException("failed to enroll");
        System.out.println("Manage Student Enrollment Saga");
    }
}
