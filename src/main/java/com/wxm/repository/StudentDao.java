package com.wxm.repository;

import com.wxm.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Created by OracleMing from IMSE of BUAA.
 * @Time 2017-07-07-22:55.
 * @Description ${Description}
 */
@Repository
public interface StudentDao extends JpaRepository<StudentEntity, Integer> {

    List<StudentEntity> findBySex(String sex);

    StudentEntity findByStudentName(String studentName);

}
