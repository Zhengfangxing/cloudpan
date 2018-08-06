package com.chinasofti.cloudpan.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author William D X Zheng
 * @date 2018/8/7 0:57
 */
@Entity
@Table(name = "t_product",schema = "db_cloudpan")
public class Product {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @Column
    private Date uploadDate;

    @Column
    private String fileName;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
