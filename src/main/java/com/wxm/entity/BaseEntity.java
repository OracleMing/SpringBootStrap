package com.wxm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Created by OracleMing from IMSE of BUAA.
 * @Time 2017-07-08-0:23.
 * @Description 基本实体，包括序列化声明、主键、创建日期
 */
@MappedSuperclass
public class BaseEntity implements Serializable{

    protected static final long serialVersionUID = 1L;

    /**
     * 此处主键生成策略改用IDENTITY，
     * 否则MySql下易出现用外表“hibernate_sequence”记录主键的情况。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(strategy="identity", name="id")
    private Integer id;

    private String createDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
