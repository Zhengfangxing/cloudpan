package com.chinasofti.cloudpan;

import com.chinasofti.cloudpan.dao.FileUploadDao;
import com.chinasofti.cloudpan.domain.File;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudpanApplicationTests {
    @Autowired
    private FileUploadDao fileUploadDao;
    @Test
    public void contextLoads() {
        File file = new File();
        file.setFsrc("....");
        file.setFuploadDate(new Date());
        file.setUid(11);
        fileUploadDao.save(file);
    }

}
