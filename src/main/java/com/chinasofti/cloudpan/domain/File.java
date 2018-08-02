package com.chinasofti.cloudpan.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author William D X Zheng
 * @date 2018/8/2 17:39
 */
@Entity
@Table(name = "t_file",schema = "cloudpan")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;

    @Column
    private String fsrc;

    @Column
    @DateTimeFormat
    private Date fuploadDate;

    @Column
    private Integer uid;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFsrc() {
        return fsrc;
    }

    public void setFsrc(String fsrc) {
        this.fsrc = fsrc;
    }

    public Date getFuploadDate() {
        return fuploadDate;
    }

    public void setFuploadDate(Date fuploadDate) {
        this.fuploadDate = fuploadDate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
