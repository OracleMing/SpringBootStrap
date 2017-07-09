package com.wxm.service;

import com.wxm.bean.Student;
import com.wxm.entity.StudentEntity;
import com.wxm.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Created by OracleMing from IMSE of BUAA.
 * @Time 2017-07-08-17:16.
 * @Description ${Description}
 */
@Service
public class StudentService {

    public static final String CHECK_SUCCESS = "y";
    public static final String CHECK_FAIL = "n";
    public static final String NULL_STUDENT_NAME = "nsn";
    public static final String WRONG_PASSWORD = "wp";
    @Autowired
    private StudentDao studentDao;

    public String registerService(Student student) {

        if (studentDao.findByStudentName(student.getStudentName()) == null) {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setEmail(student.getEmail());
            studentEntity.setPassword(student.getPassword());
            studentEntity.setStudentName(student.getStudentName());
            studentEntity.setSex(student.getSex());
            studentDao.save(studentEntity);
            return CHECK_SUCCESS;
        }
        return CHECK_FAIL;
    }

    public String loginService(Student student){
        StudentEntity studentEntity = studentDao.findByStudentName(student.getStudentName());
        if (studentEntity == null)
            return NULL_STUDENT_NAME;
        else if (!studentEntity.getPassword().equals(student.getPassword()))
            return WRONG_PASSWORD;
        return CHECK_SUCCESS;
    }

}
