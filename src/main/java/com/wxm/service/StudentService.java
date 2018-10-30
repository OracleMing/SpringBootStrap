package com.wxm.service;

import com.wxm.bean.Student;
import com.wxm.entity.StudentEntity;
import com.wxm.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public String loginService(Student student) {
        StudentEntity studentEntity = studentDao.findByStudentName(student.getStudentName());
        if (studentEntity == null) {
            return NULL_STUDENT_NAME;
        } else if (!studentEntity.getPassword().equals(student.getPassword())) {
            return WRONG_PASSWORD;
        }
        return CHECK_SUCCESS;
    }

    public static String encryptMsg(String msg, int[] key, int count) {
        char[] oldArray = msg.toCharArray();
        char[] newArray = new char[msg.length()];
        while (count > 0) {

            for (int index = 0; index < msg.length(); index++) {
                newArray[index] = oldArray[key[index]];
            }

            oldArray = newArray;
            count--;
        }

        return Arrays.toString(newArray);
    }

    public static void getHr(int x) {
        int matureNum = 1;
        List<Integer> newHrList = new ArrayList<>();

        while (x > 0) {
            /**
             * 更新新晋的HR时长
             */
            for (int newHrIndex = 0, newHrNum = newHrList.size(); newHrIndex < newHrNum; newHrIndex++) {
                if (newHrList.get(newHrIndex) + 1 == 4) {
                    newHrList.remove(newHrIndex);
                    matureNum++;
                } else {
                    newHrList.set(newHrIndex, newHrList.get(newHrIndex) + 1);
                }
            }
            /**
             * 添加新招的HR
             */
            for (int count = 0; count < matureNum; count++) {
                newHrList.add(1);
            }

            x--;
        }
        System.out.println(matureNum);
        System.out.println(newHrList.size());
    }

}
