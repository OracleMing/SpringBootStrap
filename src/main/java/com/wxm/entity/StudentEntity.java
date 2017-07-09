package com.wxm.entity;

import javax.persistence.*;

/**
 * @Author Created by OracleMing from IMSE of BUAA.
 * @Time 2017-07-07-21:10.
 * @Description 学生信息实体
 */
@Entity
@Table(name = "student")
public class StudentEntity extends BaseEntity{

    private String studentName;

    private String password;

    private String sex;

    private String email;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
